package pl.krysinski;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number of connections (or 'q' to quit): ");
            if (scanner.hasNextInt()) {
                int connectionsNumber = scanner.nextInt();
                Map<Integer, Set<Integer>> graphConnectionsMap = getGraphConnectionsMap(connectionsNumber, scanner);
                if (!graphConnectionsMap.isEmpty()) {
                    int separatedGraphs = countSeparatedGraphs(graphConnectionsMap);
                    System.out.println(separatedGraphs);
                }
            } else {
                String userInput = scanner.next();
                if (userInput.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer or 'q' to quit.");
                }
            }
        }

        scanner.close();

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
                System.out.println("Input is not a integer value.");
                scanner.nextLine();
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
            if (!visitedElement.contains(vertex) && breadthFirstSearchAlgorithm(graphConnections, vertex, visitedElement)) {
                separatedGraphs++;
            }
        }

        return separatedGraphs;
    }

    private static boolean breadthFirstSearchAlgorithm(Map<Integer, Set<Integer>> graphConnections, int startVertex, ArrayList<Integer> visitedElement) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : graphConnections.getOrDefault(currentVertex, Collections.emptySet())) {
                if (!visitedElement.contains(neighbor)) {
                    if (currentVertex == neighbor) {
                        return false;
                    }
                    queue.add(neighbor);
                    visitedElement.add(neighbor);
                }
            }
        }
        return true;
    }
}
