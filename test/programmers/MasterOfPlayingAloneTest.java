package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasterOfPlayingAloneTest {
    private static final MasterOfPlayingAlone masterOfPlayingAlone = new MasterOfPlayingAlone();

    @Test
    void solution_1() {
        //given
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        int expected = 12;

        //when
        int answer = masterOfPlayingAlone.solution(cards);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 1;

        //when
        int answer = masterOfPlayingAlone.solution(cards);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_3() {
        //given
        int[] cards = {3, 4, 2, 1};
        int expected = 0;

        //when
        int answer = masterOfPlayingAlone.solution(cards);

        //then
        assertEquals(expected, answer);
    }
}