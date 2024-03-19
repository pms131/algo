package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HaliSequenceIntegralTest {
    public static final HaliSequenceIntegral haliSequenceIntegral = new HaliSequenceIntegral();

    @Test
    void solution_1() {
        //given
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};

        double[] expected = {33.0,31.5,0.0,-1.0};

        //when
        double[] answer = haliSequenceIntegral.solution(k, ranges);

        //then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int k = 3;
        int[][] ranges = {{0,0}, {1,-2}, {3,-3}};

        double[] expected = {47.0,36.0,12.0};

        //when
        double[] answer = haliSequenceIntegral.solution(k, ranges);

        //then
        assertArrayEquals(expected, answer);
    }
}