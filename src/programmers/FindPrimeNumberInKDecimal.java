package programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * k 진수에서 소수 개수 구하기
 *
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/92335">k 진수에서 소수 개수 구하기</a>
 */
public class FindPrimeNumberInKDecimal {
    public int solution(int n, int k) {
        String kDecimal = convertKDecimal(n, k);

        String[] split = kDecimal.split("0");

        return (int) Arrays.stream(split).filter(s -> !s.isBlank())
                .mapToLong(Long::parseLong)
                .filter(value -> value > 1)
                .filter(this::isPrime)
                .boxed()
                .count();
    }

    private String convertKDecimal(int n, int k) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        if (n == 0) {
            return "0";
        }

        while (n > 0) {
            stack.push(String.valueOf(n % k));
            n = n / k;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {// n의 제곱근까지 나누기
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean sieveOfEratosthenes(int n) {

        //0부터 n까지의 수이기 때문에 n+1을 할당한다.
        boolean[] prime = new boolean[n + 1];

        // 0과 1은 소수가 아니기 때문에 false를 저장한다.
        prime[0] = false;
        prime[1] = false;

        // n의 제곱근까지 나눈다.
        for (int i = 2; i <= Math.sqrt(n); i++) {

            // 소수라면 뒤에 오는 코드를 스킵한다.
            if (prime[i]) {
                continue;
            }

            // 2부터 배수에 해당하는 수를 true로 변환한다.
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        return prime[n];
    }
}
