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

        numbers = numbers.replace(SpecialCharacterConstant.ESCAPE_LINE, SpecialCharacterConstant.DELIMETER);
        String[] tokens = numbers.split(SpecialCharacterConstant.DELIMETER);

        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
                sum += num;
        }
        return sum;
    }
}
