package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PickTangerineTest {
    private static final PickTangerine pickTangerine = new PickTangerine();

    @Test
    void solution1() {
        //given
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 6;

        int expected = 3;

        //when
        int answer = pickTangerine.solution(k, tangerine);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution2() {
        //given
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 4;

        int expected = 2;

        //when
        int answer = pickTangerine.solution(k, tangerine);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution3() {
        //given
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        int k = 2;

        int expected = 1;

        //when
        int answer = pickTangerine.solution(k, tangerine);

        //then
        assertEquals(expected, answer);
    }
}