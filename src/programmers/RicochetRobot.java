package programmers;

import java.util.*;

/**
 * 리코쳇 로봇
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/169199"> 리코쳇 로봇 </a>
 */
public class RicochetRobot {
    public int solution(String[] board) {
        int xSize = board[0].length();
        int ySize = board.length;

        boolean[][] visited = new boolean[ySize][xSize];

        Queue<int[]> queue = new LinkedList<>();

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (board[y].charAt(x) == 'R') {
                    queue.add(new int[]{y, x, 0});
                    visited[y][x] = true;
                }
            }
        }

        return bfs(queue, visited, board, xSize, ySize);
    }

    private int bfs(Queue<int[]> queue, boolean[][] visited, String[] board, int xSize, int ySize) {
        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            int y = q[0];
            int x = q[1];
            int movingCount = q[2];

            System.out.print("x = " + x + " ");
            System.out.print("y = " + y + " ");
            System.out.print(movingCount + " ");
            System.out.print("board = " + board[y].charAt(x));

            if (board[y].charAt(x) == 'G') {
                return movingCount;
            }

            int dx = 1;
            int dy = 1;


            //right
            while (x + dx != xSize && board[y].charAt(x + dx) != 'D') {
                dx++;
            }

            if (!visited[y][x + dx - 1]) {
                System.out.print(" move right");
                queue.add(new int[]{y, x + dx - 1, movingCount + 1});
                visited[y][x + dx - 1] = true;
            }

            dx = 1;

            //up
            while (y - dy != -1 && board[y - dy].charAt(x) != 'D') {
                dy++;
            }

            if (!visited[y - dy + 1][x]) {
                System.out.print(" move up");
                queue.add(new int[]{y - dy + 1, x, movingCount + 1});
                visited[y - dy + 1][x] = true;
            }

            dy = 1;

            //left
            while (x - dx != -1 && board[y].charAt(x - dx) != 'D') {
                dx++;
            }

            if (!visited[y][x - dx + 1]) {
                System.out.print(" move left");
                queue.add(new int[]{y, x - dx + 1, movingCount + 1});
                visited[y][x - dx + 1] = true;
            }

            dx = 1;

            //down
            while (y + dy != ySize && board[y + dy].charAt(x) != 'D') {
                dy++;
            }

            if (!visited[y + dy - 1][x]) {
                System.out.print(" move down");
                queue.add(new int[]{y + dy - 1, x, movingCount + 1});
                visited[y + dy - 1][x] = true;
            }

            dy = 1;

            System.out.println();

        }

        return -1;
    }
}
