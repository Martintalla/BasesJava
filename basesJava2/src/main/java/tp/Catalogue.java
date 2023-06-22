package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalogue {

	private List<Vente> listeVentes = new ArrayList<>();
	
	public void lireFichier(String monfichier) {
		try {
			FileInputStream fich = new FileInputStream(monfichier);
			BufferedReader br = new BufferedReader(new InputStreamReader(fich));
			br.readLine();//lecture de la premiere ligne du fichier 
			//.csv titres colonnes
			
			String ligne = br.readLine();
			while (ligne != null) {
				String[] t = ligne.split(";");
				Vente v = new Vente(t[0], Integer.parseInt(t[1]), Long.parseLong(t[2]));
				this.listeVentes.add(v);
				ligne = br.readLine();
				
			}
			br.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Sans Lambda expression
	
	public void  afficherV1() {
		//System.out.println(this.listeVentes.toString());
		ComparateurdeVente comp =new ComparateurdeVente();
		Collections.sort(this.listeVentes,comp);
		for(Vente v: this.listeVentes)
			System.out.println("\t"+v.toString());
	}
	
	//Avec lambda expression
	public void  afficherv2() {
		//System.out.println(this.listeVentes.toString());
		Collections.sort(listeVentes, (Vente o1, Vente o2)
				-> {return (int) ( o1.getCa()- o2.getCa());});
		System.out.println("Ventes par ordre de chiffre d'affaire");
		for(Vente v: this.listeVentes)
			System.out.println("\t"+v.toString());
		
		
		Collections.sort(listeVentes, (v1, v2)
				-> {if (v1== null || v1.getDomaine()== null)
					return -1; //null
				else
					return v1.getDomaine().compareTo(v2.getDomaine());});
		
		System.out.println("Ventes par ordre de domaine");
		for(Vente v: this.listeVentes)
			System.out.println("\t"+v.toString());
		
		
	}
	//Avec streams
	
	public void afficher() {
		System.out.println("vente: ");
		//this.listeVentes.stream()
		//                .forEach((v)-> {System.out.println("\t"+v.toString());});
		this.listeVentes.stream()
		                .sorted((o1,o2)-> (int) (o1.getCa()-o2.getCa()))
		                .forEach((v)-> {System.out.println("\t"+v.toString());});
		List<Vente> listeVentesTriesParCa = 
				        this.listeVentes.stream()
				        .sorted((o1,o2)-> (int) (o1.getCa()-o2.getCa()))
				        .collect(Collectors.toList());
		for(Vente vente: listeVentesTriesParCa)
			System.out.println("\t"+vente.toString());
	}
	
	
	public void EcrireFichier() {
		try {
			long ca_total = 0;
			for(Vente v : listeVentes)
				ca_total +=v.getCa();
			
			//Map<String, List<Vente>> mapVentesParDomaine = new HashMap<>();
			//for (Vente v:this.listeVentes)
			//	String domaine = v.getDomaine();
			//List<Vente> sousListe = mapVentesParDomaine.get(domaine);
			
			
			FileOutputStream of = new FileOutputStream("sats.csv.txt");
			PrintStream ps = new PrintStream(of);
			ps.println("Domaine; Ca_total");
			//ps.println("Valeur saisie : " + s );
			ps.println("all;"+ ca_total );
			// fermetures dans l'ordre inverse des ouvertures:
			ps.close(); of.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
