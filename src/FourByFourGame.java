import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;

public class FourByFourGame extends JFrame {

    JPanel mainPanel = new JPanel();
    JButton [] buttons = new JButton[15];
    JPanel emptySlot = new JPanel();


public void game(){

    add(mainPanel);
    mainPanel.setLayout(new GridLayout(4, 4));

    for(int i = 0; i < 15; i++) {
        buttons[i] = new JButton(String.valueOf(i + 1));
        mainPanel.add(buttons[i]);
    }

    mainPanel.add(emptySlot);

    OurActionListener listener = new OurActionListener(buttons, emptySlot);

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