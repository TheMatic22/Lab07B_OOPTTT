import javax.swing.*;
import java.awt.*;

public class Game {
    private TTTBoard board;
    private JFrame frame;
    private TTTTileButton[][] tiles = new TTTTileButton[3][3];
    private String currentPlayer = "X";
    private int moveCount = 0;

    public Game() {
        board = new TTTBoard();
        frame = new JFrame("Tic Tac Toe");
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col] = new TTTTileButton(row, col);
                tiles[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                tiles[row][col].setFocusPainted(false);
                tiles[row][col].addActionListener(e -> handleClick((TTTTileButton) e.getSource()));
                boardPanel.add(tiles[row][col]);
            }
        }
        frame.add(boardPanel, BorderLayout.CENTER);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e ->{
            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?","Quit",JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                System.exit(0);
               }
            });
        frame.add(quitButton, BorderLayout.SOUTH);

        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void handleClick(TTTTileButton tile) {
        int row = tile.getRow();
        int col = tile.getCol();

        if (!board.isValidMove(row, col)) {
            JOptionPane.showMessageDialog(frame, "That square is already taken. Pick another.");
            return;
        }

        board.setMove(row, col, currentPlayer);
        tile.setMark(currentPlayer);
        moveCount++;

        if (board.isWin(currentPlayer)) {
            JOptionPane.showMessageDialog(frame, currentPlayer + " wins!");
            resetGame();
        } else if (board.isTie()) {
            JOptionPane.showMessageDialog(frame, "It's a tie!");
            resetGame();
        } else {
            switchPlayer();
        }
    }
    public void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
    public void resetGame() {
        board.clearBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col].setMark(" ");
            }
        }
        currentPlayer = "X";
        moveCount = 0;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}
