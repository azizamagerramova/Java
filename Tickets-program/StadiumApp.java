import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.*;

public class StadiumApp extends JFrame implements DialogClientInterface{
	static StadiumApp frame;
    static int panelWidth = 840 , panelHeight = 500;
    static SeatInfoPanel seatInfoPanel;
    static StadiumPanel stadiumPanel;
    static PricePanel pricePanel;
    AdminLoginDialog admindialog;
    SeatInfoDialog dialogseat;
    static double seatCost = 0;
    static float HST = 0;
    static float totalCost = 0;
    static JMenuItem game1;
	static JMenuItem game2;
	static JMenuItem game3;
	static JMenuItem game4;
	static JMenuItem allgames;
	static int keepgame;
	static double allsoldseats;
	static boolean all4games = false;
	static int buttonpressed;
	JButton purchase;

	public JButton getpurchase() {return purchase;}
    public StadiumApp(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(panelWidth, panelHeight);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints(); 
        getContentPane().setLayout(layout);

        stadiumPanel = new StadiumPanel(new Stadium());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 6;
        layout.setConstraints(stadiumPanel, constraints);

        seatInfoPanel = new SeatInfoPanel("SEAT INFORMATION");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(seatInfoPanel, constraints);

        pricePanel = new PricePanel("SELECTED SEAT PRICING");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(pricePanel, constraints);
        
       getContentPane().add(stadiumPanel);
       getContentPane().add(seatInfoPanel);
       getContentPane().add(pricePanel);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu games = new JMenu("Game");
        games.add(game1 = new JRadioButtonMenuItem("Game 1"));
        games.add(game2 = new JRadioButtonMenuItem("Game 2"));
        games.add(game3 = new JRadioButtonMenuItem("Game 3"));
        games.add(game4 = new JRadioButtonMenuItem("Game 4"));
        games.add(allgames = new JRadioButtonMenuItem("All 4 games"));
        
       menuBar.add(games);
       
       ButtonGroup gamegroup = new ButtonGroup();
       gamegroup.add(game1);
       gamegroup.add(game2);
       gamegroup.add(game3);
       gamegroup.add(game4);
       gamegroup.add(allgames);
       game1.addActionListener(
    		   new ActionListener()
    		   {
    			   
    			   public void actionPerformed(ActionEvent e){
    			       keepgame = 1;	  
    			       buttonpressed = 1;
    			       weirdmethod();       		
	            		
    		   }
    			  });
       
       game2.addActionListener(
    		   new ActionListener()
    		   {
    			   public void actionPerformed(ActionEvent e){
    			       keepgame = 2;	
    			       buttonpressed = 1;
    			       weirdmethod();  
    		   }
    		   });
      
       game3.addActionListener(
    		   new ActionListener()
    		   {
    			   public void actionPerformed(ActionEvent e){
    			       keepgame = 3;	
    			       buttonpressed = 1;
    			       weirdmethod();  
    		   }
    		   });
       
       game4.addActionListener(
    		   new ActionListener()
    		   {
    			   public void actionPerformed(ActionEvent e){
    			       keepgame = 0;
    			       buttonpressed = 1;
    			       weirdmethod();  
    		   }
    		   });
       
       allgames.addActionListener(
    		   new ActionListener()
    		   {
    			   public void actionPerformed(ActionEvent e){
    			       all4games = true;	
    			       buttonpressed = 1;
    			       weirdmethod();  
    		   }
    		   });
       
        purchase = new JButton("Purchase");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(purchase, constraints);
        getContentPane().add(purchase);
        purchase.setEnabled(false);
        purchase.addActionListener(
        		
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e)
        			{       	
        				
        				 for(int i=0; i<stadiumPanel.getSeatButtons().length; i++){
        			            for(int j=0; j<stadiumPanel.getSeatButtons()[i].length; j++){
        			            	if ((stadiumPanel.getSeatButton(i, j).getBackground() == Color.GRAY)) {
        			            		
        			            		if ((keepgame == 1) ||(keepgame == 2) ||(keepgame == 3) ||(keepgame == 0))  {
        			            		stadiumPanel.getSeat(i, j).sold[keepgame] = true;
        			            		   			            		
        			            	}
        			            		
        			            		if ( all4games == true){
        			            	 stadiumPanel.getSeat(i, j).sold[1] = true; stadiumPanel.getSeat(i, j).sold[2] = true; stadiumPanel.getSeat(i, j).sold[3] = true;
        			            	 stadiumPanel.getSeat(i, j).sold[0] = true;    
        			        
        			            	}        			            		        			            		
        			            		
        			            }
        				
        			}
        		}
        		PurchaseDialog dialog = new PurchaseDialog(frame, "Customer Information", true);
        		dialog.setVisible(true);
        		}
        			}
        		);
        
        JButton administrator = new JButton("Administrator");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(administrator, constraints);
        getContentPane().add(administrator);
        administrator.addActionListener(
        		new ActionListener(){
        		public void actionPerformed(ActionEvent e) {
        			admindialog = new AdminLoginDialog(frame, frame);
        			admindialog.setVisible(true);
        			if (admindialog.ura == 1) {
        	        	dialogseat = new SeatInfoDialog(stadiumPanel.getStadium());
        	        	dialogseat.setVisible(true);}
        			if (admindialog.ura == 2) {
        				
        			}
        		} }
        		);
        	
        
       
        for(int i=0; i<stadiumPanel.getSeatButtons().length; i++){
            for(int j=0; j<stadiumPanel.getSeatButtons()[i].length; j++){
                final int ii = i;
                final int jj = j;
                if (stadiumPanel.getSeatButton(i, j) instanceof JButton){
                    stadiumPanel.getSeatButton(i, j).addMouseListener(new MouseListener() {
                        @Override
                        public void mouseExited(MouseEvent e) {
                            if (e.getSource() instanceof JButton){
                                seatInfoPanel.setAllBlank();
                                handleMouseEvent();
                            }
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            if(stadiumPanel.getSeatButtons()[ii][jj] instanceof JButton){
                                seatInfoPanel.setAll(
                                    Byte.toString(stadiumPanel.getSeats()[ii][jj].getSection()),
                                    Character.toString(stadiumPanel.getSeats()[ii][jj].getRow()),
                                    Byte.toString(stadiumPanel.getSeats()[ii][jj].getNumber()),
                                    stadiumPanel.getSeats()[ii][jj].getPrice());
                                handleMouseEvent(); 
                            }
                        }
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            doButtonClick(ii, jj);
                            handleMouseEvent();
                            update();
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {}
                        @Override
                        public void mouseReleased(MouseEvent e) {}
                    });
                }
            }
        }
    }

        
    

    public static void main(String[] args){
    frame = new StadiumApp("Seat Purchasing System");   
    frame.setVisible(true);
    frame.setResizable(false);
    }

    private static void doButtonClick(int i, int j){
        changecolor(i, j);
        updatePurchase();
    }
    
    private static void changecolor(int i, int j) {
    	 if((stadiumPanel.getSeatButton(i, j) instanceof JButton) && (stadiumPanel.getSeat(i,  j).sold[keepgame] == false) && (buttonpressed == 1)){
             if(stadiumPanel.getSeatButton(i, j).getBackground() == Color.GRAY ){
                 switch(stadiumPanel.getSeat(i,j).getSection()){
                     case 1: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.RED);
                         break;
                     case 2: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.GREEN);
                         break;
                     case 3: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.BLUE);
                         break;
                     case 4: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.YELLOW);
                         break;
                     default: 
                         stadiumPanel.getSeatButton(i,j).setBackground(null);
                         break;
                 }
                 seatCost -= stadiumPanel.getSeat(i,j).getPrice();
                 HST = (float)(seatCost * 0.13);
                 totalCost = (float) (HST + seatCost);
             } else {
                 stadiumPanel.getSeat(i, j).setSelected(true);
                 stadiumPanel.getSeatButton(i, j).setBackground(Color.GRAY);
                 seatCost += stadiumPanel.getSeat(i,j).getPrice();
                 if (all4games == true) {seatCost = seatCost*4 - seatCost*0.10;}
                 HST = (float)(seatCost * 0.13);
                 totalCost = (float) (HST + seatCost);
             }
         }
    }
    
    private static void weirdmethod() {
    	 for(int i=0; i<stadiumPanel.getSeatButtons().length; i++){
	            for(int j=0; j<stadiumPanel.getSeatButtons()[i].length; j++){
		       if(stadiumPanel.getSeatButton(i, j).getBackground() == Color.GRAY ){
                 switch(stadiumPanel.getSeat(i,j).getSection()){
                     case 1: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.RED);
                         break;
                     case 2: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.GREEN);
                         break;
                     case 3: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.BLUE);
                         break;
                     case 4: 
                         stadiumPanel.getSeatButton(i,j).setBackground(Color.YELLOW);
                         break;
                     default: 
                         stadiumPanel.getSeatButton(i,j).setBackground(null);
                         break;
                         
                 }      			    }}}}
    
    private static void updatePurchase() {
    	frame.getpurchase().setEnabled(true);
    }
    private static void handleMouseEvent(){
       frame.getContentPane().revalidate();
       frame.getContentPane().repaint();
    }
    private static void update(){
        pricePanel.setSeatText(seatCost);
        pricePanel.setHstText(HST);
        pricePanel.setCostText(totalCost);
    }

   
    
	@Override
	public void dialogFinished() {
		
	}

	@Override
	public void dialogCancelled() {
		// TODO Auto-generated method stub
		
	}


}
