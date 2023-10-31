import javax.swing.*;
import java.awt.*;


public class GameBoard extends JFrame {


    GameLogic gameLogic = new GameLogic();
    JPanel foundation = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel choicePanel = new JPanel();
    JButton[][] tiles = new JButton[4][4];
    JButton newGame = new JButton("New game");
    JButton easyMode = new JButton("Easy mode");


    public void game() {

        //jPanel.add(southPanel, BorderLayout.SOUTH);

        add(foundation);
        foundation.setLayout(new BorderLayout());

        foundation.add(choicePanel, BorderLayout.NORTH);
        foundation.add(gamePanel, BorderLayout.CENTER);

        gamePanel.setLayout(new GridLayout(4, 4));

        choicePanel.add(newGame);
        choicePanel.add(easyMode);

        setUpBoard();
        gameLogic.setTiles(tiles);
        gamePanel.revalidate();

        OurActionListener listener = new OurActionListener(tiles, gameLogic);//anpassat loopen till en 2-dim.  array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j].addActionListener(listener);
            }
        }

        gameLogic.startNewGame();

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
                    gamePanel.add(tiles[i][j]);
                }
                else {
                    tiles[i][j] = new JButton(String.valueOf(String.valueOf(tileNumber)));
                    gamePanel.add(tiles[i][j]);
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