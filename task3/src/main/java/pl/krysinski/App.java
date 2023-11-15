package pl.krysinski;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer, ArrayList<Integer>> graphConnections = getGraphConnections(n, scanner);

        int numberSeparatedGraphs = countSeparatedGraphs(graphConnections);
        System.out.println(numberSeparatedGraphs);
        scanner.close();
    }

    static Map<Integer, ArrayList<Integer>> getGraphConnections(int n, Scanner scanner) {
        Map<Integer, ArrayList<Integer>> graphConnections = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graphConnections.computeIfAbsent(a, neighbour -> new ArrayList<>()).add(b);
            graphConnections.computeIfAbsent(b, neighbour -> new ArrayList<>()).add(a);

        }
        return graphConnections;
    }

    static int countSeparatedGraphs(Map<Integer, ArrayList<Integer>> graphConnections) {
        ArrayList<Integer> visitedElement = new ArrayList<>();
        int separatedGraphs = 0;

        for (int vertex : graphConnections.keySet()) {
            if (!visitedElement.contains(vertex)) {
                breadthFirstSearchAlgorithm(graphConnections, vertex, visitedElement);
                separatedGraphs++;
            }
        }

        return separatedGraphs;
    }

    private static void breadthFirstSearchAlgorithm(Map<Integer, ArrayList<Integer>> graphConnections, int startVertex, ArrayList<Integer> visitedElement) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : graphConnections.get(currentVertex)) {
                if (!visitedElement.contains(neighbor)) {
                    if (graphConnections.size() % 2 == 0) {
                        queue.add(neighbor);
                    }
                    visitedElement.add(neighbor);
                }
            }
        }
    }
}
