import javax.swing.*;
import java.util.Random;

public class GameLogic {

    private GameBoard gameBoard;
    private int emptySlotRow = 3;
    private int emptySlotColumn = 3;
    private JButton[][] tiles;

    protected GameLogic(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    protected int getEmptySlotRow() { // Hämtar raden för den tomma brickan
        return emptySlotRow;
    }

    protected int getEmptySlotColumn() { // Hämtar kolumnen för den tomma brickan
        return emptySlotColumn;
    }

    protected void setTiles(JButton[][] tiles) { // Sätter spelets brickor
        this.tiles = tiles;
    }

    protected boolean isTileMoveable(int row, int column) {
        // Beräkna skillnaden i rad och kolumn mellan den tomma brickan och den klickade brickan
        int rowDifference = Math.abs(emptySlotRow - row);
        int columnDifference = Math.abs(emptySlotColumn - column);

        // Returnerar true om brickan kan flyttas, annars false
        return (rowDifference == 1 && columnDifference == 0 || rowDifference == 0 && columnDifference == 1);
    }


    protected void swapTileWithEmptySlot(int clickedRow, int clickedColumn) {
        if (isTileMoveable(clickedRow, clickedColumn)) {// Ropa på metoden isTileMoveable för att kolla om brickan flyttas

            String clicked = tiles[clickedRow][clickedColumn].getText();// Hämta texten på den klickade brickan
            tiles[emptySlotRow][emptySlotColumn].setText(clicked);// Hämta texten på den klickade brickans text
            tiles[clickedRow][clickedColumn].setText("");

            //Uppdatera positionerna för de tomma brickorna
            emptySlotRow = clickedRow;
            emptySlotColumn = clickedColumn;
        }
    }


    private int[] generateRandomNumbers() {

        int[] numbers = new int[15]; // Skapar en array som kan hålla 15 tal

        for (int i = 0; i < 15; i++) { // Fyller arrayen
            numbers[i] = i + 1;
        }

        Random random = new Random(); // Skapar en random instans

        // Blanda elementen i arrayen
        for (int i = 0; i < numbers.length - 1; i++) {
            // Generera ett slumpmässigt index j
            int j = i + random.nextInt(numbers.length - i);
            //Byter plats på numren på index i och j i arrayen numbers
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers; // returnerar den blandade arrayen numbers
    }


    protected void startNewGame() {
        int[] numbers = generateRandomNumbers(); // Ropa på metoden
        int index = 0; // Börja från index 0

        // Loopa genom rader och kolumner
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (index < 15) { // Om index är mindre än 15, dvs om det finns fler tal att sätta ut på brickorna
                    tiles[row][column].setText(String.valueOf(numbers[index])); // Så sätts texten på brickan till det aktuella talet från arrayen
                    index++;
                    index++;
                } else {
                    tiles[row][column].setText(""); // OM alla 15 tal har placerats, sätt texten på brickan till tom
                    // Spara raden/kolumnen för den tomma brickan
                    emptySlotRow = row;
                    emptySlotColumn = column;
                }
                gameBoard.isTileEmptySetRed();// Vi ropar på metoden som kollar om en bricka är tom så ska den bli röd
            }
        }
    }


    protected boolean isGameSolved() {
        int expectedValue = 1;// Det förväntade värdet börjar på 1

        // Loopa
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (!tiles[row][column].getText().equals("")) { // OM brickan inte är tom
                    int tileValue = Integer.parseInt(tiles[row][column].getText()); // Hämta värdet på brickan som en Integer

                    if (tileValue != expectedValue) {// OM brickans värde inte matchar det förväntade värdet
                        return false; // Spelet är inte löst
                    }
                    expectedValue++; // Om den kommer ner hit så öka värdet för nästa bricka
                }
            }
        }
        return true; // Alla brickor har rätt värden i rätt ordning, spelet är löst
    }


    protected void easyMode() {
        int tileValue = 1;// Startvärdet som används för att fylla brickorna

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (row == 3 && column == 2) { // Om det är sista raden och tredje kolumnen, gör brickan tom
                    tiles[row][column].setText("");
                    emptySlotRow = row;
                    emptySlotColumn = column;
                }
                else if (row == 3 && column == 3) { // Om det är sista raden och tredje kolumnen, sätt brickan till 15
                    tiles[row][column].setText("15");
                }
                else {
                    tiles[row][column].setBackground(UIManager.getColor("Button.background")); // Annars sätt bakrundsfärg till standard
                    tiles[row][column].setText(String.valueOf(tileValue)); // Sätt texten på brickan till det aktuella värdet
                    tileValue++; // Öka sedan värdet

                }
                gameBoard.isTileEmptySetRed(); // Vi ropar på metoden som kollar om en bricka är tom så ska den bli röd
            }
        }
    }
}


