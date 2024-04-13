package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FatigueTest {
    private static final Fatigue fatigue = new Fatigue();

    @Test
    void solution() {
        //given
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int expected = 3;

        //when
        int answer = fatigue.solution(k, dungeons);

        //then
        assertEquals(expected, answer);
    }
}