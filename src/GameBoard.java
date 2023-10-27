import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame { //alternativt namn GameBoard

    JPanel mainPanel = new JPanel();
    JButton [] tiles = new JButton[15];
    JPanel emptySlot = new JPanel();


public void game(){

    add(mainPanel);
    mainPanel.setLayout(new GridLayout(4, 4));

    int index = 0;
    for(int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (i == 3 && j == 3){
                mainPanel.add(emptySlot);
            }
            else {
                JButton tile = new JButton(String.valueOf(i + 1));
                tile.setActionCommand(i + ", " + j);
                tiles[index++] = tile;
                mainPanel.add(tile);
            }

        }

    }




   // mainPanel.add(emptySlot);

    OurActionListener listener = new OurActionListener(tiles, emptySlot);//ändrat här
    for (JButton button : tiles) {
        button.addActionListener(listener);
    }

    setVisible(true);
    setLocationRelativeTo(null);
    setSize(400,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

}


    public static void main(String[] args) {
    GameBoard f = new GameBoard();
        f.game();
    }
}