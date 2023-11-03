package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetweenTwoCirclesTest {

    @Test
    void solution() {
        //given
//        int expected = 20;
        int expected = 12;

        int r1 = 1;
        int r2 = 2;

        //when
        long answer = BetweenTwoCircles.solution(r1, r2);

        //then
        assertEquals(expected, answer);
    }
}