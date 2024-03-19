package programmers;

import java.util.*;

/**
 * 롤케이크 자르기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/132265">롤케이크 자르기</a>
 */
public class CutRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        Arrays.stream(topping).forEach(j -> map.put(j, map.getOrDefault(j, 0) + 1));

        for (int i : topping) {
            set.add(i);
            map.put(i, map.get(i) - 1);

            if (map.get(i) == 0) {
                map.remove(i);
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }


        return answer;
    }
}
