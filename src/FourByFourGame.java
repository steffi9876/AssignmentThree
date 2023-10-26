import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;

public class FourByFourGame extends JFrame {

    JPanel mainPanel = new JPanel();

    JButton oneB = new JButton("1");
    JButton twoB = new JButton("2");
    JButton threeB = new JButton("3");
    JButton fourB = new JButton("4");
    JButton fiveB = new JButton("5");
    JButton sixB = new JButton("6");
    JButton sevenB = new JButton("7");
    JButton eightB = new JButton("8");
    JButton nineB = new JButton("9");
    JButton tenB = new JButton("10");
    JButton elevenB = new JButton("11");
    JButton twelveB = new JButton("12");
    JButton thirteenB = new JButton("13");
    JButton fourteenB  = new JButton("14");
    JButton fifteenB = new JButton("15");
    JPanel emptySlot = new JPanel(" ");


public void game(){

    this.add(mainPanel);
    mainPanel.add(oneB);
    mainPanel.add(twoB);
    mainPanel.add(threeB);
    mainPanel.add(fourB);
    mainPanel.add(fiveB);
    mainPanel.add(sixB);
    mainPanel.add(sevenB);
    mainPanel.add(eightB);
    mainPanel.add(nineB);
    mainPanel.add(tenB);
    mainPanel.add(elevenB);
    mainPanel.add(twelveB);
    mainPanel.add(thirteenB);
    mainPanel.add(fourteenB);
    mainPanel.add(fifteenB);
    mainPanel.add(emptySlot);

    mainPanel.setLayout(new GridLayout(4, 4));




    OurActionListener listener = new OurActionListener(oneB);
    oneB.addActionListener(listener);

    setVisible(true);
    setLocationRelativeTo(null);
    setSize(400,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


}


    public static void main(String[] args) {
    FourByFourGame f = new FourByFourGame();
        f.game();
    }
}