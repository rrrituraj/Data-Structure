package graph;

import java.util.Arrays;

public class GraphClient {
    public static void main(String[] args) {
        new GraphClient().graphRepresentation(4,5);
    }

    public void graphRepresentation(int n, int e) {
        String rep = "0->1,0->2,2->0,2->3,3->3,1->2";
        int[][] adjMatrix = new int[n][n];
        String[] splitRepByComma = rep.split(",");
        Arrays.stream(splitRepByComma).forEach(rep1 -> {
            String[] splitRep1 = rep1.split("->");
            int from = Integer.parseInt(splitRep1[0]);
            int to = Integer.parseInt(splitRep1[1]);
            adjMatrix[from][to] = 1;
        });
        System.out.println(Arrays.toString(adjMatrix));
    }
}
