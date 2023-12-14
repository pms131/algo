package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicElevatorTest {
    public static final MagicElevator magicElevator = new MagicElevator();

    @Test
    void solution_sample1() {
        //given
        int storey = 16;
        int expected = 6;

        //when
        int answer = magicElevator.solution(storey);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_sample2() {
        //given
        int storey = 2554;
        int expected = 16;

        //when
        int answer = magicElevator.solution(storey);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_sample3() {
        //given
        int storey = 666;
        int expected = 11;

        //when
        int answer = magicElevator.solution(storey);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_sample4() {
        //given
        int storey = 555;
        int expected = 14;

        //when
        int answer = magicElevator.solution(storey);

        //then
        assertEquals(expected, answer);
    }
}


/*
* 555 560 600 1000
* 5 4 4 1
*
* */