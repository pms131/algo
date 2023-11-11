package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class SeesawMates {
    public long solution(int[] weights) {
        long answer = 0;

        List<Integer> sortedList = Arrays.stream(weights).sorted().boxed().collect(Collectors.toList());
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : sortedList) {
            double x = weight;
            double x2 = weight / 2.0;
            double x32 = weight * 2.0 / 3;
            double x43 = weight * 3.0 / 4;


            if (map.get(x) != null) {
                answer += map.get(x);
            }
            if (map.get(x2) != null) {
                answer += map.get(x2);
            }
            if (map.get(x32) != null) {
                answer += map.get(x32);
            }
            if (map.get(x43) != null) {
                answer += map.get(x43);
            }

            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return answer;
    }
}
