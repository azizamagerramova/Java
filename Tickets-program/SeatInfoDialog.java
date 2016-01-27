

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeatInfoDialog extends JDialog {
	private JButton okButton;
        
        private int[] seatsSold;
	private float[] money;
        private int totalSeats;
        private float totalMoney;

	public SeatInfoDialog(Stadium stadium){
		super((JDialog)null,"Administrator Sales Report",true);
                
                seatsSold = new int[4];
                money = new float[4];

		// Add the components
        	setLayout(new GridLayout(8,3));

   		JLabel aLabel = new JLabel("GAME");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SEATS SOLD");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SALES");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

                for (int i=0; i< stadium.getSeats().length; i++){
                    for (int j=0; j< stadium.getSeats()[i].length; j++){
                        if (stadium.getSeat(i, j) != null) {
                            for (int ii = 0; ii < 4; ii++) {
                                if (stadium.getSeat(i, j).isSold(ii)) {
                                    seatsSold[ii]++;
                                    money[ii] += stadium.getSeat(i, j).getPrice();
                                }
                            }
                        }
                    }
                }
        	
                for (int i = 0; i < 4; i++) {
                    aLabel = new JLabel(Integer.toString(i+1));
                    aLabel.setHorizontalAlignment(JLabel.CENTER);
                    add(aLabel); 
                    aLabel = new JLabel(Integer.toString(seatsSold[i]));
                    aLabel.setHorizontalAlignment(JLabel.CENTER);
                    add(aLabel);
                    aLabel = new JLabel("$" + Float.toString(money[i]));
                    aLabel.setHorizontalAlignment(JLabel.CENTER);
                    add(aLabel);
                }
		
                
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

                
                for (float f : money) totalMoney += f;
                for (int i : seatsSold) totalSeats += i;
                totalMoney = totalMoney * 1.13f;
                
		aLabel = new JLabel("TOTAL");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel(Integer.toString(totalSeats));
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("$" + Float.toString(totalMoney));
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

        	aLabel = new JLabel("");	// Leave a blank
		add(aLabel);
		aLabel = new JLabel("");	// Leave a blank
		add(aLabel);
                okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            dispose();
                        }});	
        	add(okButton);

		// Prevent the window from being resized
		setSize(300, 240);
		setResizable(false);
                setVisible(true);
	}
}