import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[] buttons;
    private JPanel emptySlot;

    public OurActionListener(JButton[] buttons, JPanel emptySlot){
        this.buttons = buttons;
        this.emptySlot = emptySlot;

    }

    @Override
    public void actionPerformed(ActionEvent e) { //ändrat nedan
        if(e.getSource() == buttons){
           //Booleansk variabel som kollar om knappen kan flyttas, dvs om emptySlot finns över, under,
           // eller vid sidan av knappen
            //EV en toggler här?
        }
    }
}
