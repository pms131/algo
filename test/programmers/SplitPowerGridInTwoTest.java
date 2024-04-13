package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitPowerGridInTwoTest {
    private static final SplitPowerGridInTwo splitPowerGridInTwo = new SplitPowerGridInTwo();

    @Test
    void solution_1() {
        //given
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int expected = 3;

        //when
        int answer = splitPowerGridInTwo.solution(n, wires);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int expected = 0;

        //when
        int answer = splitPowerGridInTwo.solution(n, wires);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_3() {
        //given
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int expected = 1;

        //when
        int answer = splitPowerGridInTwo.solution(n, wires);

        //then
        assertEquals(expected, answer);
    }
}