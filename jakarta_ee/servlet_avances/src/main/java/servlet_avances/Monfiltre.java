package servlet_avances;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/maserv")
public class Monfiltre implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("je suis dans le filtre mon filtre");
		if (true) {
			//TOUT EST OK POUR LAISSER PASSER LA REQUETE
			chain.doFilter(request, response);
			}
		else {
			//ICI ON REDIRIGE LE USER VERS LES AUTRES RESSOURCES
			System.out.println("vous sn'est pas habileté pour cette ressource");
		}

	}

}
