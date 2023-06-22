package tp;

import java.util.Comparator;

public class ComparateurdeVente implements Comparator<Vente> {

	@Override
	public int compare(Vente o1, Vente o2) {
		// TODO Auto-generated method stub
		if (o1== null || o1.getDomaine()== null)
			return -1; //null
		else
			return o1.getDomaine().compareTo(o2.getDomaine());
		//return (int) ( o1.getCa()- o2.getCa());
	}

	
}
