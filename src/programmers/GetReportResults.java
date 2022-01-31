// url : https://programmers.co.kr/learn/courses/30/lessons/92334?language=java

package programmers;

import java.util.*;

public class GetReportResults {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);

        for (int val : answer) {
            System.out.println(val);
        }
    }


    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>(); //같은 신고자 중복을 제거하기 위해 Set을 Value타입으로 설정
        Map<String, Integer> cntMap = new HashMap<>(); //신고자 ID별 신고당한 카운트

        //유저 ID별 신고 ID 셋팅
        for (String repot : report) {
            StringTokenizer st = new StringTokenizer(repot, " ");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                String val = st.nextToken();

                setMap(map, key, val);
            }
        }

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();

        // 신고 ID당 신고당한 갯수 카운팅
        for (String key : keySet) {
            Set<String> set = map.get(key);

            for (String s : set) {
                if (Objects.isNull(cntMap.get(s))) {
                    cntMap.put(s, 1);
                } else {
                    int cnt = cntMap.get(s);
                    cntMap.put(s, ++cnt);
                }
            }
        }

        //id_list당 알림 카운팅
        for (int i = 0; i < id_list.length; i++) {
            String key = id_list[i];
            Set<String> valSet = map.get(key);

            if (Objects.nonNull(valSet)) {
                long count = valSet.stream().filter(val -> Objects.nonNull(cntMap.get(val)) && cntMap.get(val) >= k).count();
                answer[i] = (int) count;
            }

        }

        return answer;
    }


    private static void setMap(Map<String, Set<String>> map, String key, String val) {
        Set<String> valSet;
        if (Objects.isNull(map.get(key))) {
            valSet = new HashSet<>();
        } else {
            valSet = map.get(key);
        }

        valSet.add(val);
        map.put(key, valSet);
    }

    private static void mapPrint(Map<String, Set<String>> map) {
        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            Set<String> valSet = map.get(key);
            System.out.println("key : " + key + " value : " + valSet.toString());
        }

    }
}