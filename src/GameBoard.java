import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame { //alternativt namn GameBoard

    JPanel mainPanel = new JPanel();
    JButton[] tiles = new JButton[15];
    JPanel emptySlot = new JPanel();
    //GameLogic gameLogic; // en instans av gamelogic
    //OurActionListener actionListener; // en instans av OurActionListener


    public void game() {

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 15; i++) {
            tiles[i] = new JButton(String.valueOf(i + 1));
            mainPanel.add(tiles[i]);
        }

        mainPanel.add(emptySlot);

        //gameLogic = new GameLogic(tiles);

        ActionListener listener = new OurActionListener(tiles, emptySlot); // lägga till gamelogic??
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