package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VowelDictionaryTest {
    private static final VowelDictionary vowelDictionary = new VowelDictionary();

    @Test
    void solution_1() {
        //given
        String word = "AAAAE";
        int expected = 6;

        //when
        int actual = vowelDictionary.solution(word);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void solution_2() {
        //given
        String word = "AAAE";
        int expected = 10;

        //when
        int actual = vowelDictionary.solution(word);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void solution_3() {
        //given
        String word = "I";
        int expected = 1563;

        //when
        int actual = vowelDictionary.solution(word);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void solution_4() {
        //given
        String word = "EIO";
        int expected = 1189;

        //when
        int actual = vowelDictionary.solution(word);

        //then
        assertEquals(expected, actual);
    }
}