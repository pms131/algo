package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfPartialSequencesTest {
    static SumOfPartialSequences sumOfPartialSequences = new SumOfPartialSequences();

    @Test

    void solution() {
        //given
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int[] sequence3 = {2, 2, 2, 2, 2};


        int[] sum = {7, 5, 6};

        int[][] expected = {{2, 3}, {6, 6}, {0, 2}};

        //when

        int[] answer = sumOfPartialSequences.solution(sequence1, sum[0]);
        int[] answer2 = sumOfPartialSequences.solution(sequence2, sum[1]);
        int[] answer3 = sumOfPartialSequences.solution(sequence3, sum[2]);

        //then
        assertEquals(answer[0], expected[0][0]);
        assertEquals(answer[1], expected[0][1]);

        assertEquals(answer2[0], expected[1][0]);
        assertEquals(answer2[1], expected[1][1]);

        assertEquals(answer3[0], expected[2][0]);
        assertEquals(answer3[1], expected[2][1]);

    }
}