package programmers;

import java.util.Stack;

/**
 * 뒤에 있는 큰 수 찾기
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/154539">뒤에 있는 큰 수 찾기</a>
 */
public class FindLargeNumberBehind {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            int number = numbers[i];
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (peek > number) {
                    answer[i] = peek;
                    stack.push(number);
                    break;
                } else {
                    stack.pop(); //뒤에 있는 값보다 현재 값이 작은 경우 어차피 사용되지 않을 값이기 때문에 의미가 없다. 따라서 빼버림
                }
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
                stack.push(number);
            }
        }


        return answer;
    }
}
