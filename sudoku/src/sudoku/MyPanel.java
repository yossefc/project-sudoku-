package sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyPanel extends JPanel{
	static private  JTextField[][] sudoko;
	private int[][] sudo;  
	private JButton set , clear ;
	private boolean setPressed;
	JPanel grid = new JPanel(new GridLayout(9, 9));
	
	private void init(){
		setPressed = false;
		SortPlay je = new SortPlay();
		for (int i = 0; i < sudoko.length; i++) {
			for (int j = 0; j < sudoko[i].length; j++) 
			{
				if (je.getMtrix(i, j)==0)
					sudoko[i][j] = new JTextField(" ");
				else
					sudoko[i][j] = new JTextField(Integer.toString(je.getMtrix(i, j)));
			}
		}
	}
	public MyPanel() {
		// panels for the layouts 
		JPanel butons = new JPanel();
		SortPlay je = new SortPlay();
		
		// variable for the sudoko game
		sudoko = new JTextField[9][9];
		set = new JButton("set");
		clear = new JButton("clear");
		setPressed = false; 
		
		 // liserser for the game 
		MyKey keyLis = new MyKey();
		listener lis = new listener();
		set.addActionListener(lis);
		clear.addActionListener(lis);
		butons.	add(set);
		butons.add(clear);
		
	 // inilaised the game platform 
		for (int i = 0; i < sudoko.length; i++) {
			for (int j = 0; j < sudoko[i].length; j++) 
			{
				if (je.getMtrix(i, j)==0)
					sudoko[i][j] = new JTextField(" ");
				else
					sudoko[i][j] = new JTextField(Integer.toString(je.getMtrix(i, j)));
				sudoko[i][j].addKeyListener(keyLis);
				grid.add(sudoko[i][j]);
			}
		}
		
		// set layout 
		this.setLayout(new BorderLayout());
		add(grid,BorderLayout.CENTER);	
		add(butons,BorderLayout.SOUTH);
	}
	
	
	protected class MyKey extends KeyAdapter
	{
		public void keyPressed(KeyEvent ke)
		{
			int i,j = 0;
			
			for ( i= 0; i < sudoko.length; i++) 
			{
				for ( j = 0; j < sudoko[i].length; j++)
				{
					
					if(ke.getSource() == sudoko[i][j]) 
					{
						
						if(ke.getKeyChar() != '\n' ) 
						{
							 try {
								   int x = Character.getNumericValue(ke.getKeyChar()); 
								   new NumberVer(i, j,x, sudoko);
								 }catch(NumberFormatException e) {
								   System.out.println("Please Enter An Integer"); 
								   sudoko[i][j].setText(" ");
								 } 
							grid.add(sudoko[i][j]);
						}
						
					}
				}
			}
			
		}
		
	}
	// button lisener 
	private class listener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if(e.getSource() == set && !setPressed) 
			{
				for (int i = 0; i < sudoko.length; i++) 
				{
					for (int j = 0; j < sudoko[i].length; j++) 
					{
						if( (sudoko[i][j].getText().charAt(0) != '_')) 
						{
							System.out.println(sudoko[i][j].getText());
							sudoko[i][j].setEditable(false);
							setPressed = true; 
						} 
						
					}
				}
			}
			if(e.getSource() == clear) 
			{
				init();
			}
		}

		
		}
	
}