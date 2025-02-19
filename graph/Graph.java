package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> adj;

    public Graph(int v) {
        this.V = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adj.get(from).add(to);
    }

    public boolean isCycleUtil(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        if (recStack[node]) {
            return true; // cycle detected
        }
        if (visited[node]) {
            return false; // already processed
        }
        visited[node] = true;
        recStack[node] = true;
        for (int neighbour : adj.get(node)) {
            if (isCycleUtil(neighbour, visited, recStack, adj)) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }

    public boolean isCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleUtil(i, visited, recStack, adj)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNotSafeNode(int node) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        return !visited[node] && isCycleUtil(node, visited, recStack, adj);
    }

    /**
     * 0->1
     * 1->2
     * 2->3
     * 2->4
     * 3->4
     * 4->5
     * 5->6
     */
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
//        graph.addEdge(4, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        /*if (graph.isCycle()) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("Cycle not detected");
        }*/
        for (int i = 0; i < graph.V; i++) {
            if (graph.isNotSafeNode(i)) {
                System.out.println(i + " is not a Safe node");
            } else {
                System.out.println(i + " is a Safe node");
            }
        }
    }

}
