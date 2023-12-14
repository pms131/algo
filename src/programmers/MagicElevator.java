package programmers;

/**
 * 마법의 엘리베이터
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/148653">마법의 엘리베이터</a>
 */
public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remainder = storey % 10;

            if (remainder > 5) {
                answer += (10 - remainder);

                storey =  (storey + 10 - remainder) / 10;
            } else if (remainder < 5) {
                    answer += remainder;

                    storey /= 10;
            }  else  {
                int prev = storey / 10 % 10;
                answer += remainder;

                if (prev >= 5) {
                    storey =  (storey + 10 - remainder) / 10;
                } else {
                    storey /= 10;
                }
            }

        }

        return answer;
    }
}
