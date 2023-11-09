package programmers;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FindLargeNumberBehindTest {
    public static final FindLargeNumberBehind findLargeNumberBehind = new FindLargeNumberBehind();

    @Test
    void solution() {
        //given
        int[] numbers1 = {2, 3, 3, 5};
        int[] numbers2 = {9, 1, 5, 3, 6, 2};

        int[] expected1 = {3, 5, 5, -1};
        int[] expected2 = {-1, 5, 6, 6, -1, -1};
        
        //when
        int[] answer1 = findLargeNumberBehind.solution(numbers1);
        int[] answer2 = findLargeNumberBehind.solution(numbers2);

        //then
        IntStream.range(0, expected1.length).forEach(idx -> assertEquals(expected1[idx], answer1[idx]));
        IntStream.range(0, expected2.length).forEach(idx -> assertEquals(expected2[idx], answer2[idx]));

    }
}