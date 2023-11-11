package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertingNumbersTest {
    public static final ConvertingNumbers convertingNumbers = new ConvertingNumbers();

    @Test
    void solution_sample1() {
        //given
        int x = 10;
        int y = 40;
        int n = 5;

        int expected = 2;

        //when
        int answer = convertingNumbers.solution(x, y, n);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_sample2() {
        //given
        int x = 10;
        int y = 40;
        int n = 30;

        int expected = 1;

        //when
        int answer = convertingNumbers.solution(x, y, n);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_sample3() {
        //given
        int x = 2;
        int y = 5;
        int n = 4;

        int expected = -1;

        //when
        int answer = convertingNumbers.solution(x, y, n);

        //then
        assertEquals(expected, answer);
    }
}