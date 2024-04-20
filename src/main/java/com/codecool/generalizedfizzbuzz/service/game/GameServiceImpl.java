package com.codecool.generalizedfizzbuzz.service.game;

import com.codecool.generalizedfizzbuzz.model.GameRule;
import com.codecool.generalizedfizzbuzz.model.GameSpecification;
import com.codecool.generalizedfizzbuzz.service.division.DivisionService;

public class GameServiceImpl implements GameService {
    private final DivisionService divisionService;

    public GameServiceImpl(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @Override
    public String play(int number, GameSpecification spec) {
        for (GameRule gameRule :
                spec.getGameRuleList()) {
            if (gameRule.getOperator() == null && divisionService.canDivide(number, gameRule.getDivisors()[0])) {
                return gameRule.getKeyword();
            } else if (gameRule.getOperator() != null && divisionService.canDivide(number, gameRule.getOperator(), gameRule.getDivisors())) {
                return gameRule.getKeyword();
            }
        }
        return "Game Lost!";
    }
}
