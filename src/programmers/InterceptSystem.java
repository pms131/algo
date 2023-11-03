package programmers;

import java.util.Arrays;

/**
 * 요격 시스템.
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=java>programmers</a>
 */
public class InterceptSystem {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        solution(targets);
    }


    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, InterceptSystem::compareYaxis);

        int end = 0;
        for(int[] tar : targets){
            if(tar[0] >= end){
                end = tar[1];
                answer++; // 시점이 요격 시스템의 상한보다 오른쪽에 있기 때문에 새로운 요격 시스템 추가
            }
        }

        return answer;
    }

    private static int compareYaxis(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
            return o1[0] - o2[0];
        }
        return o1[1] - o2[1];
    }
}
