package pl.krysinski;

import java.util.*;

/**
 * Hello world!
 */

class Vertex {
    private int id;
    private boolean visited;
    private List<Integer> neighbors = new LinkedList<>();

    Vertex(int id) {
        this.id = id;
        this.visited = false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Integer> getNeighbors() {
        return neighbors;
    }
}

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer, Vertex> graph = new HashMap<>();
        List<Vertex> graph2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Vertex v = new Vertex(a);
            v.getNeighbors().add(b);
            graph2.add(new Vertex(a));
            Vertex v2 = new Vertex(b);
            v2.getNeighbors().add(a);
            graph2.add(new Vertex(a));
            graph.put(a, v);
            graph.put(b, v2);

        }

        int separatedGraphs = countGraphs(graph);
        System.out.println(separatedGraphs);
    }

    private static int countGraphs(Map<Integer, Vertex> graph) {
        int separatedGraphs = 0;

        for (Vertex vertex : graph.values()) {
            if (!vertex.isVisited()) {
                bfs(graph, vertex);
                separatedGraphs++;
            }
        }

        return separatedGraphs;
    }

    private static void bfs(Map<Integer, Vertex> graph, Vertex startVertex) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        startVertex.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int neighborId : currentVertex.getNeighbors()) {
                Vertex neighborVertex = graph.get(neighborId);
                if (neighborVertex != null && !neighborVertex.isVisited()) {
                    queue.add(neighborVertex);
                    neighborVertex.setVisited(true);
                }
            }
        }
    }
}

