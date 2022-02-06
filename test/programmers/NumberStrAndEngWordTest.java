package programmers;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class NumberStrAndEngWordTest {

    @Before
    public void init() {

    }

    @Test
    public void solution() {
        //given
        final NumberStrAndEngWord numberStrAndEngWord = new NumberStrAndEngWord();

        //when
        final String s1 = "one4seveneight";
        final String s2 = "23four5six7";
        final String s3 = "2three45sixseven";
        final String s4 = "123";

        //then
        assertThat(numberStrAndEngWord.solution(s1), is(1478));
        assertThat(numberStrAndEngWord.solution(s2), is(234567));
        assertThat(numberStrAndEngWord.solution(s3), is(234567));
        assertThat(numberStrAndEngWord.solution(s4), is(123));
        /*assertEquals(1478, numberStrAndEngWord.solution(s1));
        assertEquals(234567, numberStrAndEngWord.solution(s2));
        assertEquals(234567, numberStrAndEngWord.solution(s3));
        assertEquals(123, numberStrAndEngWord.solution(s4));*/
    }
}