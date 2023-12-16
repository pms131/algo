package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenceGameTest {
    public static final DefenceGame defenceGame = new DefenceGame();

    @Test
    void solution_sample1() {
        //given
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int expected = 5;

        //when
        int solution = defenceGame.solution(n, k, enemy);

        //then
        assertEquals(expected, solution);
    }

    @Test
    void solution_sample2() {
        //given
        int n = 7;
        int k = 3;
        int[] enemy = {3, 3, 3, 3};
        int expected = 4;

        //when
        int solution = defenceGame.solution(n, k, enemy);

        //then
        assertEquals(expected, solution);
    }

    @Test
    void solution_sample3() {
        //given
        int n = 7;
        int k = 3;
        int[] enemy = {3, 3, 2, 4, 6, 7, 8, 1};
        int expected = 5;

        //when
        int solution = defenceGame.solution(n, k, enemy);

        //then
        assertEquals(expected, solution);

        /*
        * 3 -> 무적권
        * 3 -> 무적권
        * 1 -> 무적권
        * 4 -> 1보다 작네? 처치 무적권 1 빼
        * 6 -> 3보다 작네? 무적권 and 3 하나 빼 (4명 처치)
        * 7 -> 3 뺐을때, 7이네? 무적권 끝
        * 8 -> 4하나 뺐지만 n - 4 < 0이므로 끝
        * */
    }

    @Test
    void solution_sample4() {
        //given
        int n = 10;
        int k = 3;
        int[] enemy = {12, 11, 4, 2, 1, 5, 8, 6, 7};
        int expected = 6;

        //when
        int solution = defenceGame.solution(n, k, enemy);

        //then
        assertEquals(expected, solution);
    }
}