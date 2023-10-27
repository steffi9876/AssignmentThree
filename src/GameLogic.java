import javax.swing.*;

public class GameLogic {

    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    private JButton[][] tiles; // En referens till vår tiles array, används i metoden swapTileWithEmptySlot
    public void setUpBoard(/*Button[] tiles, JPanel mainPanel, JPanel emptySlot*/) {

      /*  int number = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    mainPanel.add(emptySlot);
                } else {
                    JButton tile = new JButton(String.valueOf(number++));
                    tile.setActionCommand(i + "," + j);
                    tiles[number - 2] = tile;
                    mainPanel.add(tile);
                }
            }
        }*/
    }


    public boolean isTileMoveable(int x, int y){

        if(x == emptySlotRow - 1 && y == emptySlotColumn){
            return true;
        }
        else if (x == emptySlotRow + 1 && y == emptySlotColumn){
            return true;
        }
        else if (x == emptySlotRow && y == emptySlotColumn - 1){
            return true;
        }
        else if (x == emptySlotRow && y == emptySlotColumn + 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void swapTileWithEmptySlot(int clickedRow, int clickedCol){
        if (isTileMoveable(clickedRow, clickedCol)){
            String clicked = tiles[clickedRow][clickedCol].getText();
            tiles[emptySlotRow][emptySlotColumn].setText(clicked);
            tiles[clickedRow][clickedCol].setText("");

            emptySlotRow = clickedRow;
            emptySlotColumn = clickedCol;
        }



    }

    public void shuffleTiles(){

    }




}
