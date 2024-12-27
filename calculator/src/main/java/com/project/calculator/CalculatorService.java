package com.project.calculator;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CalculatorService {

    public int add(String numbers) {
        if (StringUtil.isNullOrEmpty(numbers)) {
            return 0;
        }
        //will update later
        return 0;
    }
}
