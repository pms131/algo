package programmers;

import java.util.Arrays;

/**
 * 숫자 카드 나누기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/135807">숫자 카드 나누기</a>
 */
public class DivideNumberCards {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int minA = arrayA[0];
        int gcdA = arrayA[0];
        int minB = arrayB[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            int gcd = getGcd(minA, arrayA[i]);

            gcdA = getGcd(gcdA, gcd);
        }

        for (int i = 1; i < arrayB.length; i++) {
            int gcd = getGcd(minB, arrayB[i]);

            gcdB = getGcd(gcdB, gcd);
        }

        if (notDivisible(arrayB, gcdA)) {
            if (answer < gcdA) {
                answer = gcdA;
            }
        }

        if (notDivisible(arrayA, gcdB)) {
            if (answer < gcdB) {
                answer = gcdB;
            }
        }

        return answer;
    }


    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


    private static boolean notDivisible(int[] arr, int num){
        return Arrays.stream(arr).noneMatch(n -> n % num == 0);
    }
}
