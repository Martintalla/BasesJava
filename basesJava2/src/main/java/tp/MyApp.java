package tp;

import java.util.Collections;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test_racineCarree();
		test_Catalogue();
		//test_Comparateur();
	}

	
	
public static void test_racineCarree() {
	Calcul c = new Calcul();
	String n = JOptionPane.showInputDialog(null, "entrer la valeur de x");
	double x = Double.parseDouble(n);
	String m = JOptionPane.showInputDialog(null, "entrer la valeur de y");
	int y = Integer.parseInt(m);
	try {
		System.out.println("La racine carrée de" +x +" est " +c.racineCarre(x));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String l = JOptionPane.showInputDialog(null, "entrer la valeur de z");
	int z = Integer.parseInt(l);
	//System.out.println("voila! "+c.racineCarre2(x));
	
	try {
		System.out.println("La division de " +y +" par " +z+ " est "+c.division(y,z));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void test_Catalogue() {
	Catalogue c = new Catalogue();
	c.lireFichier("ventes2022.csv");
	System.out.println("Ventes :");
	c.afficher();
	c.EcrireFichier();
}



}
