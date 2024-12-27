package com.project.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testEmptyString() {
        int result = calculatorService.add("");
        assertEquals(0, result);
    }
}
