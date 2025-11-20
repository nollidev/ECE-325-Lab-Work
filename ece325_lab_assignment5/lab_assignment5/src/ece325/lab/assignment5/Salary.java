package ece325.lab.assignment5;

public class Salary {
	
	/**
	 * Returns the amount of pay a band member will get (in dollars). This amount is
	 * computed by deducting the amount spent on snacks from the base salary, and
	 * then computing and adding the bonus (if any) over that amount. So, if a band
	 * member earned 100 dollars, spent 50 on snacks, and earned a bonus of 10 (%),
	 * their total pay will be 55 dollars.
	 * 
	 * Note: The current implementation of this method is extremely buggy and can
	 * easily be abused by anyone.
	 * 
	 * @param salary       The base salary earned by this band member during this
	 *                     salary period (in dollars).
	 * @param snacksAmount The total amount spent by this band member on snacks
	 *                     during this salary period (in dollars).
	 * @param bonus        The bonus percentage that the band member earned this
	 *                     salary period (in percentage).
	 * @return the amount of pay a band member will get (in dollars)
	 */
	public static Double pay(Double salary, Double snacksAmount, Integer bonus) {
		// First constraint: salary must not exceed $1,000
		// 	it also must not be a negative value
		final int MINIMUMSALARY = 0;
		final int MAXIMUMSALARY = 1000;
		
		if (salary < MINIMUMSALARY || salary > MAXIMUMSALARY) { 
			throw new IllegalArgumentException("Invalid base salary. Should be between $0-$1000"); 
		}
		
		// Second constraint: the bonus can only be a percentage between 0 and 10
		final int MINIMUMBONUS = 0;
		final int MAXIMUMBONUS = 10;
		
		if (bonus < MINIMUMBONUS || bonus > MAXIMUMBONUS) {
			throw new IllegalArgumentException("Invalid bonus. Should be between 0%-10%.");
		}
		
		// Third constraint: the amount spent on snacks should not exceed the salary
		//	it also cannot be a negative value
		final int MINIMUMSNACKS = 0;
		final double MAXIMUMSNACKS = salary;
		
		if (snacksAmount < MINIMUMSNACKS || snacksAmount > MAXIMUMSNACKS) {
			throw new IllegalArgumentException("Invalid snack amount. Should not exceed salary.");
		}
		
		// TODO: find out if these can/should be implemented as an enum
		
		double coefficient = 1 + bonus.doubleValue() / 100;
		
		return (salary - snacksAmount) * coefficient;
	}
}
