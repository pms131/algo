package programmers;

import java.util.*;

/**
 * 모음 사전
 *
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/84512">모음 사전</a>
 */
public class VowelDictionary {
    private static final Character[] vowels = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        Map<String, Boolean> visited = new HashMap<>();
        stack.push('A');

        answer = dfs(word, stack, visited);

        return answer;
    }

    private int dfs(String word, Stack<Character> stack, Map<String, Boolean> visited) {
        int count = 1;

        while (!stack.isEmpty()) {
            String nowString = stackToString(stack);
            int size = stack.size();
            Character character = stack.pop();

            if (Objects.equals(nowString, word)) {
                return count;
            }

            if (size < 5) {
                stack.push(character);
                if (!visited.getOrDefault(nowString, false)) {
                    stack.push('A');
                    count++;
                } else {
                    Character now = stack.pop();
                    if (now != 'U') {
                        for (int i = 0; i < vowels.length - 1; i++) {
                            if (now == vowels[i]) {
                                stack.push(vowels[i + 1]);
                                visited.put(nowString, true);
                                count++;
                                break;
                            }
                        }
                    }
                }
            } else if (character != 'U') {
                for (int i = 0; i < vowels.length - 1; i++) {
                    if (character == vowels[i]) {
                        stack.push(vowels[i + 1]);
                    }
                }
                count++;
            }

            visited.put(nowString, true);
        }


        return count;
    }

    private String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < stack.size()) {
            sb.append(stack.get(idx));
            idx++;
        }
        return sb.toString();
    }
}
