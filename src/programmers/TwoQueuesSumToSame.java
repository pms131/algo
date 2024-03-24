package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/118667">두 큐 합 같게 만들기</a>
 */
public class TwoQueuesSumToSame {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sumOfQueue1 = Arrays.stream(queue1).sum();
        long sumOfQueue2 = Arrays.stream(queue2).sum();
        long perSum = (sumOfQueue1 + sumOfQueue2) / 2;
        long maxCount  = (queue1.length + queue2.length) * 3L;

        if ((sumOfQueue1 + sumOfQueue2) % 2 != 0) {
            return -1;
        }

        Queue<Integer> queueFirst = new LinkedList<>();
        Queue<Integer> queueSecond = new LinkedList<>();

        Arrays.stream(queue1).boxed().forEach(queueFirst::add);
        Arrays.stream(queue2).boxed().forEach(queueSecond::add);

        long count = 0;
        while (!queueFirst.isEmpty() && !queueSecond.isEmpty() && count <= maxCount) {
            if (sumOfQueue1 == sumOfQueue2 && sumOfQueue1 == perSum) {
                return answer;
            }

            if (sumOfQueue1 < perSum && sumOfQueue2 > perSum) {
                Integer poll = queueSecond.poll();

                queueFirst.add(poll);

                sumOfQueue1 += poll;
                sumOfQueue2 -= poll;

                answer++;
            } else if (sumOfQueue1 > perSum && sumOfQueue2 < perSum) {
                Integer poll = queueFirst.poll();
                queueSecond.add(poll);

                sumOfQueue1 -= poll;
                sumOfQueue2 += poll;

                answer++;
            }

            count++;
        }


        return -1;
    }
}
