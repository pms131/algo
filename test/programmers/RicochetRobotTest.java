package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RicochetRobotTest {

    private static final RicochetRobot ricochetRobot = new RicochetRobot();
    @Test
    void solution() {
        //given
        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};

        int expected1 = 7;
        int expected2 = -1;

        //when
        int answer1 = ricochetRobot.solution(board1);
        int answer2 = ricochetRobot.solution(board2);

        //then
        assertEquals(expected1, answer1);
        assertEquals(expected2, answer2);
    }
}