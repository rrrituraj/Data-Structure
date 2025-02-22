package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> adj;
    private static int timer = 0;

    public Graph(int v) {
        this.V = v;
        this.adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adj.get(from).add(to);
        adj.get(to).add(from); //for undirected graph
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

    void bridgeUtil(int u, boolean[] visited, int[] discovery, int[] low, int[] parent) {
        visited[u] = true;
        discovery[u] = low[u] = ++timer;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, discovery, low, parent);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > low[u]) {
                    System.out.println("bridge found: " + u + "-->" + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

    void findBridges() {
        boolean[] visited = new boolean[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bridgeUtil(i, visited, discovery, low, parent);
            }

        }
    }

    void dfsTraversal() {
        boolean[] visited = new boolean[V];
        dfs(7, visited, adj);
    }
    //returns no of provinces in graph

    /**
     * run for these
     * graph.addEdge(1, 2);
     * graph.addEdge(2, 3);
     * graph.addEdge(4, 5);
     * graph.addEdge(5, 6);
     * graph.addEdge(7, 8);
     *
     * @return
     */
    public int noOfProvinces() {
        int counter = 0;
        boolean[] visited = new boolean[V];
        for (int i = 1; i < V; i++) {
            if (!visited[i]) {
                counter++;
                dfs(i, visited, adj);
            }
        }
        return counter;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.println("visited the node: " + node);
        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfs(v, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);

        /*if (graph.isCycle()) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("Cycle not detected");
        }*/
//        graph.findBridges();
//        for (int i = 0; i < graph.V; i++) {
//            if (graph.isNotSafeNode(i)) {
//                System.out.println(i + " is not a Safe node");
//            } else {
//                System.out.println(i + " is a Safe node");
//            }
//        }
//        graph.dfsTraversal();
        System.out.println("no of provinces in the graph: " + graph.noOfProvinces());
    }

}
