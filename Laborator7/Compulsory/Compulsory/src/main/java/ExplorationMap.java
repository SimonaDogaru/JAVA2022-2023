import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final SharedMemory mem = new SharedMemory(5);

    public ExplorationMap(int n)
    {
        this.matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = new Cell();
            }
        }
    }
    public Cell[][] getMatrix() {
        return matrix;
    }

    //Cell should be a wrapper or alias for List<Token>
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = mem.extractTokens(1);
                matrix[row][col].setTokens(tokens);
                matrix[row][col].setVisited(true);
                System.out.println("Success: Tokens extracted and stored in cell [" + row + "][" + col + "]  ---- " + robot.getName());
                return true;
            } else {
                System.out.println("Failure: Cell [" + row + "][" + col + "] already visited");
                return false;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j].toString());
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}