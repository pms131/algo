// url : https://programmers.co.kr/learn/courses/30/lessons/81301

package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberStrAndEngWord {
    public enum Number {
        ZERO("zero", "0"),
        ONE("one","1"),
        TWO("two", "2"),
        THREE("three", "3"),
        FOUR("four", "4"),
        FIVE("five", "5"),
        SIX("six", "6"),
        SEVEN("seven", "7"),
        EIGHT("eight", "8"),
        NINE("nine", "9");

        private final String name;
        private final String num;

        Number( String name, String num ) {
            this.name = name;
            this.num = num;
        }

    }

    public int solution(String s) {
        int answer = 0;
        String str = s;
        Number[] numbers = Number.values();

        for (Number number : numbers) {
            String num = number.name;

            if (str.contains(num)) {
                str = str.replace(num, number.num);
            }
        }

        answer = Integer.parseInt(str);

        return answer;
    }
}
