import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {

    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    // tvådimensionell array
    private JButton[][] tiles; // En referens till vår tiles array, används i metoden swapTileWithEmptySlot

    public GameLogic(JButton[] tiles) { //Ta bort???
    }

    public void setUpBoard() {

    }


    public boolean isTileMoveable(int row, int col){ // ändrade namn till row och col

        if(row == emptySlotRow - 1 && col == emptySlotColumn){
            return true;
        }
        else if (row == emptySlotRow + 1 && col == emptySlotColumn){
            return true;
        }
        else if (row == emptySlotRow && col == emptySlotColumn - 1){
            return true;
        }
        else if (row == emptySlotRow && col == emptySlotColumn + 1) {
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
    } // Ta bort??????

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
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (index < 15){
                    tiles[row][column].setText(String.valueOf(numbers[index]));
                    index++;
                } else {
                    tiles[row][column].setText("");
                    emptySlotRow = row;
                    emptySlotColumn = column;
                }
            }
        }
    }

    private boolean isGameSolved(){ // Metod för att se om spelet är löst
        int expectedValue = 1;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!tiles[row][col].getText().equals("")){
                    int tileValue = Integer.parseInt(tiles[row][col].getText());
                    if (tileValue != expectedValue){
                        return false;
                    }
                    expectedValue++;
                }

            }
        }
        return true;
    }



}
