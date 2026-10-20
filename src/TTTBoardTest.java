import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TTTBoardTest {

    @Test
    void newBoardSquareIsValidMove() {
        TTTBoard b = new TTTBoard();
        assertTrue(b.isValidMove(0, 0));
    }

    @Test
    void takenSquareIsNotValidMove() {
        TTTBoard b = new TTTBoard();
        b.setMove(1, 1, "X");
        assertFalse(b.isValidMove(1, 1));
    }

    @Test
    void topRowWinForX() {
        TTTBoard b = new TTTBoard();
        b.setMove(0, 0, "X");
        b.setMove(0, 1, "X");
        b.setMove(0, 2, "X");
        assertTrue(b.isWin("X"));
        assertFalse(b.isWin("O"));
    }

    @Test
    void diagonalWinForO() {
        TTTBoard b = new TTTBoard();
        b.setMove(0, 2, "O");
        b.setMove(1, 1, "O");
        b.setMove(2, 0, "O");
        assertTrue(b.isWin("O"));
    }

    @Test
    void fullBoardWithNoWinnerIsTie() {
        TTTBoard b = new TTTBoard();
        // X O X
        // X O O
        // O X X
        b.setMove(0, 0, "X"); b.setMove(0, 1, "O"); b.setMove(0, 2, "X");
        b.setMove(1, 0, "X"); b.setMove(1, 1, "O"); b.setMove(1, 2, "O");
        b.setMove(2, 0, "O"); b.setMove(2, 1, "X"); b.setMove(2, 2, "X");
        assertTrue(b.isTie());
    }

    @Test
    void clearBoardMakesSquaresOpenAgain() {
        TTTBoard b = new TTTBoard();
        b.setMove(2, 2, "X");
        b.clearBoard();
        assertTrue(b.isValidMove(2, 2));
    }
}