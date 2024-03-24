package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoQueuesSumToSameTest {
    private static final TwoQueuesSumToSame twoQueuesSumToSame = new TwoQueuesSumToSame();

    @Test
    void solution_1() {
        //given
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int expected = 2;

        //when
        int answer = twoQueuesSumToSame.solution(queue1, queue2);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        int expected = 7;

        //when
        int answer = twoQueuesSumToSame.solution(queue1, queue2);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_3() {
        //given
        int[] queue1 = {3, 2, 7, 21, 1};
        int[] queue2 = {1, 5};
        int expected = -1;

        //when
        int answer = twoQueuesSumToSame.solution(queue1, queue2);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_4() {
        //given
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        int expected = -1;

        //when
        int answer = twoQueuesSumToSame.solution(queue1, queue2);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_5() {
        //given
        int[] queue1 = {2, 4};
        int[] queue2 = {6, 8, 10};
        int expected = -1;

        //when
        int answer = twoQueuesSumToSame.solution(queue1, queue2);

        //then
        assertEquals(expected, answer);
    }
}