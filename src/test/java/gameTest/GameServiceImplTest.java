package gameTest;

import com.codecool.generalizedfizzbuzz.model.GameRule;
import com.codecool.generalizedfizzbuzz.model.GameSpecification;
import com.codecool.generalizedfizzbuzz.model.Operator;
import com.codecool.generalizedfizzbuzz.service.division.DivisionService;
import com.codecool.generalizedfizzbuzz.service.division.DivisionServiceImpl;
import com.codecool.generalizedfizzbuzz.service.game.GameService;
import com.codecool.generalizedfizzbuzz.service.game.GameServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceImplTest {
    private DivisionService divisionService = new DivisionServiceImpl();
    private GameService gameService = new GameServiceImpl(divisionService);

    @Test
    void getFizz() {
        int chosenNumber = 6;
        List<GameRule> gameRuleList = List.of(
                new GameRule(Operator.And, "FizzBuzz", 3, 5),
                new GameRule("Fizz", 3),
                new GameRule("Buzz", 5)
        );

        String keywordFinal = gameService.play(chosenNumber, new GameSpecification(gameRuleList));

        assertEquals("Fizz", keywordFinal);
    }

    @Test
    void getBuzz() {
        int chosenNumber = 10;
        List<GameRule> gameRuleList = List.of(
                new GameRule(Operator.And, "FizzBuzz", 3, 5),
                new GameRule("Buzz", 5),
                new GameRule("Fizz", 3)
        );

        String keywordFinal = gameService.play(chosenNumber, new GameSpecification(gameRuleList));

        assertEquals("Buzz", keywordFinal);
    }

    @Test
    void getFizzBuzz() {
        int chosenNumber = 15;
        List<GameRule> gameRuleList = List.of(
                new GameRule("Buzz", 5),
                new GameRule("Fizz", 3),
                new GameRule(Operator.And, "FizzBuzz", 3, 5),
                new GameRule("Nothing", 8),
                new GameRule("Nothing", 4)
        );

        String keywordFinal = gameService.play(chosenNumber, new GameSpecification(gameRuleList));

        assertEquals("FizzBuzz", keywordFinal);
    }

    @Test
    void getNothing() {
        int chosenNumber = 13;
        List<GameRule> gameRuleList = List.of(
                new GameRule("Buzz", 5),
                new GameRule("Fizz", 3),
                new GameRule(Operator.And, "FizzBuzz", 3, 5)
        );

        String keywordFinal = gameService.play(chosenNumber, new GameSpecification(gameRuleList));

        assertEquals("Game Lost!", keywordFinal);
    }
}
