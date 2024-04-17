package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 거리두기 확인하기
 *
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/81302">거리두기 확인하기</a>
 */
public class CheckDistancing {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            boolean isDistance = true;

            for (int row = 0; row < 5 && isDistance; row++) {
                for (int col = 0; col < 5 && isDistance; col++) {
                    if (place[row].charAt(col) ==  'P') {
                        isDistance = bfs(row, col, place);
                    }

                }

            }

            answer[i] = isDistance ? 1 : 0;
        }
        return answer;
    }

    public boolean bfs(int row, int col, String[] places) {

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int newRow = position[0] + dx[i];
                int newCol = position[1] + dy[i];

                int distance = Math.abs(row - newRow) + Math.abs(col - newCol);

                if (newCol < 0 || newCol >= 5 || newRow < 0 || newRow >= 5 || (newRow == row && newCol == col)) {
                    continue;
                }

                if (places[newRow].charAt(newCol) == 'P' && distance <= 2) {
                    return false;
                } else if (places[newRow].charAt(newCol) == 'O' && distance < 2) {
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return true;
    }
}
