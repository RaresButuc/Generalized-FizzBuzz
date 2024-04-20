package serviceTest.divisionTest;

import com.codecool.generalizedfizzbuzz.model.GameRule;
import com.codecool.generalizedfizzbuzz.model.Operator;
import com.codecool.generalizedfizzbuzz.service.division.DivisionService;
import com.codecool.generalizedfizzbuzz.service.division.DivisionServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionServiceImplTest {
    private final DivisionService divisionService = new DivisionServiceImpl();

    @Test
    void getFizz() {
        int chosenNumber = 6;
        GameRule gameRule = new GameRule("Fizz", 3);

        String fizzOrNot = divisionService.canDivide(chosenNumber, gameRule.getDivisors()[0]) ? gameRule.getKeyword() : "notFizz";

        assertEquals(gameRule.getKeyword(), fizzOrNot);
    }

    @Test
    void getBuzz() {
        int chosenNumber = 10;
        GameRule gameRule = new GameRule("Buzz", 5);

        String fizzOrNot = divisionService.canDivide(chosenNumber, gameRule.getDivisors()[0]) ? gameRule.getKeyword() : "notFizz";

        assertEquals(gameRule.getKeyword(), fizzOrNot);
    }

    @Test
    void getFizzBuzzWithAnd() {
        int chosenNumber = 15;
        int[] divisors = new int[]{3, 5};
        GameRule gameRule = new GameRule(Operator.And, "FizzBuzz", divisors);

        String fizzBuzzOrNot = divisionService.canDivide(chosenNumber, gameRule.getOperator(), gameRule.getDivisors()) ? gameRule.getKeyword() : "notFizzBuzz";

        assertEquals(gameRule.getKeyword(), fizzBuzzOrNot);
    }

    @Test
    void getErrorFizzBuzzWithAnd() {
        int chosenNumber = 15;
        int[] divisors = new int[]{7, 5};
        GameRule gameRule = new GameRule(Operator.And, "FizzBuzz", divisors);

        String fizzBuzzOrNot = divisionService.canDivide(chosenNumber, gameRule.getOperator(), gameRule.getDivisors()) ? gameRule.getKeyword() : "notFizzBuzz";

        assertEquals("notFizzBuzz", fizzBuzzOrNot);
    }

    @Test
    void getErrorFizzBuzzWithOr() {
        int chosenNumber = 15;
        int[] divisors = new int[]{7, 6};
        GameRule gameRule = new GameRule(Operator.Or, "FizzOrBuzz", divisors);

        String fizzBuzzOrNot = divisionService.canDivide(chosenNumber, gameRule.getOperator(), gameRule.getDivisors()) ? gameRule.getKeyword() : "notFizzOrBuzz";

        assertEquals("notFizzOrBuzz", fizzBuzzOrNot);
    }

    @Test
    void getFizzWithOr() {
        int chosenNumber = 15;
        int[] divisors = new int[]{3, 6};
        GameRule gameRule = new GameRule(Operator.Or, "Fizz", divisors);

        String fizzBuzzOrNot = divisionService.canDivide(chosenNumber, gameRule.getOperator(), gameRule.getDivisors()) ? gameRule.getKeyword() : "notFizzOrBuzz";

        assertEquals(gameRule.getKeyword(), fizzBuzzOrNot);
    }
}
