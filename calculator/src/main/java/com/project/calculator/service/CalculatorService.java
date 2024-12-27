package com.project.calculator.service;

import ch.qos.logback.core.util.StringUtil;
import com.project.calculator.constant.SpecialCharacterConstant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    public int add(String numbers) {

        if (StringUtil.isNullOrEmpty(numbers)) {
            return 0;
        }

        numbers = replaceDelimiters(numbers);

        String[] tokens = numbers.split(SpecialCharacterConstant.DELIMETER);

        return calculateSum(tokens);
    }

    private String replaceDelimiters(String numbers) {
        String delimiter = SpecialCharacterConstant.DELIMETER;
        if (numbers.startsWith(SpecialCharacterConstant.BACK_SLASH)) {
            int delimiterIndex = numbers.indexOf(SpecialCharacterConstant.ESCAPE_LINE);
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        numbers = numbers.replace(delimiter, SpecialCharacterConstant.DELIMETER);
        numbers = numbers.replace(SpecialCharacterConstant.ESCAPE_LINE, SpecialCharacterConstant.DELIMETER);
        return numbers;
    }

    private int calculateSum(String[] tokens) {
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                negatives.add(num);
            } else {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
        return sum;
    }

}
