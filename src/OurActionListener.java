import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[][] tiles;
    private GameLogic gameLogic;
    public OurActionListener(JButton[][] tile, GameLogic gameLogic){
        this.tiles = tile;
        this.gameLogic = gameLogic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       JButton clickedButton = (JButton) e.getSource();
       int clickedRow = -1, clickedCol = -1;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (tiles[row][col] == clickedButton) {
                    clickedRow = row;
                    clickedCol = col;
                    break;
                }
            }
        }
        if (clickedRow != 1 && clickedCol != -1){
            boolean moveable = gameLogic.isTileMoveable(clickedRow, clickedCol);
            if (moveable){
                gameLogic.swapTileWithEmptySlot(clickedRow, clickedCol);
                //if (gameLogic.)
                }
            }
        }
        }

