package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RotateMatrixBordersTest {

    private static final RotateMatrixBorders rotateMatrixBorders = new RotateMatrixBorders();

    @Test
    void solution_1() {
        //given
        int rows = 6;
        int cols = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] expected = {8, 10, 25};

        //when
        int[] actual = rotateMatrixBorders.solution(rows, cols, queries);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void solution_2() {
        //given
        int rows = 3;
        int cols = 3;
        int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[] expected = {1, 1, 5, 3};

        //when
        int[] actual = rotateMatrixBorders.solution(rows, cols, queries);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void solution_3() {
        //given
        int rows = 100;
        int cols = 97;
        int[][] queries = {{1, 1, 100, 97}};
        int[] expected = {1};

        //when
        int[] actual = rotateMatrixBorders.solution(rows, cols, queries);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void solution_4() {
        //given
        int rows = 5;
        int cols = 5;
        int[][] queries = {{1, 1, 2, 1}, {2, 1, 3, 1}};
        int[] expected = {1, 1};

        //when
        int[] actual = rotateMatrixBorders.solution(rows, cols, queries);

        //then
        assertArrayEquals(expected, actual);
    }
}