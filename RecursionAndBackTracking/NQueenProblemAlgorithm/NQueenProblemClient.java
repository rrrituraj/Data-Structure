package RecursionAndBackTracking.NQueenProblemAlgorithm;

public class NQueenProblemClient {
    public static void main(String[] args) {
        NQueenProblem.Position[] positions = new NQueenProblem().solvedNQueenOneSolution(4);
        showPositions(positions);
    }

    private static void showPositions(NQueenProblem.Position[] positions) {
        for (NQueenProblem.Position position : positions) {
            System.out.println(position + "  ");
        }
        System.out.println();
    }
}
