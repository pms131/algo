package programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 할인 행사
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/131127">할인 행사</a>
 */
public class DiscountOffers {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        List<String> discountList = Arrays.stream(discount).collect(Collectors.toList());

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discountList.size() - 10; i++) {
            List<String> subList = discountList.subList(i, i + 10);
            Map<String, Integer> discountMap = new HashMap<>(map);

            for (String key : subList) {
                if (Objects.nonNull(discountMap.get(key))) {
                    Integer count = discountMap.get(key);
                    discountMap.put(key, count - 1);
                }

                if (Objects.nonNull(discountMap.get(key)) && discountMap.get(key) == 0) {
                    discountMap.remove(key);
                }

                if (discountMap.isEmpty()) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
