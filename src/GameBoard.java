import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame { //alternativt namn GameBoard

    JPanel mainPanel = new JPanel();
    JButton[] tiles = new JButton[15]; // Ändra till [][]
    JPanel emptySlot = new JPanel();
    JButton newGame = new JButton("Nytt spel"); // Vi behöver en knapp genererar nytt spel, jag har ej lagt till den än

    public void game() {

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(4, 4));

        int[] numbers = GameLogic.generateRandomNumbers(); // Denna får knapparna random placerade

        for (int i = 0; i < 15; i++) {
            tiles[i] = new JButton(String.valueOf(numbers[i])); // Denna får knapparna random placerade
            //tiles[i] = new JButton(String.valueOf(i + 1)); // Gammal, men vill ej ta bort!
            mainPanel.add(tiles[i]);
        }

        mainPanel.add(emptySlot);


        ActionListener listener = new OurActionListener(tiles, emptySlot); //
        for (JButton button : tiles) {
            button.addActionListener(listener);

        }

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        GameBoard g = new GameBoard();
        g.game();
    }


}