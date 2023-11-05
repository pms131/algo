package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 혼자서 하는 틱택토
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/160585?language=java">혼자서 하는 틱택토</a>
 */
public class TicTacToeByMyself {
    private static final char o = 'O';
    private static final char x = 'X';


    public int solution(String[] board) {
        int answer = 0;

        int oCount = 0;
        int xCount = 0;
        int oTicTacToe = 0;
        int xTicTacToe = 0;

        List<List<Character>> list = new ArrayList<>();

        for (String s : board) {

            List<Character> tmpList = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                tmpList.add(c);

                if (o == c) {
                    oCount++;
                } else {
                    if (x == c) {
                        xCount++;
                    }
                }
            }
            list.add(tmpList);
        }

        for (int i = 0; i < 3; i++) {
            if (list.get(i).get(0) == o && list.get(i).get(1) == o && list.get(i).get(2) == o) {
                oTicTacToe++;
            }
            if (list.get(0).get(i) == o && list.get(1).get(i) == o && list.get(2).get(i) == o) {
                oTicTacToe++;
            }


            if (list.get(i).get(0) == x && list.get(i).get(1) == x && list.get(i).get(2) == x) {
                xTicTacToe++;
            }
            if (list.get(0).get(i) == x && list.get(1).get(i) == x && list.get(2).get(i) == x) {
                xTicTacToe++;
            }
        }

        if (list.get(0).get(0) == o && list.get(1).get(1) == o && list.get(2).get(2) == o) {
            oTicTacToe++;
        }
        if (list.get(2).get(0) == o && list.get(1).get(1) == o && list.get(0).get(2) == o) {
            oTicTacToe++;
        }
        if (list.get(0).get(0) == x && list.get(1).get(1) == x && list.get(2).get(2) == x) {
            xTicTacToe++;
        }
        if (list.get(2).get(0) == x && list.get(1).get(1) == x && list.get(0).get(2) == x) {
            xTicTacToe++;
        }

        if (oTicTacToe > 1 || xTicTacToe > 1) {
            if (oTicTacToe > 1 && (oCount == 5 && xCount == 4)) {
                return 1;
            } else {
                return 0;
            }
        } else if (oTicTacToe > 0 && xTicTacToe > 0) {
            return 0;
        }

        if (xTicTacToe > 0 && oCount - 1 == xCount) {
            return 0;
        }

        if (oTicTacToe == 1 && (oCount == xCount)) {
            return 0;
        }

        if (oCount == xCount || oCount - 1 == xCount) {
            return 1;
        }


        return answer;
    }
}
