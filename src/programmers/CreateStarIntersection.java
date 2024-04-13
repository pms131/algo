package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 교점에 별 만들기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/87377">교점에 별 만들기</a>
 */
public class CreateStarIntersection {
    private static final List<int[]> LIST = new ArrayList<>();
    private static final int MAX_NUMBER = 1001;

    public String[] solution(int[][] line) {
        List<String> answerList = new ArrayList<>();
        boolean[] visited = new boolean[line.length];

        combination(line, visited, 0, 0);

        List<int[]> sortedList = LIST.stream()
                .sorted((o1, o2) -> o2[1] - o1[1]).collect(Collectors.toList());

        int maxY = sortedList.get(0)[1];
        int minY = sortedList.get(sortedList.size() - 1)[1];

        List<int[]> sortedByXList = LIST.stream()
                .sorted((o1, o2) -> o2[0] - o1[0]).collect(Collectors.toList());


        int maxX = sortedByXList.get(0)[0];
        int minX = sortedByXList.get(sortedList.size() - 1)[0];

        for (int col = maxY; col >= minY; col--) {
            StringBuilder sb = new StringBuilder();
            for (int row = minX; row <= maxX; row++) {
                boolean hit = false;
                for (int[] ints : sortedList) {
                    if (row == ints[0] && col == ints[1]) {
                        sb.append("*");
                        hit = true;
                        break;
                    }
                }
                if (!hit) {
                    sb.append(".");
                }
            }
            answerList.add(sb.toString());
        }

        return answerList.toArray(String[]::new);
    }

    private void combination(int[][] lines, boolean[] visited , int start, int depth) {
        if (depth == 2) {
            List<int[]> visitedLines = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    visitedLines.add(lines[i]);
                }
            }

            if (visitedLines.size() == 2) {
                int[] intersection = getIntersection(visitedLines.get(0), visitedLines.get(1));

                if (intersection[0] != MAX_NUMBER) {
                    LIST.add(intersection);
                }
            }

            return;
        }

        for (int i = start; i < lines.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(lines, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private int[] getIntersection(int[] line1, int[] line2) {
        int[] answer = new int[2];
        int a = line1[0];
        int b = line1[1];
        int e = line1[2];

        int c = line2[0];
        int d = line2[1];
        int f = line2[2];

        if (a * d - b * c == 0) {
            answer[0] = MAX_NUMBER;
            answer[1] = MAX_NUMBER;

            return answer;
        }

        long x = ((long) b * f -(long) e * d) / ((long)a * d -(long) b * c);
        long y = ((long) e * c -(long) a * f) / ((long)a * d -(long) b * c);

        if (((long) b * f - (long) e * d) % ((long) a * d - (long) b * c) != 0 || ((long) e * c - (long) a * f) % ((long) a * d - (long) b * c) != 0) {
            answer[0] = MAX_NUMBER;
            answer[1] = MAX_NUMBER;

            return answer;
        }
        answer[0] = (int) x;
        answer[1] = (int) y;

        return answer;
    }
}
