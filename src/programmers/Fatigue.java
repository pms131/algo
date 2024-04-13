package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 피로도
 * @see <a href = "htthttps://school.programmers.co.kr/learn/courses/30/lessons/87946">피로도</a>
 */
public class Fatigue {
    private static int MAX_COUNT = 0;
    public int solution(int k, int[][] dungeons) {
        List<Dungeon> dungeonList = new ArrayList<>();
        boolean[] visited = new boolean[dungeons.length];

        for (int[] dungeon : dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }

        permutation(visited, dungeonList, 0, k);


        return MAX_COUNT;
    }

    private void permutation(boolean[] visited, List<Dungeon> dungeonList, int depth, int k) {
        MAX_COUNT = Math.max(MAX_COUNT, depth);

        for (int i = 0; i < dungeonList.size(); i++) {
            Dungeon dungeon = dungeonList.get(i);
            int minimalFatigue = dungeon.getMinimalFatigue();
            int consumptionFatigue = dungeon.getConsumptionFatigue();

            if (!visited[i] && k - minimalFatigue >= 0) {
                visited[i] = true;
                permutation(visited, dungeonList, depth + 1, k - consumptionFatigue);
                visited[i] = false;
            }
        }
    }

    private static class Dungeon {
        private final int minimalFatigue;
        private final int consumptionFatigue;

        public Dungeon(int minimalFatigue, int consumptionFatigue) {
            this.minimalFatigue = minimalFatigue;
            this.consumptionFatigue = consumptionFatigue;
        }

        public int getMinimalFatigue() {
            return minimalFatigue;
        }

        public int getConsumptionFatigue() {
            return consumptionFatigue;
        }
    }
}
