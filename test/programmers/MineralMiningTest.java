package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineralMiningTest {
    static MineralMining mineralMining = new MineralMining();

    @Test
    void solution() {
        //given
        int[] picks1 = {1, 3, 2};
        int[] picks2 = {0, 1, 1};
        int[] picks3 = {0, 0, 1};


        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        String[] minerals3 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone", "stone", "stone"};
        String[] minerals4 = {"stone", "stone", "stone", "stone", "stone", "diamond"};

        int expected1 = 12;
        int expected2 = 50;
        int expected3 = 14;
        int expected4 = 5;

        //when
        int answer1 = mineralMining.solution(picks1, minerals1);
        int answer2 = mineralMining.solution(picks2, minerals2);
        int answer3 = mineralMining.solution(picks1, minerals3);
        int answer4 = mineralMining.solution(picks3, minerals4);

        //then
        assertEquals(expected1, answer1);
        assertEquals(expected2, answer2);
        assertEquals(expected3, answer3);
        assertEquals(expected4, answer4);
    }
}