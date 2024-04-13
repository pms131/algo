package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 전력망을 둘로 나누기
 *
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/86971">전력망을 둘로 나누기</a>
 */
public class SplitPowerGridInTwo {
    private static int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n + 1][n + 1];

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, dfs(n, from));

            graph[from][to] = 1;
            graph[to][from] = 1;

        }

        return answer;
    }

    private int bfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int to = 1; to <= n; to++) {
                if (graph[from][to] == 1 && !visited[to]) {
                    visited[to] = true;
                    queue.offer(to);
                    count++;
                }
            }
        }

        return (int) Math.abs(count - (n - count));
    }

    private int dfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Stack<Integer> stack = new Stack<>();
        visited[x] = true;
        stack.push(x);

        while (!stack.isEmpty()) {
            int from = stack.pop();

            for (int to = 1; to <= n; to++) {
                if (graph[from][to] == 1 && !visited[to]) {
                    visited[to] = true;
                    stack.push(to);
                    count++;
                }
            }
        }

        return (int) Math.abs(count - (n - count));
    }
}
