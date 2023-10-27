import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OurActionListener implements ActionListener {

    private JButton[] buttons;
    private JPanel emptySlot;
    //private GameLogic gameLogic; // en referens till gamelogic klassen

    public OurActionListener(JButton[] buttons, JPanel emptySlot){ // Lägga till gamelogic här?
        this.buttons = buttons;
        this.emptySlot = emptySlot;
        //this.gameLogic = gameLogic;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* JButton clickedButton = (JButton) e.getSource();

        String[] coordinates = clickedButton.getActionCommand().split(",");
        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);

        if (gameLogic.isTileMoveable(row, col)) {
            gameLogic.swapTileWithEmptySlot(row, col);
        }*/




        //ändrat nedan
        //if(e.getSource() == buttons){
           //Booleansk variabel som kollar om knappen kan flyttas, dvs om emptySlot finns över, under,
           // eller vid sidan av knappen
            //EV en toggler här?
        }
    }

