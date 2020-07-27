package sudoku;

import javax.swing.JTextField;

public class verifsudok {
	// check if an add is vaild 
			public verifsudok () {
				
			}
			public boolean isValid(int row, int column, int number,JTextField[][] sudoko) {
				// check row
				int squereRow, squereCol;
				
				for(int i = 0; i < sudoko.length; i++) {
					if(number == (sudoko[i][column].getText()).charAt(0) && i!=row) 
						return false;	
				}
				
				// check column
				for(int j = 0; j < sudoko.length; j++) {
					if((number == (sudoko[row][j].getText()).charAt(0)) && j!=column) 
						return false;	
				}
				
				// CHECK TA 
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
						
						if((number == (sudoko[i][j].getText()).charAt(0)) && (j != column && i != row)) {
							return false;
						}
					}
				}
				return true;
			}
			
			
}
