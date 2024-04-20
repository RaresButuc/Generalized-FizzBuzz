package com.codecool.generalizedfizzbuzz.service.division;

import com.codecool.generalizedfizzbuzz.model.Operator;

public interface DivisionService {
    boolean canDivide(int number, Operator op, int... divisors);
    boolean canDivide(int number, int divisor);
}
