package programmers;

import java.util.PriorityQueue;

/**
 * 디펜스 게임.
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/142085?language=java">디펜스 게임</a>
 */
public class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            int minK = pq.size() == 0 ? 0 : pq.peek();

            if (minK <= enemy[i]) {
                if (k == 0) {
                    int poll = pq.poll();

                    if (n - poll >= 0) {
                        n -= poll;
                    } else {
                        break;
                    }
                } else {
                    k--;
                }

                pq.offer(enemy[i]);
                answer++;
            } else {
                if (k > 0) {
                    pq.offer(enemy[i]);
                    answer++;
                    k--;
                } else if (n - enemy[i] >= 0) {
                    n -= enemy[i];
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
