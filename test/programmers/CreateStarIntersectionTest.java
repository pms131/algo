package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateStarIntersectionTest {
    private static final CreateStarIntersection createStarIntersection = new CreateStarIntersection();

    @Test
    void solution_1() {
        //given
        int[][] lines = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] expected = {"....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"};

        //when
        String[] answer = createStarIntersection.solution(lines);

        //then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        int[][] lines = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}	;
        String[] expected = {"*.*"};

        //when
        String[] answer = createStarIntersection.solution(lines);

        //then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution_3() {
        //given
        int[][] lines = {{1, -1, 0}, {2, -1, 0}};
        String[] expected = {"*"};

        //when
        String[] answer = createStarIntersection.solution(lines);

        //then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution_4() {
        //given
        int[][] lines = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
        String[] expected = {"*"};

        //when
        String[] answer = createStarIntersection.solution(lines);

        //then
        assertArrayEquals(expected, answer);
    }
}