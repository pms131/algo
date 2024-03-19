package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CutRollCakeTest {
    public static final CutRollCake cutRollCake = new CutRollCake();

    @Test
    void solution_1() {
        //given
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int expected = 2;

        //when
        int answer = cutRollCake.solution(topping);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int[] topping = {1, 2, 3, 1, 4}	;
        int expected = 0;

        //when
        int answer = cutRollCake.solution(topping);

        //then
        assertEquals(expected, answer);
    }
}