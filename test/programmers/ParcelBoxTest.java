package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    public static final ParcelBox parcelBox = new ParcelBox();

    @Test
    void solution_1() {
        //given
        int[] order = {4, 3, 1, 2, 5};
        int expected = 2;

        //when
        int answer = parcelBox.solution(order);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int[] order = {5, 4, 3, 2, 1};
        int expected = 5;

        //when
        int answer = parcelBox.solution(order);

        //then
        assertEquals(expected, answer);
    }
}