import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[][] tile; // Våra spelbrickor
    private GameLogic gameLogic; // En instans av gamelogic klassen


    public OurActionListener(JButton[][] tile, GameLogic gameLogic) { // Konstruktor som tar emot spelbrickor och gameLogic-instansen
        this.tile = tile;
        this.gameLogic = gameLogic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton tile = (JButton) e.getSource(); // Hämtar den knapp (bricka) som utlöste händelsen och lagrar den i variabeln "tile"
        if(tile.getText().equals("")){ //om den tryckta knappen innehåller en tom sträng "" så gör inget
            return;
        }
        int clickedRow = -1;
        int clickedColumn = -1;

        // Loopar igenom raderna och kolumnerna för att hitta den tryckta brickans position
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (this.tile[row][column] == tile){
                    clickedRow = row;
                    clickedColumn = column;
                    break;
                }
            }
        }
        if (gameLogic.isTileMoveable(clickedRow, clickedColumn)){ // Kontrollera om den tryckta brickan kan flyttas med hjälp av spelets logik
            gameLogic.swapTileWithEmptySlot(clickedRow,clickedColumn); // Om brickan kan flyttas, byt plats på brickan med den tomma brickan och uppdatera gränssnittet

            gameLogic.isTileEmptySetRed(); // Kolla om den tomma brickan ska markeras som röd
        }
        if (gameLogic.isGameSolved()){ // Kontrollera om spelet är löst efter draget
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");
        }
    }
}
