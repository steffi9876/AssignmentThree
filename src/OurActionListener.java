import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton oneB;
    private JButton twoB;
    private JButton threeB;
    private JButton fourB;
    private JButton fiveB;
    private JButton sixB;
    private JButton sevenB;
    private JButton eightB;
    private JButton nineB;
    private JButton tenB;
    private JButton elevenB;
    private JButton twelveB;
    private JButton thirteenB;
    private JButton fourteenB;
    private JButton fifteenB;
    private JPanel emptySlot;

    public OurActionListener(JButton oneB, JButton twoB, JButton threeB, JButton fourB,JButton fiveB, JButton sixB,
                             JButton sevenB, JButton eightB, JButton nineB, JButton tenB, JButton elevenB,
                             JButton twelveB, JButton thirteenB, JButton fourteenB, JButton fifteenB, JPanel emptySlot){
        this.oneB = oneB;
        this.twoB = twoB;
        this.threeB = threeB;
        this.fourB = fourB;
        this.fiveB = fiveB;
        this.sixB = sixB;
        this.sevenB = sevenB;
        this.eightB = eightB;
        this.nineB = nineB;
        this.tenB = tenB;
        this.elevenB = elevenB;
        this.twelveB = twelveB;
        this.thirteenB = thirteenB;
        this.fourteenB = fourteenB;
        this.fifteenB = fifteenB;
        this.emptySlot = emptySlot;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == oneB){
            System.out.println("Ok");
        }
    }
}
