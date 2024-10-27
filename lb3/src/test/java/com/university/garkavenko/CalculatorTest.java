package com.university.garkavenko;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertTrue(Double.compare(calculator.add(2.0, 3.0), 5.0) == 0);
        assertTrue(Double.compare(calculator.add(-2.0, 1.0), -1.0) == 0);
    }

    @Test
    public void testSubtract() {
        assertTrue(Double.compare(calculator.subtract(3.0, 2.0), 1.0) == 0);
        assertTrue(Double.compare(calculator.subtract(-2.0, 1.0), -3.0) == 0);
    }

    @Test
    public void testMultiply() {
        assertTrue(Double.compare(calculator.multiply(2.0, 3.0), 6.0) == 0);
        assertTrue(Double.compare(calculator.multiply(0.0, 5.0), 0.0) == 0);
    }

    @Test
    public void testDivide() {
        assertTrue(Double.compare(calculator.divide(6.0, 3.0), 2.0) == 0);
        assertTrue(Double.compare(calculator.divide(-6.0, 3.0), -2.0) == 0);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1.0, 0.0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testInvalidOperation() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            throw new InvalidInputException("Invalid operation entered.");
        });
        assertEquals("Invalid operation entered.", exception.getMessage());
    }
}
