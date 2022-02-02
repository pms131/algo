// url : https://programmers.co.kr/learn/courses/30/lessons/72410

package programmers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecommandNewID {

    private static final Character[] ALLOW_CHAR = {'-', '_', '.'};

    public static void main(String[] args) {
        //String new_id = "...!@BaT#*..y.abcdefghijklm";
        //String new_id = "z-+.^.";
        //String new_id = "=.=";
        //String new_id = "123_.def";
        String new_id = "abcdefghijklmn.p";

        String answer = solution(new_id);

        System.out.println("answer = " + answer);
    }

    private static String solution(String new_id) {
        String answer = "";
        String beforeId = "";
        List<Character> charList = toCharList(new_id);
        boolean isChange = true;

        while(isChange) {
            isChange = false;

            new_id = new_id.toLowerCase();

            charList = toCharList(new_id);

            new_id = secondStep(charList);
            new_id = thirdStep(new_id);

            charList = toCharList(new_id);

            new_id = fourthStep(charList);

            new_id = fifthStep(new_id);

            beforeId = new_id;
            new_id = sixthStep(new_id);

            if (!new_id.equals(beforeId))
                isChange = true;

            beforeId = new_id;

            charList = toCharList(new_id);

            new_id = seventhStep(charList);
        }
        answer = charListToString(charList);

        return answer;
    }

    private static String seventhStep(List<Character> charList) {

        if (charList.size() < 3) {
            int idx = charList.size();
            char ch = charList.get(idx-1);

            for (int i = idx ; i < 3 ; i++) {
                charList.add(ch);
            }
        }
        return charListToString(charList);
    }

    private static String sixthStep(String new_id) {
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        return new_id;
    }

    private static String fifthStep(String new_id) {
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        return new_id;
    }

    private static String fourthStep(List<Character> charList) {
        String new_id = "";
        for (int i = 0; i < charList.size(); i++) {
            char ch = charList.get(i);
            if (i == 0 || i == charList.size() - 1) {
                if (ALLOW_CHAR[2].equals(ch)) {
                    charList.set(i, ' ');
                }
            }
        }

        new_id = charListToString(charList);
        new_id = new_id.replace(" ", "");

        return new_id;
    }

    private static String thirdStep(String new_id) {
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        return new_id;
    }

    private static String secondStep(List<Character> charList) {
        String new_id = "";

        for (int i = 0; i < charList.size(); i++) {
            char ch = charList.get(i);
            if (!(Character.isLetter(ch) || Character.isDigit(ch)) ) {
                if (!Arrays.asList(ALLOW_CHAR).contains(ch)) {
                    charList.set(i, ' ');
                }
            }
        }

        new_id = charListToString(charList);
        new_id = new_id.replace(" ", "");

        return new_id;
    }

    private static List<Character> toCharList(String s) {
        List<Character> charList = new ArrayList<>();

        for (Character ch : s.toCharArray()) {
            charList.add(ch);
        }

        return charList;
    }

    private static String charListToString(List<Character> charList) {
        StringBuffer result = new StringBuffer();

        for (Character ch : charList) {
            result.append(ch);
        }

        return result.toString();
    }

}
