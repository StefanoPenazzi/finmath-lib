/*
 * Created on 22.11.2009
 */
package net.finmath.montecarlo.interestrate.products.indices;

import java.util.Arrays;
import java.util.Set;

import net.finmath.exception.CalculationException;
import net.finmath.montecarlo.interestrate.LIBORModelMonteCarloSimulationModel;
import net.finmath.montecarlo.interestrate.products.components.AbstractProductComponent;
import net.finmath.stochastic.RandomVariable;

/**
 * A minumum index.
 *
 * Provides the function min(index1(t), index2(t), ...).
 *
 * @author Christian Fries
 * @version 1.2
 */
public class MinIndex extends AbstractIndex {

	private static final long serialVersionUID = -1512137372132830198L;

	private final AbstractProductComponent[] indexArguments;

	/**
	 * Creates the function min(index1(t), index2(t), ...)
	 *
	 * @param indexArguments An arguments list of <code>AbstractProductComponent</code>s or an array thereof. A minimum number of 2 arguments is required.
	 */
	public MinIndex(final AbstractProductComponent... indexArguments) {
		super();
		if(indexArguments.length < 1) {
			throw new IllegalArgumentException("Missing arguments. Please provide one or more arguments.");
		}
		this.indexArguments = indexArguments;
	}

	@Override
	public RandomVariable getValue(final double evaluationTime, final LIBORModelMonteCarloSimulationModel model) throws CalculationException {
		RandomVariable value = indexArguments[0].getValue(evaluationTime, model);
		for(final AbstractProductComponent index : indexArguments) {
			value = value.cap(index.getValue(evaluationTime, model));
		}
		return value;
	}

	@Override
	public Set<String> queryUnderlyings() {
		Set<String> underlyingNames = null;
		for(final AbstractProductComponent product : indexArguments) {
			final Set<String> productUnderlyingNames = product.queryUnderlyings();
			if(productUnderlyingNames != null) {
				if(underlyingNames == null) {
					underlyingNames = productUnderlyingNames;
				} else {
					underlyingNames.addAll(productUnderlyingNames);
				}
			}
		}
		return underlyingNames;
	}

	@Override
	public String toString() {
		return "MinIndex [indexArguments=" + Arrays.toString(indexArguments)
		+ "]";
	}
}
