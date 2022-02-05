// url : https://programmers.co.kr/learn/courses/30/lessons/42888

package programmers;

import java.util.*;
import java.util.stream.Collectors;

enum CommandList {
    Enter("님이 들어왔습니다."),
    Leave("님이 나갔습니다."),
    Change("");

    private final String Value;

    CommandList( String value ) {
        Value = value;
    }

    public String getValue() {
        return Value;
    }
}


public class OpenChatRoom {
    //private static final String[] verbList = { "Enter", "Leave", "Change" };
    public static void main( String[] args ) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answer = solution(record);

        for (String s : answer) {
            System.out.println("answer = " + s);
        }

    }

    public static String[] solution(String[] record) {
        List<String> answerList = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>(); // 유저 닉네임 저장 맵
        Map<String, Boolean> userStatus = new HashMap<>(); //유저 대화방 존재 유,무 저장 맵

        for (String tmpStr : record) {
            String[] strList = tmpStr.split(" ");
            StringBuilder sb = new StringBuilder();
            String command = strList[0];
            String userId = strList[1];


            if (CommandList.Enter.name().equals(command)) {
                sb.append(userId).append(CommandList.Enter.getValue());
                answerList.add(sb.toString());

                userMap.put(userId, strList[2]); // 닉네임 추가
                userStatus.put(userId, true); // 유저 상태값 입력 (대화방에 존재)
            } else if (CommandList.Leave.name().equals(command) && ( Objects.nonNull(userStatus.get(userId)) && userStatus.get(userId) )) {
                sb.append(userId).append(CommandList.Leave.getValue());
                answerList.add(sb.toString());

                userStatus.put(userId, false); // 유저 상태값 입력 (대화방에 미존재)
            } else if (CommandList.Change.name().equals(command) && ( Objects.nonNull(userStatus.get(userId)) && userStatus.get(userId) ) ) { // 닉네임 변경상태이고, 유저가 대화방에 있을 경우
                userMap.put(userId, strList[2]);
            }
        }

        List<String> chgStrList = answerList.stream()
                .map(str -> userMap.entrySet()
                                    .stream()
                                    .filter(mapEntry -> str.startsWith(mapEntry.getKey() + "님"))
                                    .map(mapEntry -> str.replace(mapEntry.getKey(), mapEntry.getValue()))
                                    .findFirst().orElseGet(null)
                )
                .filter(Objects::nonNull)
                .collect(Collectors.toList());


        String[] answer = new String[chgStrList.size()];

        for (int idx = 0; idx < chgStrList.size(); idx++) {
            answer[idx] = chgStrList.get(idx);
        }
        
        return answer;
    }
}
