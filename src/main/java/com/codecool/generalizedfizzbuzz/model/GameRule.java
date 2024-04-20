package com.codecool.generalizedfizzbuzz.model;

import java.util.Arrays;

public class GameRule {

    private final Operator operator;
    private final String keyword;
    private final int[] divisors;

    public GameRule(Operator operator, String keyword, int... divisors) {
        this.operator = operator;
        this.keyword = keyword;
        this.divisors = divisors;
    }

    public GameRule(String keyword, int divisor) {
        this.operator = null;
        this.keyword = keyword;
        this.divisors = new int[]{divisor};
    }

    public Operator getOperator() {
        return operator;
    }

    public String getKeyword() {
        return keyword;
    }

    public int[] getDivisors() {
        return divisors;
    }

    @Override
    public String toString() {
        return "GameRule{" +
                "operator=" + operator +
                ", keyword='" + keyword + '\'' +
                ", divisors=" + Arrays.toString(divisors) +
                '}';
    }
}
