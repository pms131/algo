package programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DesertIslandTravelTest {
    public static final DesertIslandTravel desertIslandTravel = new DesertIslandTravel();

    @Test
    void solution() {
        //given
        String[] maps1 = {"X591X","X1X5X","X231X", "1XXX1"};
        String[] maps2 = {"XXX","XXX","XXX"};
        String[] maps3 = {"X5XX5X", "111111", "XXXXXX", "111111"};

        int[] expected1 = {1, 1, 27};
        int[] expected2 = {-1};
        int[] expected3 = {6, 16};

        //when
//        int[] answerList1 = desertIslandTravel.solution(maps1);
//        int[] answerList2 = desertIslandTravel.solution(maps2);
        int[] answerList3= desertIslandTravel.solution(maps3);

        //then
//        IntStream.range(0, answerList1.length).forEach(i -> assertEquals(expected1[i], answerList1[i]));
//        IntStream.range(0, answerList2.length).forEach(idx -> assertEquals(expected2[idx], answerList2[idx]));
        IntStream.range(0, answerList3.length).forEach(idx -> assertEquals(expected3[idx], answerList3[idx]));

    }
}