package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 무인도 여행
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/154540">무인도 여행</a>
 */
public class DesertIslandTravel {
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Stack<Point> stack = new Stack<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                Point point = new Point(j, i);

                if (c != 'X' && !visited[i][j]) {
                    stack.push(point);
                }

                int dfs = dfs(point, maps, visited, stack);

                if (dfs != 0) {
                    list.add(dfs);
                }
            }

        }

        if (!list.isEmpty()) {
            answer = new int[list.size()];

            List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

            for (int j = 0; j < sortedList.size(); j++) {
                answer[j] = sortedList.get(j);
            }
        }

        return answer;
    }


    private int dfs(Point point, String[] maps, boolean[][] visited, Stack<Point> stack) {
        int x = point.getX();
        int y = point.getY();
        int days = 0;

        while (!stack.isEmpty()) {
            days = Character.getNumericValue(maps[y].charAt(x));

            visited[y][x] = true;
            stack.pop();

            //right
            if (x + 1 < maps[0].length() && maps[y].charAt(x + 1) != 'X' && !visited[y][x + 1]) {
                Point moveRight = new Point(x + 1, y);
                stack.push(moveRight);
                days += dfs(moveRight, maps, visited, stack);
            }

            //left
            if (x - 1 >= 0 && maps[y].charAt(x - 1) != 'X' && !visited[y][x - 1]) {
                Point moveLeft = new Point(x - 1, y);
                stack.push(moveLeft);
                days += dfs(moveLeft, maps, visited, stack);
            }

            //down
            if (y + 1 < maps.length && maps[y + 1].charAt(x) != 'X' && !visited[y + 1][x]) {
                Point moveDown = new Point(x, y + 1);
                stack.push(moveDown);
                days += dfs(moveDown, maps, visited, stack);
            }

            //up
            if (y - 1 >= 0 && maps[y - 1].charAt(x) != 'X' && !visited[y - 1][x]) {
                Point moveUp = new Point(x, y - 1);
                stack.push(moveUp);
                days += dfs(moveUp, maps, visited, stack);
            }

        }
        return days;
    }



    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
