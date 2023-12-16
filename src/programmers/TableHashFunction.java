package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 테이블 해시 함수.
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/147354">데이터 해시 함수</a>
 */
public class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer;

        Arrays.sort(data, (o1, o2) -> sortData(col - 1, o1, o2));

        answer = IntStream.range(row_begin - 1, row_end)
                .map(idx -> getXor(data[idx], idx + 1))
                .reduce(0, (a, b) -> a ^ b);

        return answer;
    }

    private static int sortData(int col, int[] o1, int[] o2) {
        if (o1[col] == o2[col]) {
            return o2[0] - o1[0];
        }

        return o1[col] - o2[col];
    }

    private int getXor(int[] data, int target) {
        return Arrays.stream(data)
                .map(i -> i % target)
                .sum();
    }
}
