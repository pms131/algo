package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 우박 수열 정적분
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/134239">우박 수열 정적분</a>
 */
public class HaliSequenceIntegral {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> haliSequence = getHaliSequence(k);

        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int start = range[0];
            int end = haliSequence.size() - 1 + range[1];
            double area = 0;

            if (start > end) {
                area = -1.0;
            } else {
                for (int j = start; j < end; j++) {
                    area += getArea(haliSequence.get(j), haliSequence.get(j + 1));
                }
            }

            answer[i] = area;
        }


        return answer;
    }

    public static List<Integer> getHaliSequence(int k) {
        List<Integer> haliSequence = new ArrayList<>();

        haliSequence.add(k);

        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }

            haliSequence.add(k);
        }

        return haliSequence;
    }

    public static double getArea(int y1, int y2) {
        return y1 + (y2 - y1) / 2.0;
    }
}
