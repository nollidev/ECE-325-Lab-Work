package ece325.lab.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;

class TestSalary {
	
	private final double DELTA = 0.001D;
	
	@Test
	void common() {
		assertEquals(525, Salary.pay(900D, 400D, 5), DELTA);
		assertEquals(55, Salary.pay(100D, 50D, 10), DELTA);
		assertEquals(416.922, Salary.pay(420.69D, 41.67D, 10), DELTA);
	}
	
	@Test
	void edgeBaseLow() {
		assertEquals(0, Salary.pay(0D,0D,10), DELTA);
		assertThrows(IllegalArgumentException.class, () -> { 
			Salary.pay(-0.01D, 0D, 0);
		});
	}
	
	@Test
	void edgeBaseHigh() {
		assertEquals(1100, Salary.pay(1000D, 0D, 10), DELTA);
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(1000.01D, 0D, 0);
		});
	}
	
	@Test
	void edgeSnacksLow() {
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(500D, -0.01D, 0);
		});
	}
	
	@Test
	void edgeSnacksHigh() {
		assertEquals(0, Salary.pay(5.00D, 5.00D, 10));
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(5.00D, 5.01D, 0);
		});
	}
	
	@Test
	void edgeBonusLow() {
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(0D, 0D, -1);
		});
	}
	
	@Test
	void edgeBonusHigh() {
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(0D, 0D, 11);
		});
	}
	
	@Test
	void nullability() {
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(null, 100D, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(100D, null, 10);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(400D, 100D, null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(null, null, null);
		});
	}
}