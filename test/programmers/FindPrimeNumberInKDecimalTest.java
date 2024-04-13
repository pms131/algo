package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimeNumberInKDecimalTest {
    private static final FindPrimeNumberInKDecimal findPrimeNUmberInKDecimal = new FindPrimeNumberInKDecimal();

    @Test
    void solution_1() {
        //given
        int n = 437674;
        int k = 3;
        int expected = 3;

        //when
        int answer = findPrimeNUmberInKDecimal.solution(n, k);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int n = 110011;
        int k = 10;
        int expected = 2;

        //when
        int answer = findPrimeNUmberInKDecimal.solution(n, k);

        //then
        assertEquals(expected, answer);
    }
}