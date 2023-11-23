package pl.krysinski;

import java.util.*;

public class GraphOperations {
    Map<Integer, Integer> getGraphConnectionsMap(int connectionsNumber, Scanner scanner) {
        Map<Integer, Integer> graphConnectionsMap = new HashMap<>();
        System.out.println("Enter " + connectionsNumber + " lines of pair connections separated by a space \n(example:\n1 2\n2 3): ");
        for (int i = 0; i < connectionsNumber; i++) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                graphConnectionsMap.put(a, b);
                graphConnectionsMap.put(b, a);
            } catch (InputMismatchException e) {
                System.err.println("Input is not an integer value.");
                graphConnectionsMap.clear();
                return graphConnectionsMap;
            }
        }
        return graphConnectionsMap;
    }

    int countSeparatedGraphs(Map<Integer, Integer> graphConnections) {
        int separatedGraphs = 0;
        if (graphConnections.isEmpty()) {
            return separatedGraphs;
        }
        Set<Integer> visitedElement = new HashSet<>();

        for (int vertex : graphConnections.keySet()) {
            if (!visitedElement.contains(vertex) && depthFirstSearchAlgorithm(graphConnections, vertex, visitedElement)) {
                separatedGraphs++;
            }
        }
        return separatedGraphs;
    }

    //możnabyło by się pokusić o wyrzucenie tego dfs do osobnej klasy np AlgorithmOperations~w przupadku gdyby było wiecej róznych algrotym używanych w aplikacji
    //ale no kwestia gustu i aplikacji, tu wszytsko tyczy sie tego samego to zostawiłem w operacjach
    boolean depthFirstSearchAlgorithm(Map<Integer, Integer> graphConnections, int startVertex, Set<Integer> visitedElement) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visitedElement.contains(currentVertex)) {
                int neighbor = graphConnections.get(currentVertex);
                stack.push(neighbor);
                visitedElement.add(neighbor);
            }
        }
        return true;
    }
}
