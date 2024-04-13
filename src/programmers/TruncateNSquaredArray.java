package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * n^2 배열 자르기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/87390">n^2 배열 자르기</a>
 */
public class TruncateNSquaredArray {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();

        int leftCol = (int) (left / n);
        int leftRow = (int) (left % n);
        int rightCol = (int) (right / n);
        int rightRow = (int) (right % n);


        for (int col = leftCol; col <= rightCol; col++) {
            for (int row = 0; row < n; row++) {
                if (col == leftCol && row < leftRow) {
                    continue;
                } else if (col == rightCol && row > rightRow) {
                    continue;
                }

                if (row == col) {
                    list.add(row + 1);
                } else {
                    int max = Math.max(row, col);
                    list.add(max + 1);
                }
            }
        }

        return list.stream().mapToInt(value -> value).toArray();
    }
}
