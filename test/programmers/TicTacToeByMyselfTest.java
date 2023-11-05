package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeByMyselfTest {
    public static final TicTacToeByMyself ticTacToeByMyself = new TicTacToeByMyself();

    @Test
    void solution() {
        //given
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};
        String[] board5 = {"OOO", "XOX", "OXX"};


        int expected1 = 1;
        int expected2 = 0;
        int expected3 = 0;
        int expected4 = 1;
        int expected5 = 1;

        //when
        int answer1 = ticTacToeByMyself.solution(board1);
        int answer2 = ticTacToeByMyself.solution(board2);
        int answer3 = ticTacToeByMyself.solution(board3);
        int answer4 = ticTacToeByMyself.solution(board4);
        int answer5 = ticTacToeByMyself.solution(board5);

        //then
        assertEquals(expected1, answer1);
        assertEquals(expected2, answer2);
        assertEquals(expected3, answer3);
        assertEquals(expected4, answer4);
        assertEquals(expected5, answer5);

    }
}