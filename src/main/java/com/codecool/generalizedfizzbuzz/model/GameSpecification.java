package com.codecool.generalizedfizzbuzz.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public record GameSpecification(List<GameRule> gameRuleList) {
    public GameSpecification(List<GameRule> gameRuleList) {
        this.gameRuleList = gameRuleList;
    }

    public List<GameRule> getGameRuleList() {
        List<GameRule> nulls = gameRuleList.stream().filter(e -> e.getOperator() == null).toList();
        List<GameRule> nonNulls = gameRuleList.stream().filter(e -> e.getOperator() != null).toList();

        List<GameRule> sorted = new ArrayList<>(nonNulls);
        for (GameRule nullOperator :
                nulls) {
            sorted.add(nullOperator);
        }
        return sorted;
    }
}
