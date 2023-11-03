package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterceptSystemTest {

    static int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {0, 1}};

    @Test
    void solution() {
        //given
        int expected = 3;

        //when
        int result = InterceptSystem.solution(targets);

        //then
        assertEquals(expected, result);
    }
}