package programmers;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkAssignmentTest {

    static final WorkAssignment workAssignment = new WorkAssignment();

    @Test
    void solution() {
        //given
        String[][] plans1 = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] plans3 = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[][] plans4 = {{"aaa", "12:00", "30"}, {"bbb", "12:10", "30"}, {"ccc", "14:00", "10"}};
        String[][] plans5 = {{"aaa", "12:00", "30"}, {"bbb", "14:10", "30"}, {"ccc", "14:00", "10"}};
        String[][] plans6 = {{"A", "11:50", "30"}, {"B", "13:00", "20"}, {"C", "13:10", "30"}};


        String[] expected1 = {"korean", "english", "math"};
        String[] expected2 = {"science", "history", "computer", "music"};
        String[] expected3 = {"bbb", "ccc", "aaa"};
        String[] expected4 = {"bbb", "aaa", "ccc"};
        String[] expected5 = {"aaa", "ccc", "bbb"};
        String[] expected6 = {"A", "C", "B"};

        //when
        String[] answer1 = workAssignment.solution(plans1);
        String[] answer2 = workAssignment.solution(plans2);
        String[] answer3 = workAssignment.solution(plans3);
        String[] answer4 = workAssignment.solution(plans4);
        String[] answer5 = workAssignment.solution(plans5);
        String[] answer6 = workAssignment.solution(plans6);

        //then
        IntStream.range(0, answer1.length).forEach(i -> assertEquals(expected1[i], answer1[i]));
        IntStream.range(0, answer2.length).forEach(i -> assertEquals(expected2[i], answer2[i]));
        IntStream.range(0, answer3.length).forEach(i -> assertEquals(expected3[i], answer3[i]));
        IntStream.range(0, answer4.length).forEach(i -> assertEquals(expected4[i], answer4[i]));
        IntStream.range(0, answer5.length).forEach(i -> assertEquals(expected5[i], answer5[i]));
        IntStream.range(0, answer6.length).forEach(i -> assertEquals(expected6[i], answer6[i]));
    }
}