import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {

    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    private JButton[][] tiles; // En referens till vår tiles array, används i metoden swapTileWithEmptySlot

    public GameLogic(JButton[] tiles) { //Ta bort???
    }

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
        List<Integer> tileValues = new ArrayList<>();

        for (int i = 0; i <=15 ; i++) {
            tileValues.add(i);
        }
        Collections.shuffle(tileValues);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int tileValue = tileValues.get(index);
                if (tileValue == 15) {
                    tiles[i][j].setText("");
                } else {
                    tiles[i][j].setText(Integer.toString(tileValue));
                }
                index++;
            }
        }
    }

    public static int[] generateRandomNumbers(){ // En metod som genererar random nummer till oss när ett nytt spel startar
        int[] numbers = new int[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 0; i < numbers.length -1; i++) {
            int j = i + (int) (Math.random() * (numbers.length) -i);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    private void startNewGame(){ // En metod för att kunna trycka på nytt spel
        int[] numbers = generateRandomNumbers();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (index < 15){
                    tiles[i][j].setText(String.valueOf(numbers[index]));
                    index++;
                } else {
                    tiles[i][j].setText("");
                    emptySlotRow = i;
                    emptySlotColumn = j;
                }
            }
        }
    }



}
