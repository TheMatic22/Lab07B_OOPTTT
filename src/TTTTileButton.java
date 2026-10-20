import javax.swing.JButton;
import java.awt.*;

public class TTTTileButton extends JButton {
    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        super(" ");
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setMark(String mark) {
        setText(mark);
        if(mark.equals("X")){
            setForeground(new Color(30,100,200));
        }
        else if(mark.equals("O")){
            setForeground(new Color(200,50,50));
        }
    }
}
