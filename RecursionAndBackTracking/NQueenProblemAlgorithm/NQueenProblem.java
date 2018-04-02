package RecursionAndBackTracking.NQueenProblemAlgorithm;

public class NQueenProblem {
    public Position[] solvedNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solvedNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solvedNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col
                        || positions[queen].row - positions[queen].col == row - col
                        || positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solvedNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Position {
        final int row, col;

        private Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Position{" + "row=" + row + ", col=" + col + '}';
        }
    }
}
