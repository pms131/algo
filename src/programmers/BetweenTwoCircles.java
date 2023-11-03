package programmers;

/**
 * 두 원 사이의 정수 쌍
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181187">programmers</a>
 */
public class BetweenTwoCircles {

    public static void main(String[] args) {
        long answer = solution(2, 3);

        System.out.println("answer = " + answer);
    }


    public static long solution(int r1, int r2) {
        long answer = 0;

        long r1Diameter = (long) r1 * r1;
        long r2Diameter = (long) r2 * r2;

        int minusValue = 0;

          for (int x = 0; x <= r2; x++) {
            double r1Yaxis = (r1Diameter - (long) x * x) > 0 ? Math.sqrt(r1Diameter - (long) x * x) : 0;
            r1Yaxis = Math.ceil(r1Yaxis);

            double r2Yaxis = Math.sqrt(r2Diameter - (long) x * x);
            r2Yaxis = Math.floor(r2Yaxis);

            int diff = (int) (r2Yaxis - r1Yaxis);

              if (x == 0) {
                  minusValue = diff + 1;
              }

            answer += diff + 1;
        }

        return answer * 4 - minusValue * 4L;
    }
}
