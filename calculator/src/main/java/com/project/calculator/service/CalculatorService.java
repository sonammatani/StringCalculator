package com.project.calculator.service;

import ch.qos.logback.core.util.StringUtil;
import com.project.calculator.constant.SpecialCharacterConstant;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(String numbers) {
        if (StringUtil.isNullOrEmpty(numbers)) {
            return 0;
        }

        String delimiter = SpecialCharacterConstant.DELIMETER;
        if (numbers.startsWith(SpecialCharacterConstant.BACK_SLASH)) {
            int delimiterIndex = numbers.indexOf(SpecialCharacterConstant.ESCAPE_LINE);
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        numbers = numbers.replace(delimiter, SpecialCharacterConstant.DELIMETER);
        String[] tokens = numbers.split(SpecialCharacterConstant.DELIMETER);

        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
                sum += num;
        }
        return sum;
    }

}
