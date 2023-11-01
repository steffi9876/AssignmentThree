import javax.swing.*;
import java.awt.*;

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

    public boolean isTileMoveable(int row, int column) {

        // Beräkna skillnaden i rad och kolumn mellan den tomma brickan och den klickade brickan
        int rowDifference = Math.abs(emptySlotRow -row);
        int columnDifference = Math.abs(emptySlotColumn - column);

        return (rowDifference == 1 && columnDifference == 0 || rowDifference == 0 && columnDifference == 1); // Kontrollera om brickan kan flyttas enbart i horisontell eller vertikal riktning
        // Returnerar true om brickan kan flyttas, annars false
    }


    public void swapTileWithEmptySlot(int clickedRow, int clickedColumn) {
        if (isTileMoveable(clickedRow, clickedColumn)) { // Ropa på metoden isTileMoveable för att kolla om brickan flyttas

            String clicked = tiles[clickedRow][clickedColumn].getText(); // Hämta texten på den klickade brickan
            tiles[emptySlotRow][emptySlotColumn].setText(clicked); // Sätt den tomma brickans text till den klickade brickans text
            tiles[clickedRow][clickedColumn].setText(""); // Sätt dne klickade brickans text till tom

            emptySlotRow = clickedRow; // Uppdatera positionen för den tomma brickan
            emptySlotColumn = clickedColumn;// Uppdatera positionen för den tomma brickan
        }
    }


    public int[] generateRandomNumbers() { // En metod som genererar random nummer till oss när ett nytt spel startar
        int[] numbers = new int[15]; // Skapar en array med plats för 15 tal
        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1; // Fyller arrayen med talen 1-15
        }
        for (int i = 0; i < numbers.length - 1; i++) { // Blandar elementen i arrayen från index 0 till näst sista elementet
            int j = i + (int) (Math.random() * (numbers.length) - i); // Slumpar ett index j
            int temp = numbers[i]; //Sparar värdet på index i, i en temporär variabel
            numbers[i] = numbers[j]; // Byter plats på talen på index i och j
            numbers[j] = temp; // Återställer index j med det sparade värdet
        }
        return numbers; // Returnerar den slumpmässigt blandade arrayen
    }


    public void startNewGame() { // En metod för att kunna trycka på nytt spel
        int[] numbers = generateRandomNumbers(); // Vi ropar på metoden generateRandomNumbers
        int index = 0; // Börja från index 0

        for (int i = 0; i < 4; i++) { // Loopar genom radena
            for (int j = 0; j < 4; j++) { // Loopar genom kolumnerna

                if (index < 15) { // Om index är mindre än 15, dvs om det finns fler tal att sätta ut på brickorna
                    tiles[i][j].setText(String.valueOf(numbers[index])); // Så sätts texten på brickan till det aktuella talet från arrayen
                    index++;
                } else {
                    tiles[i][j].setText(""); // OM alla 15 tal har placerats, sätt texten på brickan till tom
                    emptySlotRow = i; // Spara raden för den tommar brickan
                    emptySlotColumn = j; // Spara kolumnen för den tomma brickan
                }
                isTileEmptySetRed(); // Vi ropar på metoden som kollar om en bricka är tom så ska den bli röd
            }
        }
    }


    public boolean isGameSolved() { // Metod för att se om spelet är löst
        int expectedValue = 1;

        for (int row = 0; row < 4; row++) { // Det förväntade värdet börjar på 1
            for (int col = 0; col < 4; col++) {

                if (!tiles[row][col].getText().equals("")) { // OM brickan inte är tom
                    int tileValue = Integer.parseInt(tiles[row][col].getText()); // Hämta värdet på brickan som en Integer

                    if (tileValue != expectedValue) { // OM brickans värde inte matchar det förväntade värdet
                        return false; // Spelet är inte löst
                    }
                    expectedValue++; // Om den kommer ner hit så öka värdet för nästa bricka
                }
            }
        }
        return true; // Alla brickor har rätt värden i rätt ordning, spelet är löst
    }


    public void easyMode() {
        int tileValue = 1; // Värdet som används för att fylla brickorna

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
                isTileEmptySetRed(); // Vi ropar på metoden som kollar om en bricka är tom så ska den bli röd
            }
        }
    }


    public void isTileEmptySetRed() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                if (tiles[row][col].getText().equals("")) { // OM brickan är tom
                    tiles[row][col].setBackground(Color.RED); // Markera brickan som röd
                }
                else{ // Om brickan inte är tom
                    tiles[row][col].setBackground(UIManager.getColor("Button.background")); // Återställ bakrundsfärgen till standard
                }
            }
        }
    }
}


