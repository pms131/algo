package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 연속 부분 수열 합의 개수
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/131701">연속 부분 수열 합의 개수</a>
 */
public class NumberOfPartialSequence {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int length = elements.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = 0;

                for (int k = j; k < j + i + 1; k++) {
                    sum += elements[k % length];
                }

                set.add(sum);
            }
        }

        return set.size();
    }

}
