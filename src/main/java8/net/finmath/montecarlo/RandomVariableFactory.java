package net.finmath.montecarlo;

import net.finmath.stochastic.RandomVariable;

/**
 * A factory for creating objects implementing <code>net.finmath.stochastic.RandomVariable</code>.
 *
 * Use this interface in your implementations to allow <i>dependency injection</i>, i.e. to allow the use
 * of different implementations of <code>net.finmath.stochastic.RandomVariable</code> whenever random variables
 * need to be constructed.
 *
 * @see net.finmath.stochastic.RandomVariable
 *
 * @author Christian Fries
 * @version 1.0
 */
public interface RandomVariableFactory {

	/**
	 * Create a (deterministic) random variable from a constant.
	 *
	 * @param value A constant value.
	 * @return The <code>RandomVariable</code>.
	 */
	RandomVariable createRandomVariable(double value);

	/**
	 * Create a (deterministic) random variable from a constant using a specific filtration time.
	 *
	 * @param time The filtration time of the random variable.
	 * @param value A constant value.
	 * @return The <code>RandomVariable</code>.
	 */
	RandomVariable createRandomVariable(double time, double value);

	/**
	 * Create a random variable from an array using a specific filtration time.
	 *
	 * @param time The filtration time of the random variable.
	 * @param values Array representing values of the random variable at the sample paths.
	 * @return The <code>RandomVariable</code>.
	 */
	RandomVariable createRandomVariable(double time, double[] values);

	/**
	 * Create an array of (deterministic) random variables from an array of constants.
	 *
	 * @param values Array representing constants.
	 * @return The <code>RandomVariable</code>.
	 */
	RandomVariable[] createRandomVariableArray(double[] values);

	/**
	 * Create a matrix of (deterministic) random variables from an matrix of constants.
	 *
	 * @param values Matrix representing constants.
	 * @return The <code>RandomVariable</code>.
	 */
	RandomVariable[][] createRandomVariableMatrix(double[][] values);
}
