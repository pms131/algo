//url : https://programmers.co.kr/learn/courses/30/lessons/60057

package programmers;

public class CompressChArr {
    public static void main(String[] args) {
        //String s = "aabbaccc";
        //String s = "ababcdcdababcdcd";
        String s = "abcabcabcabcdededededede";

        int answer = solution(s);

        System.out.println("answer = " + answer);
    }

    public static int solution(String s) {
        int answer = 0;
        //char[] chArr = s.toCharArray();

        String before = s;

        for (int i = 1; i <= s.length()/2; i++) {

            String subStr = s.substring(0, i);
            StringBuilder tmp = new StringBuilder();
            int cnt = 1;

            for (int k = i; k < s.length(); k += i) {
                if ( k + i <= s.length() ) {
                    String targetSubStr = s.substring(k, k + i);

                    if ( subStr.equals(targetSubStr) ) {
                        cnt++;
                    } else {
                        appendSubStr(subStr, tmp, cnt);
                        subStr = targetSubStr;
                        cnt = 1;
                    }
                } else
                    subStr = s.substring(k - i);
            }

            appendSubStr(subStr, tmp, cnt);

            if (tmp.length() < before.length())
                before = tmp.toString();
        }

        answer = before.length();

        return answer;
    }

    private static void appendSubStr( String subStr, StringBuilder tmp, int cnt ) {
        if (cnt != 1) {
            tmp.append(cnt).append(subStr);
        } else {
            tmp.append(subStr);
        }
    }
}
