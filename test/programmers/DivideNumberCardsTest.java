package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideNumberCardsTest {
    public static final DivideNumberCards divideNumberCards = new DivideNumberCards();

    @Test
    void solution_1() {
        //given
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};

        int expected = 0;

        //when
        int answer = divideNumberCards.solution(arrayA, arrayB);

        //then
        assertEquals(expected, answer);
    }
    @Test

    void solution_2() {
        //given
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};

        int expected = 10;

        //when
        int answer = divideNumberCards.solution(arrayA, arrayB);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_3() {
        //given
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

        int expected = 7;

        //when
        int answer = divideNumberCards.solution(arrayA, arrayB);

        //then
        assertEquals(expected, answer);
    }
}