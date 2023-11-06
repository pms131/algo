package programmers;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 호텔 대실
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java">호텔 대실</a>
 */
public class HotelRooms {
    public int solution(String[][] book_time) {
        //잆실 시간 기준으로 오름차순 정렬
        List<Room> sortedBookTimeList = Arrays.stream(book_time).map(bookTime ->
                        Arrays.stream(bookTime)
                                .map(LocalTime::parse)
                                .collect(Collectors.toList()))
                .map(localTimes -> new Room(localTimes.get(0), localTimes.get(1)))
                .sorted((o1, o2) -> {
                    if (!Objects.equals(o1.startTime, o2.startTime))
                        return o1.startTime- o2.startTime;

                    return o1.endTime - o2.endTime;
                })
                .collect(Collectors.toList());

        //퇴실시간 기준으로 오름차순 정렬
        PriorityQueue<Room> queue = new PriorityQueue<>();

        sortedBookTimeList.forEach(room -> {
            if (queue.isEmpty()) {
                queue.add(room);
            } else {
                Room bookedRoom = queue.peek();

                //호텔 입실된 방에서 가장 퇴실 시간이 빠른 방의 퇴실 시간이 새로 들어올 고객의 입실 시간이 빠른 경우, 퇴실 후 입실
                if (bookedRoom.getEndTime() <= room.getStartTime()) {
                    queue.poll();
                }

                queue.add(room);
            }
        });


        return queue.size();
    }

    private static class Room implements Comparable<Room>{
        Integer startTime;
        Integer endTime;

        public Room(LocalTime startTime, LocalTime endTime) {
            this.startTime = startTime.getHour()* 60 + startTime.getMinute();
            this.endTime = endTime.getHour() * 60 + endTime.getMinute() + 10;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Room o) {
            return this.getEndTime() - o.getEndTime();
        }
    }
}
