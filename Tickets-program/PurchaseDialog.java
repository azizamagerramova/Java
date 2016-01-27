import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PurchaseDialog extends JDialog{
	private JButton okButton;
	private JButton cancelButton;
	private PurchasePanel purchasepan;

	public PurchaseDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setLocationRelativeTo(owner);
		bringUpDialogBox();
		setSize(300, 480);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				okButtonPressed();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure want to cancel your purchase", "Cancelation Confirmation", JOptionPane.YES_NO_OPTION);
				if (result==0) {
					
					cancelButtonPressed();
				}
				
			}
		});
	}
	public void bringUpDialogBox() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints lc = new GridBagConstraints();
		getContentPane().setLayout(layout);
		
		okButton = new JButton("ACCEPT");
		lc.gridx = 2; lc.gridy = 6;
		lc.gridwidth = 1; lc.gridheight = 1;
		lc.weightx = 0.0; lc.weighty = 0.0;
		layout.setConstraints(okButton, lc);
		getContentPane().add(okButton);

		// Add the Cancel button
		
		cancelButton = new JButton("Cancel");

		lc.gridx = 3; lc.gridy = 6;
		lc.gridwidth = 1; lc.gridheight = 1;
		lc.weightx = 0.0; lc.weighty = 0.0;
		layout.setConstraints(cancelButton, lc);
		getContentPane().add(cancelButton);
		
		PurchasePanel purchasepan = new PurchasePanel("Customer Infromation");
		lc.gridx = 1; lc.gridy = 1;
		lc.gridwidth = 3; lc.gridheight = 1;
		layout.setConstraints(purchasepan,  lc);
		getContentPane().add(purchasepan);
	}
	
	private void okButtonPressed() {
		((DialogClientInterface)getOwner()).dialogFinished();
		dispose();
		System.out.println("Confirmation of Purchase: ");
		System.out.println("Name:" + purchasepan.getNameTextField().getText());
		System.out.println("Address: " + purchasepan.getAddressTextField().getText());		
		System.out.println("City: " + purchasepan.getCityTextField().getText());		
		System.out.println("Province: " + purchasepan.getProvinceTextField().getText());
		System.out.println("Postal Code: " + purchasepan.getPostalCodeTextField().getText());
		System.out.println("CreditCard Type: " + purchasepan.getCreditCardType());
		System.out.println("ExpiryDate: " + purchasepan.getExpiryDateTextField().getText());
		System.out.println("Credit Card Number: " + purchasepan.getCreditCardTextField().getText());
		
		
	}
	
	private void cancelButtonPressed() {
		
		((DialogClientInterface)getOwner()).dialogCancelled();
		dispose();
		
	}
}
