package programmers;

import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993" >미로 탈출</a>
 */
public class EscapeMaze {
    private static final char START_CHARACTER = 'S';
    private static final char END_CHARACTER = 'E';
    private static final char LEVER_CHARACTER = 'L';
    private static final char WALL_CHARACTER = 'X';

    public int solution(String[] maps) {
        int answer = -1;
        int yMax = maps.length;
        int xMax = maps[0].length();

        boolean leverVisited = false;

        boolean[][] visitedList = new boolean[yMax][xMax];

        Queue<Point> queue = new LinkedList<>();


        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                if (maps[i].charAt(j) == START_CHARACTER) {
                    visitedList[j][i] = true;
                    queue.add(new Point(j, i, 0));
                    break;
                }
            }

        }

        while (!queue.isEmpty() && !leverVisited) {
            Point point = queue.poll();

            System.out.println("point = " + point);

            int x = point.getX();
            int y = point.getY();

            if (LEVER_CHARACTER == maps[y].charAt(x)) {
                System.out.println("lever visited point = " + point);
                queue.clear();
                Arrays.stream(visitedList).forEach(visited -> Arrays.fill(visited, false));

                visitedList[y][x] = true;
                leverVisited = true;
            }

            move(maps, yMax, xMax, visitedList, queue, point);

        }


        while (!queue.isEmpty()) {
            Point point = queue.poll();

            System.out.println("point = " + point);

            int x = point.getX();
            int y = point.getY();

            if (END_CHARACTER == maps[y].charAt(x)) {
                System.out.println("End point = " + point);
                return point.getDistance();
            }

            move(maps, yMax, xMax, visitedList, queue, point);

        }

        return answer;
    }

    private static void move(String[] maps, int yMax, int xMax, boolean[][] visited, Queue<Point> queue, Point point) {
        int x = point.getX();
        int y = point.getY();

        //left
        if (x - 1 >= 0 && !visited[y][x - 1] && maps[y].charAt(x - 1) != WALL_CHARACTER) {
            visited[y][x - 1] = true;
            queue.add(new Point(x - 1, y, point.getDistance() + 1));
        }

        //right
        if (x + 1 < xMax && !visited[y][x + 1] && maps[y].charAt(x + 1) != WALL_CHARACTER) {
            visited[y][x + 1] = true;
            queue.add(new Point(x + 1, y, point.getDistance() + 1));
        }

        //up
        if (y - 1 >= 0 && !visited[y - 1][x] && maps[y - 1].charAt(x) != WALL_CHARACTER) {
            visited[y - 1][x] = true;
            queue.add(new Point(x, y - 1, point.getDistance() + 1));
        }

        //down
        if (y + 1 < yMax && !visited[y + 1][x] && maps[y + 1].charAt(x) != WALL_CHARACTER) {
            visited[y + 1][x] = true;
            queue.add(new Point(x, y + 1, point.getDistance() + 1));
        }
    }


    @ToString
    private static class Point {
        private final int x;
        private final int y;
        private final int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

    }
}
