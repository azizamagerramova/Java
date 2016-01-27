import java.awt.*;
import javax.swing.*;

public class StadiumPanel extends BoardPanel{
	
    private final Stadium stadium;

    //these aren't just buttons. But they're mostly buttons.
    private final Component[][] seatButtons = new Component[Stadium.ROWS][Stadium.COLUMNS];

    public Component[][] getSeatButtons(){ return seatButtons; }
    public Component getSeatButton(int i, int j){ return seatButtons[i][j]; }
    
    public Seat[][] getSeats(){ return stadium.getSeats(); }
    public Seat getSeat(int i, int j){ return stadium.getSeat(i, j); }
    public Stadium getStadium() {return stadium;}

    public StadiumPanel(Stadium s){
        setLayout(new GridLayout(Stadium.ROWS, Stadium.COLUMNS));
        stadium = s;
        arrayBuilder();
        setBackground(Color.WHITE);
    }

    private void arrayBuilder(){
        for (int i=0; i< stadium.getSeats().length; i++){
            for (int j=0; j< stadium.getSeats()[i].length; j++){
                if (stadium.getSeat(i, j) != null) {
                    seatButtons[i][j] = new JButton();
                    add(seatButtons[i][j]);
                    switch(stadium.getSeat(i, j).getSection()){
                        case 1: 
                            seatButtons[i][j].setBackground(Color.RED);
                            break;
                        case 2: 
                            seatButtons[i][j].setBackground(Color.GREEN);
                            break;
                        case 3: 
                            seatButtons[i][j].setBackground(Color.BLUE);
                            break;
                        case 4: 
                            seatButtons[i][j].setBackground(Color.YELLOW);
                            break;
                        default: 
                            break;
                    }
                } else {
                    seatButtons[i][j] = new JLabel();
                    add(seatButtons[i][j]);
                }
            }
        }
    }
}
