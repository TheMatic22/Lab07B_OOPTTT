public class TTTBoard {
    private static final int ROWS = 3;
    private static final int COLS = 3;

    private String[][] grid = new String[ROWS][COLS];

    public TTTBoard() {
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = " ";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return grid[row][col].equals(" ");
    }

    public void setMove(int row, int col, String player) {
        grid[row][col] = player;
    }

    public boolean isWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (grid[i][0].equals(player) && grid[i][1].equals(player) && grid[i][2].equals(player)) {
                return true;
            }
            if (grid[0][i].equals(player) && grid[1][i].equals(player) && grid[2][i].equals(player)) {
                return true;
            }
        }
        if (grid[0][0].equals(player) && grid[1][1].equals(player) && grid[2][2].equals(player)) {
            return true;
        }
        if (grid[0][2].equals(player) && grid[1][1].equals(player) && grid[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    public boolean isTie() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }
}