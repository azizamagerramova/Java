import java.util.Arrays;

public class Seat {
    public static int[]	PRICING = {74, 47, 32, 19};

    private final byte section;
    private final char row;
    private final byte number;
    private boolean selected;
    public Boolean[] sold;
    
    public Seat(byte s, char r, byte n) {
        section = s;
        row = r;
        number = n;
        sold = new Boolean[4];
        Arrays.fill(sold,  Boolean.FALSE);
        
    }
   
    public byte getSection() { return section; }
    public char getRow() { return row; }
    public byte getNumber() { return number; }
    public int getPrice() { return PRICING[section-1]; }
    public boolean isSold(int i) { return sold[i]; }
    
    public boolean isSelected() { return selected; }
    public void setSelected(boolean abool){ selected = abool; }
    
}