package com.codecool.generalizedfizzbuzz.service.division;

import com.codecool.generalizedfizzbuzz.model.Operator;

public class DivisionServiceImpl implements DivisionService {
    @Override
    public boolean canDivide(int number, Operator op, int... divisors) {
        for (int divisor :
                divisors) {
            if (op == Operator.And) {
                if (number % divisor != 0) {
                    return false;
                }
            } else {
                if (number % divisor == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean canDivide(int number, int divisor) {
        return number % divisor == 0;
    }
}
