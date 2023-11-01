import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GameBoard extends JFrame {

    GameLogic gameLogic = new GameLogic();

    Border outerBorder = BorderFactory.createLineBorder(Color.RED, 10);
    Border tileBorder = BorderFactory.createLineBorder(Color.RED, 5);
    JPanel foundation = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel choicePanel = new JPanel();
    JButton[][] tiles = new JButton[4][4];
    JButton newGame = new JButton("New game");
    JButton easyMode = new JButton("Easy mode");


    public void game() {

        setLayout();

        OurActionListener listener = new OurActionListener(tiles, gameLogic);//anpassat loopen till en 2-dim.  array
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                tiles[row][column].addActionListener(listener);
            }
        }

        gameLogic.startNewGame();
        newGame.addActionListener(e -> gameLogic.startNewGame());
        easyMode.addActionListener(e -> gameLogic.easyMode());
    }


    public void setLayout(){

        add(foundation);
        foundation.setLayout(new BorderLayout());

        foundation.add(choicePanel, BorderLayout.NORTH);
        foundation.add(gamePanel, BorderLayout.CENTER);

        gamePanel.setBorder(outerBorder);
        gamePanel.setBackground(Color.RED);

        gamePanel.setLayout(new GridLayout(4, 4));

        choicePanel.add(newGame);
        choicePanel.add(easyMode);

        newGame.setFont(new Font("Courier New", Font.BOLD, 20));
        easyMode.setFont(new Font("Courier New", Font.BOLD, 20));

        newGame.setForeground(new Color(10, 60, 150));
        easyMode.setForeground(new Color(10, 60, 150));

        setUpBoard();

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                tiles[row][column].setFont(new Font("Courier New", Font.BOLD, 20));
                tiles[row][column].setForeground(new Color(10, 60, 150));
                tiles[row][column].setBorder(tileBorder);
            }
        }

        gameLogic.setTiles(tiles);
        gamePanel.revalidate();

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public void setUpBoard(){
        int tileNumber = 1;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if(row == gameLogic.getEmptySlotRow() && column == gameLogic.getEmptySlotColumn()){
                    tiles[row][column] = new JButton("");
                    tiles[row][column].setBackground(Color.RED);
                    gamePanel.add(tiles[row][column]);
                }
                else {
                    tiles[row][column] = new JButton((String.valueOf(tileNumber)));
                    gamePanel.add(tiles[row][column]);
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