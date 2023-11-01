import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GameBoard extends JFrame {

    private GameLogic gameLogic = new GameLogic(this);
    private JPanel foundation = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel choicePanel = new JPanel();
    private JButton[][] tiles = new JButton[4][4];

    private JButton newGame = new JButton("New game");
    private JButton easyMode = new JButton("Easy mode");

    private Color darkRed = new  Color(200, 40, 40);
    private Color inkBlue = new Color(10, 60, 150);
    private Border border = BorderFactory.createLineBorder(darkRed, 5);
    private String message = "Grattis, du vann!";


    private void game() {

        setUpPanels();
        setUpTiles();
        setUpBoard();
        setUpJFrameSettings();

        OurActionListener listener = new OurActionListener(tiles, gameLogic, this);//anpassat loopen till en 2-dim.  array
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                tiles[row][column].addActionListener(listener);
            }
        }

        gameLogic.startNewGame();
        newGame.addActionListener(e -> gameLogic.startNewGame());
        easyMode.addActionListener(e -> gameLogic.easyMode());
    }


    private void setUpPanels(){
        add(foundation);
        foundation.setLayout(new BorderLayout());
        foundation.add(choicePanel, BorderLayout.NORTH);
        foundation.add(gamePanel, BorderLayout.CENTER);

        gamePanel.setBorder(border);
        gamePanel.setBackground(darkRed);
        gamePanel.setLayout(new GridLayout(4, 4));
    }


    private void setUpTiles(){
        choicePanel.add(newGame);
        choicePanel.add(easyMode);

        newGame.setFont(new Font("Courier New", Font.BOLD, 20));
        easyMode.setFont(new Font("Courier New", Font.BOLD, 20));

        newGame.setForeground(inkBlue);
        easyMode.setForeground(inkBlue);
    }


    private void setUpBoard(){
        setUpBoardTiles();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                tiles[row][column].setFont(new Font("Courier New", Font.BOLD, 20));
                tiles[row][column].setForeground(new Color(10, 60, 150));
                tiles[row][column].setBorder(border);
            }
        }

        gameLogic.setTiles(tiles);
        gamePanel.revalidate();
    }


    private void setUpBoardTiles() {
        int tileNumber = 1;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (row == gameLogic.getEmptySlotRow() && column == gameLogic.getEmptySlotColumn()) {
                    tiles[row][column] = new JButton("");
                    tiles[row][column].setBackground(darkRed);
                    gamePanel.add(tiles[row][column]);
                } else {
                    tiles[row][column] = new JButton((String.valueOf(tileNumber)));
                    gamePanel.add(tiles[row][column]);
                    tileNumber++;
                }
            }
        }
    }


    protected void isTileEmptySetRed() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                if (tiles[row][col].getText().equals("")) {
                    tiles[row][col].setBackground(darkRed);
                }
                else{
                    tiles[row][col].setBackground(UIManager.getColor("Button.background"));
                }
            }
        }
    }

    protected void showWinnerMessage(){
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        JOptionPane.showMessageDialog(null, messageLabel);
    }


    private void setUpJFrameSettings(){
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