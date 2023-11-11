package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeesawMatesTest {
    public static final SeesawMates seesawMates = new SeesawMates();


    @Test
    void solution_test1() {
        //given
        int[] weights = {100, 180, 360, 100, 270};
        int expected = 4;

        //when
        long answer = seesawMates.solution(weights);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_test2() {
        //given
        int[] weights = {100, 100, 100, 100, 100};
        int expected = 10;

        //when
        long answer = seesawMates.solution(weights);

        //then
        assertEquals(expected, answer);
    }
}