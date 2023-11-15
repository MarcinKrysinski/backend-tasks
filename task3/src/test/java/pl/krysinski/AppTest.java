package pl.krysinski;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void testCountGraphs2() {
        //given
        Map<Integer, ArrayList<Integer>> graph2 = new HashMap<>();
        graph2.put(1, new ArrayList<>(List.of(3, 3)));
        graph2.put(3, new ArrayList<>(List.of(1, 1)));
        graph2.put(5, new ArrayList<>(List.of(6)));
        graph2.put(6, new ArrayList<>(List.of(5)));
        graph2.put(7, new ArrayList<>(List.of(8)));
        //when
        int result = App.countSeparatedGraphs(graph2);
        //then
        assertEquals(3, result);
    }

    @Test
    void testGetGraph2() {
        //given
        String mockInput = "1 3\n3 1\n5 6\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        Map<Integer, ArrayList<Integer>> expected = new HashMap<>();
        expected.put(1, new ArrayList<>(List.of(3, 3)));
        expected.put(3, new ArrayList<>(List.of(1, 1)));
        expected.put(5, new ArrayList<>(List.of(6)));
        expected.put(6, new ArrayList<>(List.of(5)));
        //when
        Map<Integer, ArrayList<Integer>> result = App.getGraphConnections(3, new Scanner(System.in));
        //then
        assertEquals(expected, result);
    }
}
