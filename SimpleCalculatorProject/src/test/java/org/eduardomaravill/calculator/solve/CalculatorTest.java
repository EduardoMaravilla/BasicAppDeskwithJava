package org.eduardomaravill.calculator.solve;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate() {
        assertEquals(2,calculator.calculate("1+1"));
        assertEquals(2,calculator.calculate("-1*-1"));
        assertEquals(-2.0,calculator.calculate("-1-1"));
        assertInstanceOf(Double.class,calculator.calculate("2.5+3.6"));
        ArithmeticException arithmeticException=assertThrows(ArithmeticException.class,() -> new Calculator().calculate("2+3/0"));
        assertEquals("You cannot divide by zero",arithmeticException.getMessage());
    }
}