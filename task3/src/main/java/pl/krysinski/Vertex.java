package pl.krysinski;

import java.util.LinkedList;
import java.util.List;

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
