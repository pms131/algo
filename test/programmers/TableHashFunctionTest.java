package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableHashFunctionTest {
    public static final TableHashFunction tableHashFunction = new TableHashFunction();

    @Test
    void solution() {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int expected = 4;

        int solution = tableHashFunction.solution(data, col, row_begin, row_end);

        assertEquals(expected, solution);
    }
}