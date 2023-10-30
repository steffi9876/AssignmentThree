import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[][] tile;
    private GameLogic gameLogic;


    public OurActionListener(JButton[][] tile, GameLogic gameLogic) {
        this.tile = tile;
        this.gameLogic = gameLogic;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //ändrat nedan
        JButton tile = (JButton) e.getSource();//Typomvandlar genom casting för att slippa en e.getSource för 15 knappar
        if(tile.getText().equals("")){ //om den tryckta knappen innehåller en tom sträng "" så gör inget
            return;
        }
        int clickedRow = -1;
        int clickedColumn = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tile[i][j] == tile){
                    clickedRow =1;
                    clickedColumn = j;
                    break;
                }
            }
        }
        if (gameLogic.isTileMoveable(clickedRow, clickedColumn)){
            gameLogic.swapTileWithEmptySlot(clickedRow,clickedColumn);
        }
        if (gameLogic.isGameSolved()){
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");
        }

    }


}
