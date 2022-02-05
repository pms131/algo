package programmers;

import org.junit.jupiter.api.Test;
import programmers.OpenChatRoom;

import static org.junit.jupiter.api.Assertions.*;

class OpenChatRoomTest {

    @Test
    void solution() {
        //given
        final OpenChatRoom openChatRoom = new OpenChatRoom();
        final String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        final String[] record2 = {"Enter uid123 uid1234", "Leave uid1234", "Enter uid4567 uid123", "Change uid4567 uid1234", "Leave uid4567"};

        //when
        String[] answer = OpenChatRoom.solution(record);
        String[] expected = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };

        //then
        assertArrayEquals(expected, answer);

    }
}