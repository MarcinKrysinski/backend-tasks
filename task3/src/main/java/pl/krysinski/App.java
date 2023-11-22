package pl.krysinski;

import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of connections: ");
            int connectionsNumber = scanner.nextInt();
            Map<Integer, Set<Integer>> graphConnectionsMap = getGraphConnectionsMap(connectionsNumber, scanner);
            int separatedGraphs = countSeparatedGraphs(graphConnectionsMap);
            System.out.println(separatedGraphs);
            scanner.close();
        } catch (InputMismatchException e) {
            System.err.println("Input is not a integer value.");
        }
    }

    static Map<Integer, Set<Integer>> getGraphConnectionsMap(int connectionsNumber, Scanner scanner) {
        Map<Integer, Set<Integer>> graphConnectionsMap = new HashMap<>();
        System.out.println("Enter " + connectionsNumber + " lines of pair connections seperated by a space \n(example:\n1 2\n2 3): ");
        for (int i = 0; i < connectionsNumber; i++) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                graphConnectionsMap.computeIfAbsent(a, neighbour -> new HashSet<>()).add(b);
                graphConnectionsMap.computeIfAbsent(b, neighbour -> new HashSet<>()).add(a);
            } catch (InputMismatchException e) {
                System.err.println("Input is not a integer value.");
                graphConnectionsMap.clear();
                return graphConnectionsMap;
            }

        }
        return graphConnectionsMap;
    }

    static int countSeparatedGraphs(Map<Integer, Set<Integer>> graphConnections) {
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

    static boolean depthFirstSearchAlgorithm(Map<Integer, Set<Integer>> graphConnections, int startVertex, ArrayList<Integer> visitedElement) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            for (int neighbor : graphConnections.getOrDefault(currentVertex, Collections.emptySet())) {
                if (!visitedElement.contains(neighbor)) {
                    if (currentVertex == neighbor) {
                        return false;
                    }
                    stack.push(neighbor);
                    visitedElement.add(neighbor);
                }
            }
        }
        return true;
    }
}
