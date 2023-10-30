import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}


