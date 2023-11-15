package pl.krysinski;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void testCountSeparatedGraphs() {
        //given
        Map<Integer, Set<Integer>> graph2 = new HashMap<>();
        graph2.put(1, new HashSet<>(Set.of(3)));
        graph2.put(3, new HashSet<>(Set.of(1)));
        graph2.put(5, new HashSet<>(Set.of(6)));
        graph2.put(6, new HashSet<>(Set.of(5)));
        graph2.put(7, new HashSet<>(Set.of(8)));
        //when
        int result = App.countSeparatedGraphs(graph2);
        //then
        assertEquals(3, result);
    }

    @Test
    void testGetGraphConnectionsMap() {
        //given
        String mockInput = "1 3\n3 1\n5 6\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        Map<Integer, Set<Integer>> expected = new HashMap<>();
        expected.put(1, new HashSet<>(Set.of(3)));
        expected.put(3, new HashSet<>(Set.of(1)));
        expected.put(5, new HashSet<>(Set.of(6)));
        expected.put(6, new HashSet<>(Set.of(5)));
        //when
        Map<Integer, Set<Integer>> result = App.getGraphConnectionsMap(3, new Scanner(System.in));
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testGetGraphConnectionsMapWithOneWrongLine() {
        //given
        String mockInput = "2\n1 2\n3 h\n";
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);
        Map<Integer, Set<Integer>> expected = new HashMap<>();
        expected.put(1, new HashSet<>(Set.of(2)));
        expected.put(2, new HashSet<>(Set.of(3,1)));
        expected.put(3, new HashSet<>(Set.of(2)));
        //when
        Map<Integer, Set<Integer>> result = App.getGraphConnectionsMap(2, new Scanner(System.in));
        //then
        assertEquals(expected, result);
    }
}