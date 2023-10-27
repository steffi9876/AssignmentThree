import javax.swing.*;

public class GameLogic {

    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    private JButton[][] tiles; // En referens till vår tiles array, används i metoden swapTileWithEmptySlot


    public int getEmptySlotRow() {
        return emptySlotRow;
    }

    public int getEmptySlotColumn() {
        return emptySlotColumn;
    }

    public void setTiles(JButton[][] tiles) {
        this.tiles = tiles;
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
