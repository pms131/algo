package programmers;

import java.util.Stack;

/**
 * 택배 상자
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/131704">택배 상자</a>
 */
public class ParcelBox {
    public int solution(int[] order) {
        int answer = 0;
        int now = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            int nowOrder = order[now];
            if (i == nowOrder) {
                answer++;
                now++;

                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();

                    if (peek == order[now]) {
                        stack.pop();
                        now++;
                        answer++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(i);
            }
        }
        return answer;
    }
}
