package com.codecool.generalizedfizzbuzz.ui;

import com.codecool.generalizedfizzbuzz.model.GameRule;
import com.codecool.generalizedfizzbuzz.model.GameSpecification;
import com.codecool.generalizedfizzbuzz.model.Operator;
import com.codecool.generalizedfizzbuzz.service.game.GameService;

import java.util.*;


public class FizzBuzzGameUi {
    private final GameService gameService;
    private final Scanner scanner = new Scanner(System.in);

    public FizzBuzzGameUi(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        System.out.println("Choose a number!");
        int number = getNumber();
        GameSpecification spec = createGameSpecification();

        String result = gameService.play(number, spec);
        System.out.println(result);
    }

    private GameSpecification createGameSpecification() {
        System.out.println("Specify the size of Game Specifications!");
        int size = getNumber();

        List<GameRule> gameRuleList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Choose the " + (i + 1) + "# GameRule");
            System.out.println("Should it have an Operator?");
            String res = scanner.next();

            Operator operator = null;
            if (Objects.equals(res, "yes")) {
                System.out.println("Which operator?");
                String response = scanner.next();
                operator = Operator.valueOf(response);
            }

            System.out.println("Which keyword should it return?");
            String keyword = scanner.next();

            List<Integer> divisorsList = new ArrayList<>();
            int divisor = 0;
            if (operator == null) {
                System.out.println("Choose a divisor");
                divisor = getNumber();
            } else {
                System.out.println("Choose the divisors");
                String[] divisorsNumbers = scanner.next().split(",");
                for (String number :
                        divisorsNumbers) {
                    divisorsList.add(Integer.parseInt(number));
                }
            }
            int[] divisorsArray = divisorsList.stream().mapToInt(k -> k).toArray();

            if (operator == null) {
                gameRuleList.add(new GameRule(keyword, divisor));
            } else {
                gameRuleList.add(new GameRule(operator, keyword, divisorsArray));
            }
        }
        for (GameRule gameRule :
                gameRuleList) {
            System.out.println(gameRule.toString());
        }
        return new GameSpecification(gameRuleList);
    }

    private int getNumber() {
        return scanner.nextInt();
    }
}
