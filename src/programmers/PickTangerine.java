package programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 귤 고르기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java">호텔 대실</a>
 */
public class PickTangerine {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(tangerine)
                .forEach(operand -> {
                    if (map.get(operand) == null) {
                        map.put(operand, 1);
                    } else {
                        Integer integer = map.get(operand);
                        map.put(operand, ++integer);
                    }
                });

        PriorityQueue<Tangerine> priorityQueue = map.entrySet()
                .stream()
                .map(entry -> new Tangerine(entry.getKey(), entry.getValue()))
                .collect(Collectors.toCollection(PriorityQueue::new));


        while (!priorityQueue.isEmpty()) {
            Tangerine queue = priorityQueue.poll();

            if (k - queue.getCount() <= 0) {
                return ++answer;
            }

            answer++;
            k -= queue.getCount();
        }


        return answer;
    }

    private static class Tangerine implements Comparable<Tangerine> {
        private final int size;
        private final int count;

        public Tangerine(int size, int count) {
            this.size = size;
            this.count = count;
        }

        public Integer getSize() {
            return size;
        }

        public Integer getCount() {
            return count;
        }

        @Override
        public int compareTo(Tangerine o) {
            return o.count - this.count;
        }
    }

}
