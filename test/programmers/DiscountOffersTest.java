package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountOffersTest {
    private static final DiscountOffers discountOffers = new DiscountOffers();

    @Test
    void solution_1() {
        //given
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};

        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int expected = 3;

        //when
        int answer = discountOffers.solution(want, number, discount);

        //then
        assertEquals(expected, answer);
    }

    @Test
    void solution_2() {
        //given
        String[] want = {"apple"};
        int[] number = {30};

        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        int expected = 0;

        //when
        int answer = discountOffers.solution(want, number, discount);

        //then
        assertEquals(expected, answer);
    }
}