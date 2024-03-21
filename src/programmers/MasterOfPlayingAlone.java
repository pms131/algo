package programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 혼자 놀기의 달인
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/131130">혼자 놀기의 달인</a>
 */
public class MasterOfPlayingAlone {
    public int solution(int[] cards) {
        int answer;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start = 1;

        for (int idx = 1; idx <= cards.length; idx++) {
            map.put(idx, cards[idx - 1]);

            if (start >= idx && idx != cards[idx - 1]) {
                start = idx;
            }
        }


        while (!map.isEmpty()) {
            int pointer = start;
            List<Integer> tempList = new ArrayList<>();
            boolean isOpenBox = false;

            while (!map.isEmpty() && !isOpenBox) {
                Integer value = map.get(pointer);
                map.remove(pointer);
                tempList.add(pointer);

                if (map.get(value) == null) {
                    isOpenBox = true;
                    list.add(tempList.size());
                    tempList.clear();

                    Optional<Integer> optional = map.keySet().stream().findFirst();

                    if (optional.isPresent()) {
                        start = optional.get();
                    }
                }

                pointer = value;
            }
        }

        if (list.size() <= 1) {
            answer = 0;
        } else {
            List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            answer = sortedList.get(0) * sortedList.get(1);
        }

        return answer;
    }
}
