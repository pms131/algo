package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruncateNSquaredArrayTest {
    private static final TruncateNSquaredArray truncateNSquaredArray = new TruncateNSquaredArray();

    @Test
    void solution_1() {
        //given
        int n = 3;
        int left = 2;
        int right = 5;
        int[] expected = {3, 2, 2, 3};

        //when
        int[] answer = truncateNSquaredArray.solution(n, left, right);

        //then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int n = 4;
        int left = 7;
        int right = 14;
        int[] expected = {4, 3, 3, 3, 4, 4, 4, 4};

        //when
        int[] answer = truncateNSquaredArray.solution(n, left, right);

        //then
        assertArrayEquals(expected, answer);
    }
}