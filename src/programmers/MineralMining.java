package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 광물 캐기
 * @see <a href ="https://school.programmers.co.kr/learn/courses/30/lessons/172927">광물 캐기</a>
 */
public class MineralMining {
    private static final String DIAMOND = "diamond";
    private static final String IRON = "iron";
    private static final String STONE = "stone";

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int diamondPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];

        PriorityQueue<SortedMinerals> priorityQueue = new PriorityQueue<>();

        int length = minerals.length % 5 == 0 ? minerals.length / 5 : minerals.length / 5 + 1;

        for (int i = 0; i < length; i++) {
            int fatigue = 0;
            int end = (i + 1) * 5 < minerals.length ? 5 : (i + 1) * 5 == minerals.length ? 5 : minerals.length % 5;

            for (int j = 0; j < end; j++) {
                String mineral = minerals[i * 5 + j];

                switch (mineral) {
                    case DIAMOND -> fatigue += 25;
                    case IRON -> fatigue += 5;
                    case STONE -> fatigue += 1;
                }
            }

            if (diamondPick + ironPick + stonePick >= i + 1) {
                SortedMinerals sortedMinerals = new SortedMinerals(Arrays.copyOfRange(minerals, i * 5, i * 5 + end), fatigue);
                priorityQueue.offer(sortedMinerals);
            }
        }

        while (!priorityQueue.isEmpty()) {
            SortedMinerals sortedMinerals = priorityQueue.poll();

            boolean diamondPickUse = false;
            boolean ironPickUse = false;
            boolean stonePickUse = false;

            if (diamondPick == 0 && ironPick == 0 && stonePick == 0) {
                return answer;
            }

            for (String mineral : sortedMinerals.getMinerals()) {
                if (diamondPick != 0) {
                    diamondPickUse = true;
                    answer += 1;
                } else if (ironPick != 0) {
                    ironPickUse = true;

                    if (DIAMOND.equals(mineral)) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                } else {
                    stonePickUse = true;

                    if (DIAMOND.equals(mineral)) {
                        answer += 25;
                    } else if (IRON.equals(mineral)) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
            }

            if (diamondPickUse) {
                diamondPick--;
            } else if (ironPickUse) {
                ironPick--;
            } else if (stonePickUse) {
                stonePick--;
            }
        }

        return answer;
    }

    private static class SortedMinerals implements Comparable<SortedMinerals> {
        private final String[] minerals;
        private final int fatigue;

        public SortedMinerals(String[] minerals, int fatigue) {
            this.minerals = minerals;
            this.fatigue = fatigue;
        }

        public String[] getMinerals() {
            return minerals;
        }

        public int getFatigue() {
            return fatigue;
        }

        @Override
        public int compareTo(SortedMinerals o) {
            return o.fatigue - this.fatigue;
        }
    }
}
