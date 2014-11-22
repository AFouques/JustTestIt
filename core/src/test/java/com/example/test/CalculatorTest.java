package com.example.test;

import com.example.Calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static final int INTERNAL_VALUE = 2;
    private static final int RIGHT_OPERANDE = 1;
    private static final int WRONG_DIVIDE_OPERANDE = 0;

    private static final int SUM_UP_RESULT = 3;
    private static final int SUBSTRACT_RESULT = 1;
    private static final int DIVIDE_RESULT = 2;

    protected Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(INTERNAL_VALUE);
    }

    @Test
    public void testSumUpReturnsCorrectResult() {
        int result = calculator.sumUp(RIGHT_OPERANDE);

        assert (result == SUM_UP_RESULT);
    }

    @Test
    public void testSubstractReturnsCorrectResult() {
        int result = calculator.substract(RIGHT_OPERANDE);

        assert (result == SUBSTRACT_RESULT);
    }

    @Test
    public void testMultiplyReturnsCorrectResult() {
        float result = calculator.divide(RIGHT_OPERANDE);

        assert (result == DIVIDE_RESULT);
    }

    @Test(expected = ArithmeticException.class)
    public void testMultiplyThrowsExceptionIfOperandeIsZero() {
        calculator.divide(WRONG_DIVIDE_OPERANDE);
    }

    @After
    public void tearDown() {
        //no op
    }
}
