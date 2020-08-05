package net.finmath.equities.pricer;

import java.util.HashMap;
import org.apache.commons.lang3.NotImplementedException;
import net.finmath.time.daycount.DayCountConvention;
import net.finmath.equities.marketdata.*;
import net.finmath.equities.models.*;
import net.finmath.equities.pricer.EquityPricingRequest.CalculationRequestType;
import net.finmath.equities.products.*;

/**
 * This class implements analytic pricing formulas for European options under a 
 * Black-Scholes process with Buehler dividends.
 * 
 * @author Andreas Grotz
 */

public class AnalyticOptionPricer implements IOptionPricer
{
	
	private final DayCountConvention dcc;
	
	public AnalyticOptionPricer(
			DayCountConvention dcc) {
		this.dcc = dcc;
	}
	
	public EquityPricingResult calculate(
			EquityPricingRequest request,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface)
	{
		var results = new HashMap<CalculationRequestType, Double>();
		for (var calcType  : request.calcsRequested)
			results.put(calcType, calculate(request.option, forwardStructure, discountCurve, volaSurface, calcType));
		
		return new EquityPricingResult(request, results);
	}
	
	
	public double calculate(
			IOption option,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface,
			CalculationRequestType calcType)
	{
		assert !option.isAmericanOption() : "Analytic pricer cannot handle American options.";
		var valDate = forwardStructure.getValuationDate();
		var expiryDate = option.getExpiryDate();
		var ttm = dcc.getDaycountFraction(forwardStructure.getValuationDate(), expiryDate);
		var forward = forwardStructure.getForward(expiryDate);
		var discountFactor = discountCurve.getDiscountFactor(expiryDate);
		//var repoRate = forwardStructure.getRepoCurve().getRate(expiryDate);
		var repoRate = discountCurve.getRate(expiryDate);
		var adjustedForward = forwardStructure.getDividendAdjustedStrike(forward, expiryDate);
		var adjustedStrike = forwardStructure.getDividendAdjustedStrike(option.getStrike(), expiryDate);
		var volatility = volaSurface.getVolatility(
			option.getStrike(), 
			option.getExpiryDate(),
			forwardStructure);
		
		switch(calcType)
		{
        case Price:
        	return Black76Model.optionPrice(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				volatility,
				option.isCallOption(),
				discountFactor * adjustedForward);
        case EqDelta:
        	var dFdS = forwardStructure.getGrowthDiscountFactor(valDate, expiryDate);
        	return dFdS * Black76Model.optionDelta(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				volatility,
				option.isCallOption(),
				discountFactor);
        case EqGamma:
        	var dFdS2 = Math.pow(forwardStructure.getGrowthDiscountFactor(valDate, expiryDate), 2);
        	return dFdS2 * Black76Model.optionGamma(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				volatility,
				option.isCallOption(),
				discountFactor / adjustedForward);
        case EqVega:
        	return Black76Model.optionVega(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				volatility,
				option.isCallOption(),
				discountFactor * adjustedForward);
        case Theta:
        	return Black76Model.optionTheta(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				volatility,
				option.isCallOption(),
				discountFactor * adjustedForward,
				repoRate)
        	- repoRate * Black76Model.optionPrice(
    				1.0,
    				adjustedStrike / adjustedForward,
    				ttm,
    				volatility,
    				option.isCallOption(),
    				discountFactor * adjustedForward);
        default:
        	throw new NotImplementedException("Calculation for " + calcType + " not implemented yet.");
        } 
	}
	
	public double getPrice(
		IOption option,
		IEquityForwardStructure forwardStructure,
		FlatYieldCurve discountCurve,
		IVolatilitySurface volaSurface)
	{
		return calculate(
			option,
			forwardStructure,
			discountCurve,
			volaSurface,
			CalculationRequestType.Price);
	}
	
	public double getDelta(
			IOption option,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface)
	{
		return calculate(
			option,
			forwardStructure,
			discountCurve,
			volaSurface,
			CalculationRequestType.EqDelta);
	}
	
	public double getGamma(
			IOption option,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface)
	{
		return calculate(
			option,
			forwardStructure,
			discountCurve,
			volaSurface,
			CalculationRequestType.EqGamma);
	}
	
	public double getVega(
			IOption option,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface)
	{
		return calculate(
			option,
			forwardStructure,
			discountCurve,
			volaSurface,
			CalculationRequestType.EqVega);
	}
	
	public double getTheta(
			IOption option,
			IEquityForwardStructure forwardStructure,
			FlatYieldCurve discountCurve,
			IVolatilitySurface volaSurface)
	{
		return calculate(
			option,
			forwardStructure,
			discountCurve,
			volaSurface,
			CalculationRequestType.Theta);
	}
	
	public double getImpliedVolatility(
		IOption option,
		IEquityForwardStructure forwardStructure,
		FlatYieldCurve discountCurve,
		double price)
	{
		assert !option.isAmericanOption() : "Analytic pricer cannot handle American options.";
		var expiryDate = option.getExpiryDate();
		var ttm = dcc.getDaycountFraction(forwardStructure.getValuationDate(), expiryDate);
		var forward = forwardStructure.getForward(expiryDate);
		var discount = discountCurve.getDiscountFactor(expiryDate);
		var adjustedForward = forwardStructure.getDividendAdjustedStrike(forward, expiryDate);
		var adjustedStrike = forwardStructure.getDividendAdjustedStrike(option.getStrike(), expiryDate);
		var undiscountedPrice = price / discount / adjustedForward;
		
		return Black76Model.optionImpliedVolatility(
				1.0,
				adjustedStrike / adjustedForward,
				ttm,
				undiscountedPrice,
				option.isCallOption());
	}
}