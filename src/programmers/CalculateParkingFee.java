package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 주차 요금 계산
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/92341">주차 요금 계산</a>
 */
public class CalculateParkingFee {
    private static final Integer END_TIME = 1439;

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        PriorityQueue<ParkingFee> pq = new PriorityQueue<>();

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String record : records) {
            String[] split = record.split(" ");
            int time = calculateTime(split[0]);
            String carNumber = split[1];

            if (Objects.equals("IN", split[2])) {
                map.put(carNumber, time);
            } else {
                Integer startTime = map.get(carNumber);
                Integer totalUseTime = answerMap.getOrDefault(carNumber, 0);
                answerMap.put(carNumber, totalUseTime + (time - startTime));
                map.remove(carNumber);
            }
        }

        map.forEach((carNumber, startTime) -> {
            Integer totalUseTime = answerMap.getOrDefault(carNumber, 0);
            answerMap.put(carNumber, totalUseTime + (END_TIME - startTime));
        });

        answerMap.forEach((carNumber, totalUseTime) -> {
            ParkingFee parkingFee = new ParkingFee(carNumber, totalUseTime, defaultTime, defaultFee, unitTime, unitFee);
            pq.offer(parkingFee);
        });


        int[] answer = new int[pq.size()];

        int idx = 0;

        while (!pq.isEmpty()) {
            ParkingFee parkingFee = pq.poll();
            answer[idx] = parkingFee.getParkingFee();
            idx++;
        }

        return answer;
    }

    private int calculateTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private static class ParkingFee implements Comparable<ParkingFee>{
        private final String carNumber;
        private final int totalUseTime;
        private final int parkingFee;

        public ParkingFee(String carNumber, int totalUseTime, int defaultTime, int defaultFee, int unitTime, int unitFee) {
            this.carNumber = carNumber;
            this.totalUseTime = totalUseTime;
            this.parkingFee = calculateParkingFee(defaultTime, defaultFee, unitTime, unitFee);
        }

        public int calculateParkingFee(int defaultTime, int defaultFee, int unitTime, int unitFee) {
            if (this.totalUseTime > defaultTime) {
                return defaultFee + (int) Math.ceil((double) (this.totalUseTime - defaultTime) / unitTime) * unitFee;
            }

            return defaultFee;
        }

        public int getParkingFee() {
            return parkingFee;
        }

        @Override
        public int compareTo(ParkingFee o) {
            return Integer.parseInt(this.carNumber) - Integer.parseInt(o.carNumber);
        }
    }
}
