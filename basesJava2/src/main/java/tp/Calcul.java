package tp;

import javax.swing.JOptionPane;

public class Calcul {
	public double racineCarre(double x) throws MyException {
		if (x > 0) 
			return Math.sqrt(x);
		else 
			//throw new RuntimeException("racine carrée prévue seulement pour x positif");
		   // throw new IllegalArgumentException("racine carrée prévue seulement pour x positif");
			throw new MyException("racine carrée prévue seulement pour x positif");
			
		}
	public int division(int y, int z) {
		if (z==0) {
			throw new ArithmeticException("On ne peut diviser par zéro");	
		}
		else
			return y/z;
	}
	
}
