// url : https://programmers.co.kr/learn/courses/30/lessons/77484

package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetLottoMinMaxRanks {

    private static final int[] RANKS = {6, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        /*
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        */

        /*
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        */

        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] answer = solution(lottos, win_nums);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> lottoList = Arrays.stream(lottos).sorted().boxed().collect(Collectors.toList());
        List<Integer> winNumsList = Arrays.stream(win_nums).sorted().boxed().collect(Collectors.toList());

        long cnt = lottoList.stream().map(lottoNum -> {
            return winNumsList.stream().filter(winNum -> winNum.equals(lottoNum)).findAny().orElseGet(() -> 0);
        }).filter(integer -> !integer.equals(0)).mapToInt(i -> i).count();

        long zeroCnt = lottoList.stream().filter(integer -> integer.equals(0)).count();

        answer[0] = RANKS[(int) (cnt + zeroCnt)];
        answer[1] = RANKS[(int) cnt];

        return answer;
    }
}
