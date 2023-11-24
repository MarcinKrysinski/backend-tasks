package pl.krysinski;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void getAllPairsThatSumUpToTargetTest() {
        //given
        String[] numbers = {"1", "2", "10", "5", "3", "6", "6", "13", "0", "7", "7"};
        List<String> expected = List.of("0 13", "3 10", "6 7", "6 7", "6 7", "6 7");
        //when
        List<String> result = App.getAllPairsThatSumUpToTarget(numbers);
        //then
        assertEquals(expected, result);
    }

    @Test
    void findPairsTest() {
        //given
        Map<Integer, Integer> testMap1 = new HashMap<>();
        testMap1.put(13, 2);
        testMap1.put(0, 1);
        testMap1.put(3, 1);
        testMap1.put(8, 2);
        testMap1.put(5, 2);
        //when
        List<String> result = App.findPairs(testMap1);
        //then
        assertEquals(Arrays.asList("0 13", "0 13", "5 8", "5 8", "5 8", "5 8"), result);
    }


    @Test
    void getSortedPairsListTest() {
        List<String> noSortedPairsList = List.of("3 10", "6 7", "6 7", "0 13");
        List<String> expected = List.of("0 13", "3 10", "6 7", "6 7");
        //when
        List<String> result = App.getSortedPairsList(noSortedPairsList);
        //then
        assertEquals(expected, result);
    }
}