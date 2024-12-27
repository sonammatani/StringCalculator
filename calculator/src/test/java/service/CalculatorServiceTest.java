package service;

import com.project.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testEmptyString() {
        int result = calculatorService.add("");
        assertEquals(0, result);
    }

    @Test
    public void testInputWithPositiveCommaSeparated() {
        int result = calculatorService.add("1,2,3");
        assertEquals(6, result);
    }

    @Test
    public void testInputWithEscapeCharacter() {
        int result = calculatorService.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void testSupportDifferentDelimiters() {
        assertEquals(3, calculatorService.add("//;\n1;2"));
        assertEquals(6, calculatorService.add("//|\n1|2|3"));
    }

    @Test
    void testNegativeNumbersThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculatorService.add("1,-2,3,-4"));
        assertTrue(exception.getMessage().contains("Negative numbers not allowed: [-2, -4]"));
    }

    @Test
    void testMultipleNegativeNumbersInExceptionMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculatorService.add("-1,-2,-3"));
        assertTrue(exception.getMessage().contains("Negative numbers not allowed: [-1, -2, -3]"));
    }

}
