import javax.swing.*;
import java.awt.*;


public class GameBoard extends JFrame {
=

    GameLogic gameLogic = new GameLogic();
    JPanel mainPanel = new JPanel();
    JButton[][] tiles = new JButton[4][4];


    public void game() {

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(4, 4));

        setUpBoard();
        gameLogic.setTiles(tiles);

        OurActionListener listener = new OurActionListener(tiles);//anpassat loopen till en 2-dim.  array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j].addActionListener(listener);
            }
        }

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void setUpBoard(){
        int tileNumber = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i == gameLogic.getEmptySlotRow() && j == gameLogic.getEmptySlotColumn()){
                    tiles[i][j] = new JButton("");
                    mainPanel.add(tiles[i][j]);
                }
                else {
                    tiles[i][j] = new JButton(String.valueOf(String.valueOf(tileNumber)));
                    mainPanel.add(tiles[i][j]);
                    tileNumber ++;
                }
            }
        }
    }



    public static void main(String[] args) {
        GameBoard g = new GameBoard();
        g.game();
    }


}