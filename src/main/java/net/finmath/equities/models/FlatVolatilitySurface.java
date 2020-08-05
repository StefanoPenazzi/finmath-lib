package net.finmath.equities.models;

import java.time.LocalDate;
import net.finmath.equities.marketdata.*;
import java.util.ArrayList;

/**
 * This class implements the volatility interfaces for a flat volatility surface.
 * 
 * @author Andreas Grotz
 */

public class FlatVolatilitySurface  implements IVolatilitySurface, IShiftedVolatilitySurface {
	
	private final double volatility;
	private final double volShift;
	
	public FlatVolatilitySurface(double volatility) {
		this(volatility, 0.0);
	}
	
	public FlatVolatilitySurface(double volatility, double volShift) {
		this.volatility = volatility;
		this.volShift = volShift;
	}
	
	public IShiftedVolatilitySurface getShiftedSurface(double shift) {
		assert volShift == 0.0 : "Surface is already shifted";
		return new FlatVolatilitySurface(this.volatility, shift);
	}
	
	public double getShift() {
		return volShift;
	}
	
	public double getVolatility(
			double strike, 
			LocalDate expiryDate, 
			IEquityForwardStructure currentForwardStructure)
	{
		return volatility + volShift;
	}

	public double getVolatility(double strike, double timeToMaturity, IEquityForwardStructure currentForwardStructure) {
		return volatility + volShift;
	}
	
	public double getLocalVolatility(
			double strike, 
			LocalDate expiryDate, 
			IEquityForwardStructure currentForwardStructure,
			double strikeShift,
			double timeShift)
	{
		return volatility + volShift;
	}
	
	public double getLocalVolatility(
			double logStrike, 
			double timeToMaturity,
			IEquityForwardStructure currentForwardStructure,
			double strikeShift,
			double timeShift)
	{
		return volatility + volShift;
	}
	
	public void calibrate(
			IEquityForwardStructure forwardStructure,
			ArrayList<VolatilityPoint> volaPoints) 
	{
		assert false : "A flat surface cannot be calibrated";
	}
}