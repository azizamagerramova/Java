import java.awt.GridLayout;

import javax.swing.*;

public class SeatInfoPanel extends JPanel{
	
    private final JLabel section = new JLabel("Section: ");
    private final JLabel row = new JLabel("Row: ");
    private final JLabel number = new JLabel("Number: ");
    private final JLabel price = new JLabel("Price: ");

    private final JTextField sectionTextField = new JTextField();
    private final JTextField rowTextField = new JTextField();
    private final JTextField numberTextField = new JTextField();
    private final JTextField priceTextField = new JTextField();

    public JTextField getSectionField(){ return sectionTextField; }
    public JTextField getRowField(){ return rowTextField; }
    public JTextField getNumberField(){ return numberTextField;}
    public JTextField getPriceField(){ return priceTextField; }
    
    private void setSectionText(String text) {
        sectionTextField.setText(text);
    }
    private void setRowText(String text) {
        rowTextField.setText(text);
    }
    private void setNumberText(String text) {
        numberTextField.setText(text);
    }
    private void setPriceText(int i) {
        priceTextField.setText(moneyFormat(i));
    }
    
    private String moneyFormat(int i) {
        return "$" + i + ".00";
    }

    public SeatInfoPanel(String title){
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new GridLayout(4,2));
        add(section);
        sectionTextField.setHorizontalAlignment(JTextField.CENTER);
        add(sectionTextField);
        add(row);
        add(rowTextField);
        rowTextField.setHorizontalAlignment(JTextField.CENTER);
        add(number);
        add(numberTextField);
        numberTextField.setHorizontalAlignment(JTextField.CENTER);
        add(price);
        add(priceTextField);
        priceTextField.setHorizontalAlignment(JTextField.CENTER);
        setVisible(true);
    }
    
    public void setAll(String section, String row, String number, int price) {
        setSectionText(section);
        setRowText(row);
        setNumberText(number);
        setPriceText(price);
    }
    
    public void setAllBlank(){
        setSectionText("");
        setRowText("");
        setNumberText("");
        priceTextField.setText("");
    }
	
}
