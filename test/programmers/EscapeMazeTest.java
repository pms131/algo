package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EscapeMazeTest {
    public static final EscapeMaze escapeMaze = new EscapeMaze();

    @Test
    void solution() {
        //given
        String[] maps1 = {"SEOOO","XXXXO","OOOOO","OXXXX","OOOOL"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        String[] maps3 = {"SOOOO","XXXXO","OOOOO","LXOXX","XOOOE"};
        String[] maps4 = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        String[] maps5 = {"XXXXXL", "XXXXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        String[] maps6 = {"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"};
        String[] maps7 = {"SOOOO", "XXXXO", "OOOOO", "XXXXO", "XXXXL", "EOOOX"};

        int expected1 = 31;
        int expected2 = -1;
        int expected3 = 18;
        int expected4 = 14;
        int expected5 = 22;
        int expected6 = -1;
        int expected7 = -1;

        //when
        /*int answer1 = escapeMaze.solution(maps1);
        int answer2 = escapeMaze.solution(maps2);
        int answer3 = escapeMaze.solution(maps3);
        int answer4 = escapeMaze.solution(maps4);
        int answer5 = escapeMaze.solution(maps5);
        int answer6 = escapeMaze.solution(maps6);*/
        int answer7 = escapeMaze.solution(maps7);

        //then
//        assertEquals(expected1, answer1);
//        assertEquals(expected2, answer2);
//        assertEquals(expected3, answer3);
//        assertEquals(expected4, answer4);
//        assertEquals(expected5, answer5);
//        assertEquals(expected6, answer6);
        assertEquals(expected7, answer7);
    }
}