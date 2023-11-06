package programmers;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomsTest {

    private static final HotelRooms hotelRooms = new HotelRooms();
    @Test
    void solution() {
        //given
        String[][] bookTime1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] bookTime2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        String[][] bookTime3 = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};

        int expected1 = 3;
        int expected2 = 1;
        int expected3 = 3;

        //when
        int answer1 = hotelRooms.solution(bookTime1);
        int answer2 = hotelRooms.solution(bookTime2);
        int answer3 = hotelRooms.solution(bookTime3);

        //then
        assertEquals(expected1, answer1);
        assertEquals(expected2, answer2);
        assertEquals(expected3, answer3);

    }

    @Test
    void test() {
        LocalTime localTime = LocalTime.of(23, 49);

        LocalTime plusMinutes = localTime.plusMinutes(10).isAfter(localTime) ? localTime.plusMinutes(10) : LocalTime.MAX;


        System.out.println("plusMinutes = " + plusMinutes);
    }
}