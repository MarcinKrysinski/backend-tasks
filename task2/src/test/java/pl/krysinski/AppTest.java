package pl.krysinski;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {
    @Test
    void getIntegerArrayTest() {
        //given
        String[] numbers = {"1", "2", "3", "4"};
        int[] expected = {1, 2, 3, 4};
        //when
        int[] result = App.getIntegerArray(numbers);
        //then
        assertArrayEquals(expected, result);
    }

    @Test
    void findPairsTest() {
        //given
        int[] numbersArray = {1, 2, 10, 7, 5, 3, 6, 6, 13, 0};
        List<String> expected = List.of("3 10", "6 7", "6 7", "0 13");
        //when
        List<String> result = App.findPairs(numbersArray);
        //then
        assertEquals(expected, result);
    }

    @Test
    void getSortedPairsListTest() {
        //given
        List<String> noSortedPairsList = List.of("3 10", "6 7", "6 7", "0 13");
        List<String> expected = List.of( "0 13", "3 10", "6 7", "6 7");
        //when
        List<String> result = App.getSortedPairsList(noSortedPairsList);
        //then
        assertEquals(expected, result);
    }
}
