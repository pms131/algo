package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfPartialSequenceTest {

    public static final NumberOfPartialSequence numberOfPartialSequence = new NumberOfPartialSequence();

    @Test
    void solution() {
        //given
        int[] elements = {7, 9, 1, 1, 4};
        int expected = 18;

        //when
        int answer = numberOfPartialSequence.solution(elements);

        //then
        assertEquals(expected, answer);
    }
}