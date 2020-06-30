package mmn13_Q2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyPanel extends JPanel{
	private  JTextField[][] sudoko;
	  
	private JButton set , clear ;
	private boolean setPressed;
	
	private void init(){
		setPressed = false;
		for (int i = 0; i < sudoko.length; i++) {
			for (int j = 0; j < sudoko[i].length; j++) {
				sudoko[i][j].setEditable(true);
				sudoko[i][j].setText("_");
			}
		}
	}
	public MyPanel() {
		// panels for the layouts 
		JPanel grid = new JPanel(new GridLayout(9, 9));
		JPanel butons = new JPanel();
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
				
				sudoko[i][j] = new JTextField("_");
				sudoko[i][j].addKeyListener(keyLis);
				grid.add(sudoko[i][j]);
			}
		}
		
		// set layout 
		this.setLayout(new BorderLayout());
		add(grid,BorderLayout.CENTER);
		
		add(butons,BorderLayout.SOUTH);
		
		
	}
	
	// check if string and char are the same 
	private boolean isSame(String s1 , char a) {
		if(s1 != null && s1.length() == 1 ) {
			return s1.charAt(0) == a;
		}
		return false;
	} // check if string is a digit 
	private boolean stringIsDigit(String s1) {
		return isSame(s1,'1') || isSame(s1,'2') || isSame(s1,'3') || isSame(s1,'4')  
				|| isSame(s1,'5') || isSame(s1,'6') || isSame(s1,'7') || isSame(s1,'8')
				|| isSame(s1,'9');
	}
	
	// check if an add is vaild 
	private boolean isValid(int row, int column, char number) {
		// check row
		int squereRow, squereCol;
		for(int i = 0; i < sudoko.length; i++) {
			if(isSame(sudoko[row][i].getText(),number) && (i != column)) {
				return false;
			}
		}
		// check column
		for(int j = 0; j < sudoko.length; j++) {
			if(isSame(sudoko[j][column].getText(),number) && (j != row)) {
				return false;
			}
		}
		if(row >= 6) {
			squereRow = 6;
		}
		else if(row >= 3) {
			squereRow = 3;
		}
		else {
			squereRow = 0;
		}
		
		if(column >= 6) {
			squereCol = 6;
		}
		else if(column >= 3) {
			squereCol = 3;
		}
		else {
			squereCol = 0;
		}
		
		for(int i = squereRow; i < squereRow + 3; i++) {
			for(int j = squereCol; j < squereCol + 3; j++) {
				
				if(isSame(sudoko[i][j].getText(),number) && (j != column && i != row)) {
					return false;
				}
			}
		}
		return true;
	}//key lisener  
	private class MyKey extends KeyAdapter
	{
		
		public void keyPressed(KeyEvent ke)
		{
			for (int i = 0; i < sudoko.length; i++) 
			{
				for (int j = 0; j < sudoko[i].length; j++)
				{
					
					if(ke.getSource() == sudoko[i][j]) 
					{
						if(ke.getKeyChar() == '\n' ) 
						{
							if(stringIsDigit(sudoko[i][j].getText())) 
							{
								if(isValid(i, j, sudoko[i][j].getText().charAt(0))) 
								{
									System.out.println("valid");
								}
								else 
								{
									System.out.println("not valid");
									sudoko[i][j].setText("");
								}
							}
							else
							{
								sudoko[i][j].setText("");
								System.out.println("enter a digit please !");
							}
							
							System.out.println("enter has preesed");
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
