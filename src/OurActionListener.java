import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[][] tile;
    private JPanel emptySlot;

    public OurActionListener(JButton[][] tile, JPanel emptySlot){
        this.tile = tile;
        this.emptySlot = emptySlot;

    }

    @Override
    public void actionPerformed(ActionEvent e) { //ändrat nedan
        if(e.getSource() == tile){
           //Booleansk variabel som kollar om knappen kan flyttas, dvs om emptySlot finns över, under,
           // eller vid sidan av knappen
            //EV en toggler här?
        }
    }
}
