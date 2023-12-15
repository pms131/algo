package programmers;

/**
 * 유사 칸토어 배열
 * @see <a herf = "https://school.programmers.co.kr/learn/courses/30/lessons/148652"></a>
 */
public class PseudoCantorBits {
    private String zeroSubstitute = "00000";
    private String oneSubstitute = "11011";

    public int solution(int n, long l, long r) {
        int answer = 0;
        int length = 1;
        String cantorBits = "1";

        do {
            cantorBits = getCantorBits(cantorBits);
            length *= 5;
        } while (length <= r);

        String substring = cantorBits.substring(Math.toIntExact(l - 1), Math.toIntExact(r));

        for (char c : substring.toCharArray()) {
            if ('1' == c) {
                answer++;
            }
        }

        return answer;
    }

    private String getCantorBits(String cantorBit) {
        if ("1".equals(cantorBit)) {
            return oneSubstitute;
        }

        oneSubstitute = oneSubstitute + oneSubstitute + zeroSubstitute + oneSubstitute + oneSubstitute;
        zeroSubstitute = zeroSubstitute + zeroSubstitute + zeroSubstitute + zeroSubstitute + zeroSubstitute;

        return oneSubstitute;
    }
}


//0 : 1 -> 1
//1 : 11011 -> 4
//2 : 11011 11011 00000 11011 11011 -> 16
//3 : 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 -> 64

/*4 : 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011
      11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011
      00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000 00000
      11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011
      11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011
 */