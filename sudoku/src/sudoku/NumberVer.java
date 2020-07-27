package sudoku;

import javax.swing.JTextField;

public class NumberVer {
	
	public  NumberVer(int i, int j ,int number,JTextField[][] sudoko) {
		verifsudok verif = new verifsudok() ;
		System.out.println(i + " " +j+" "+ number);
		if(stringIsDigit(number))
		{
			System.out.println(stringIsDigit(Integer.toString(number).charAt(0)));
			if(verif.isValid(i, j, number, sudoko)) 
			{
				System.out.println("valid");
			}
			else 
			{
				System.out.println("not valid");
				sudoko[i][j].setText(" ");
			}
		}
		else
		{
			sudoko[i][j].setText(" ");
			System.out.println("enter a digit please !");
		}
		System.out.println("enter has preesed");
	}
	// check if string is a digit 
	public boolean stringIsDigit(int string) {
		return string>0 && string<10;
	}
	
	
}
