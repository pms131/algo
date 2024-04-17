package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckDistancingTest {
    private static final CheckDistancing checkDistancing = new CheckDistancing();

    @Test
    void solution() {
        //given
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] expected = {1, 0, 1, 1, 1};

        //when
        int[] actual = checkDistancing.solution(places);

        //then
        assertArrayEquals(expected, actual);
    }
}