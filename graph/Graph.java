package graph;

import java.util.Stack;

class Vertex {
    public char label;
    public boolean visited;

    Vertex(char label) {
        this.label = label;
        visited = false;
    }
}

public class Graph {
    private int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> theStack;
    Graph(){

    }
}
