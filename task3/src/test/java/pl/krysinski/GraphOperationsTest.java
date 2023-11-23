package pl.krysinski;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GraphOperationsTest {
    GraphOperations graphOperations = new GraphOperations();
    @Test
    void testCountSeparatedGraphs() {
        //given
        Map<Integer, Integer> graph = new HashMap<>();
        graph.put(1, 3);
        graph.put(3, 1);
        graph.put(5, 6);
        graph.put(6, 5);
        graph.put(7, 8);
        //when
        int result = graphOperations.countSeparatedGraphs(graph);
        //then
        assertEquals(3, result);
    }

    @Test
    void testCountSeparatedGraphsOneElementGraph() {
        //given
        Map<Integer, Integer> graph = new HashMap<>();
        graph.put(1, 1);
        //when
        int result = graphOperations.countSeparatedGraphs(graph);
        //then
        assertEquals(1, result);
    }

    @Test
    void testGetGraphConnectionsMap() {
        //given
        String mockInput = "1 3\n3 1\n5 6\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 3);
        expected.put(3, 1);
        expected.put(5, 6);
        expected.put(6, 5);
        //when
        Map<Integer, Integer> result = graphOperations.getGraphConnectionsMap(3, new Scanner(System.in));
        //then
        assertEquals(expected, result);
    }

    @Test
    public void testGetGraphConnectionsMapWithOneWrongLine() {
        //given
        String mockInput = "2\n1 2\n3 h\n";
        ByteArrayInputStream in = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(in);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 3);
        expected.put(3, 2);
        //when
        Map<Integer, Integer> result = graphOperations.getGraphConnectionsMap(2, new Scanner(System.in));
        //then
        assertEquals(expected, result);
    }

    @Test
    void testPositiveDepthFirstSearchAlgorithm() {
        //given
        Map<Integer, Integer> graph = new HashMap<>();
        graph.put(1, 2);
        graph.put(2, 4);
        graph.put(3, 6);
        graph.put(4, 8);
        graph.put(5, 10);
        Set<Integer> visited = new HashSet<>();

        //when
        boolean result = graphOperations.depthFirstSearchAlgorithm(graph, 1, visited);

        //then
        assertTrue(result);
    }

}
