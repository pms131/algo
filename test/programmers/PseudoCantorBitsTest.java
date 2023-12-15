package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PseudoCantorBitsTest {
    public static final PseudoCantorBits pseudoCantorBits = new PseudoCantorBits();

    @Test
    void solution() {

        //given
        int n = 4;
        long l = 4;
        long r = 10000000L + (long) Math.pow(5, 13);
        int expected = 8;

        //when
        int solution = pseudoCantorBits.solution(n, l, r);

        //then
        assertEquals(expected, solution);
    }
}