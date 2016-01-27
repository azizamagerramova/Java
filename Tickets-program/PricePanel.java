import java.awt.*;
import javax.swing.*;

public class PricePanel extends JPanel{
	
    JLabel seats = new JLabel("Seat(s) Pricing: ");
    JLabel hst = new JLabel("HST: ");
    JLabel cost = new JLabel("Total Cost: ");

    JTextField seatTextField = new JTextField();
    JTextField hstTextField = new JTextField();
    JTextField costTextField = new JTextField();

    public JTextField getSeatText(){ return seatTextField; }
    public JTextField getHstText(){ return hstTextField; }
    public JTextField getCostText(){ return costTextField; }
    
    public void setSeatText(double seatCost) {
        seatTextField.setText(moneyFormat(seatCost));
    }

    public void setHstText(Float f) {
        hstTextField.setText(moneyFormat(f));
    }
    public void setCostText(Float f) {
        costTextField.setText(moneyFormat(f));
    }
    
    private String moneyFormat(double seatCost) {
        String text = String.format("%10.2f", seatCost);
        return "$" + text;
    }
    
    public PricePanel(String title){
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new GridLayout(4,2));
        add(seats);
        add(seatTextField);
        add(hst);
        add(hstTextField);
        add(cost);
        add(costTextField);
        setVisible(true);
    }
}
