package pl.krysinski;

import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of connections: ");
            int connectionsNumber = scanner.nextInt();
            Map<Integer, Integer> graphConnectionsMap = getGraphConnectionsMap(connectionsNumber, scanner);
            int separatedGraphs = countSeparatedGraphs(graphConnectionsMap);
            System.out.println(separatedGraphs);
            scanner.close();
        } catch (InputMismatchException e) {
            System.err.println("Input is not a integer value.");
        }
    }

    static Map<Integer, Integer> getGraphConnectionsMap(int connectionsNumber, Scanner scanner) {
        Map<Integer, Integer> graphConnectionsMap2 = new HashMap<>();
        System.out.println("Enter " + connectionsNumber + " lines of pair connections seperated by a space \n(example:\n1 2\n2 3): ");
        for (int i = 0; i < connectionsNumber; i++) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                graphConnectionsMap2.put(a, b);
                graphConnectionsMap2.put(b, a);
            } catch (InputMismatchException e) {
                System.err.println("Input is not a integer value.");
                graphConnectionsMap2.clear();
                return graphConnectionsMap2;
            }

        }
        return graphConnectionsMap2;
    }

    static int countSeparatedGraphs(Map<Integer, Integer> graphConnections) {
        int separatedGraphs = 0;
        if (graphConnections.isEmpty()) {
            return separatedGraphs;
        }
        ArrayList<Integer> visitedElement = new ArrayList<>();

        for (int vertex : graphConnections.keySet()) {
            if (!visitedElement.contains(vertex) && depthFirstSearchAlgorithm(graphConnections, vertex, visitedElement)) {
                separatedGraphs++;
            }
        }
        return separatedGraphs;
    }


    static boolean depthFirstSearchAlgorithm(Map<Integer, Integer> graphConnections, int startVertex, ArrayList<Integer> visitedElement) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visitedElement.contains(currentVertex)) {
                int neighbor = graphConnections.get(currentVertex);
                if (currentVertex == neighbor) {
                    return false;
                }
                stack.push(neighbor);
                visitedElement.add(neighbor);
            }
        }
        return true;
    }


    static boolean depthFirstSearchAlgorithm2(Map<Integer, Set<Integer>> graphConnections, int startVertex, ArrayList<Integer> visitedElement) {
        if (visitedElement.contains(startVertex)) {
            return false;
        }

        visitedElement.add(startVertex);

        for (int neighbor : graphConnections.getOrDefault(startVertex, Collections.emptySet())) {
            if (!depthFirstSearchAlgorithm2(graphConnections, neighbor, visitedElement)) {
                return false;
            }
        }

        return true;
    }
}
