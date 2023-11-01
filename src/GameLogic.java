import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameLogic {

    private GameBoard gameBoard;
    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    private JButton[][] tiles; // En referens till vår tiles array, används i metoden swapTileWithEmptySlot

    protected GameLogic(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    protected int getEmptySlotRow() {
        return emptySlotRow;
    }

    protected int getEmptySlotColumn() {
        return emptySlotColumn;
    }

    protected void setTiles(JButton[][] tiles) {
        this.tiles = tiles;
    }

    protected boolean isTileMoveable(int row, int column) {
        int rowDifference = Math.abs(emptySlotRow - row);
        int columnDifference = Math.abs(emptySlotColumn - column);
        return (rowDifference == 1 && columnDifference == 0 || rowDifference == 0 && columnDifference == 1);
    }


    protected void swapTileWithEmptySlot(int clickedRow, int clickedColumn) {
        if (isTileMoveable(clickedRow, clickedColumn)) {

            String clicked = tiles[clickedRow][clickedColumn].getText();
            tiles[emptySlotRow][emptySlotColumn].setText(clicked);
            tiles[clickedRow][clickedColumn].setText("");

            emptySlotRow = clickedRow;
            emptySlotColumn = clickedColumn;
        }
    }


    private int[] generateRandomNumbers() { // En metod som genererar random nummer till oss när ett nytt spel startar

        int[] numbers = new int[15];

        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1;
        }

        Random random = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {

            int j = i + random.nextInt(numbers.length - i);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }



    protected void startNewGame() { // En metod för att kunna trycka på nytt spel
        int[] numbers = generateRandomNumbers();
        int index = 0;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (index < 15) {
                    tiles[row][column].setText(String.valueOf(numbers[index]));
                    index++;
                } else {
                    tiles[row][column].setText("");
                    emptySlotRow = row;
                    emptySlotColumn = column;
                }
                gameBoard.isTileEmptySetRed();
            }
        }
    }


    protected boolean isGameSolved() { // Metod för att se om spelet är löst
        int expectedValue = 1;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (!tiles[row][column].getText().equals("")) {
                    int tileValue = Integer.parseInt(tiles[row][column].getText());
                    if (tileValue != expectedValue) {
                        return false;
                    }
                    expectedValue++;
                }
            }
        }
        return true;
    }


    protected void easyMode() {
        int tileValue = 1;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (row == 3 && column == 2) {
                    tiles[row][column].setText("");
                    emptySlotRow = row;
                    emptySlotColumn = column;
                }
                else if (row == 3 && column == 3) {
                    tiles[row][column].setText("15");
                }
                else {
                    tiles[row][column].setBackground(UIManager.getColor("Button.background"));
                    tiles[row][column].setText(String.valueOf(tileValue));
                    tileValue++;
                }
                gameBoard.isTileEmptySetRed();
            }
        }
    }
}


