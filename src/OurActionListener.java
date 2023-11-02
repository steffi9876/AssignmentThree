import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[][] tile;
    private GameLogic gameLogic;
    private GameBoard gameBoard;


    public OurActionListener(JButton[][] tile, GameLogic gameLogic, GameBoard gameBoard) {
        this.tile = tile;
        this.gameLogic = gameLogic;
        this.gameBoard = gameBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tile = (JButton) e.getSource();
        if(tile.getText().equals("")){
            return;
        }
        int clickedRow = -1;
        int clickedColumn = -1;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (this.tile[row][column] == tile){
                    clickedRow = row;
                    clickedColumn = column;
                    break;
                }
            }
        }
        if (gameLogic.isTileMoveable(clickedRow, clickedColumn)){
            gameLogic.swapTileWithEmptySlot(clickedRow,clickedColumn);
            gameBoard.isTileEmptySetRed();
        }
        if (gameLogic.isGameSolved()){
            gameBoard.showWinnerMessage();
        }
    }
}
