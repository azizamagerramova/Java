import java.awt.*;
import javax.swing.*;
public class SeatInformation extends JPanel{
	static JTextField section;
	static JTextField row;
	static JTextField number;
	static JTextField price;
	
	public SeatInformation(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
		setLayout(new GridLayout(4, 2));
		
		JLabel a = new JLabel("Section:");
		add(a);
		
		JTextField section = new JTextField();
		add(section);
		
		JLabel b = new JLabel("Row:");
		add(b);
		
		JTextField row = new JTextField();
		add(row);
		
		JLabel c = new JLabel("Number:");
		add(c);
		
		JTextField number = new JTextField();
		add(number);
		
		JLabel d = new JLabel("Price:");
		add(d);
		
		JTextField price = new JTextField();
		add(price);
	}
	
	private static void setSection(String text) { section.setText(text); }
	private static void setRow(String text) {row.setText(text); }
	private static void setNumber(String text) {number.setText(text); }
	private static void setPrice(int i) { price.setText(format(i)); }
	private static String format(int i) { return "$" + i + ".00"; }
	
	public static void setall(String section, String row, String number, int price) {
		setSection(section);
		setRow(row);
		setNumber(number);
		setPrice(price);
	}
	
	public static void setBlank() {
		setSection("");
		setRow("");
		setNumber("");
		price.setText("");
	}

}
