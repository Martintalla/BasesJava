package com.inetum.appliSpringWeb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.appliSpringWeb.doa.interfaces.IDaoCompte;
import com.inetum.appliSpringWeb.entity.Compte;

@RestController
@RequestMapping(value = "/api-bank/compte", headers = "Accept=application/json")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class CompteResCtrl {

	// NB: cette version 1 n'utilise pas encore les DTOs

	@Autowired
	private IDaoCompte daoCompteJpa;

	// exemple de fin d'URL: ./api-bank/compte/1
	@GetMapping("/{numeroCompte}")
	public ResponseEntity<?> getCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {

		Compte compte = daoCompteJpa.findById(numeroCompte);
		if (compte != null) {
			return new ResponseEntity<Compte>(compte, HttpStatus.OK);

		} else
			return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);// 404
	}

	// exemple de fin d'URL: ./api-bank/compte/1
	// à déclencher en mode DELETE
	@DeleteMapping("/{numeroCompte}")
	public ResponseEntity<?> deleteCompteByNumero(@PathVariable("numeroCompte") Long numeroCompte) {
		Compte compteAsupprimer = daoCompteJpa.findById(numeroCompte);
		if (compteAsupprimer == null)
			return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}", HttpStatus.NOT_FOUND); // NOT_FOUND =
																											// code http
																											// 404
		else
			daoCompteJpa.deleteById(numeroCompte);
		    return new ResponseEntity<String>("{ \"done\" : \"compte deleted\"}", HttpStatus.OK);
		// ou bien
		// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("")
	public List<Compte> getComptes(@RequestParam(value = "soldeMini", required = false) Double soldeMini) {
		if (soldeMini == null) {
			return daoCompteJpa.findAll();

		} else {
			return daoCompteJpa.findBySoldeMini(soldeMini);
		}

	}

	// exemple de fin d'URL: ./api-bank/compte
	// appelé en mode POST avec dans la partie invisible "body" de la requête:
	// { "numero" : null , "label" : "compte_6" , "solde" : 50.0 }
	// ou bien { "label" : "compteQuiVaBien" , "solde" : 50.0 }
	@PostMapping("")
	public Compte postCompte(@RequestBody Compte nouveauCompte) {
		Compte compteEnregistreEnBase = daoCompteJpa.insert(nouveauCompte);
		return compteEnregistreEnBase;// on retourne le compte avec la clze primaire auro-incremenrée
	}

	// exemple de fin d'URL: ./api-bank/compte
	// ou bien ./api-bank/compte/5
	// appelé en mode PUT avec dans la partie invisible "body" de la requête:
	// { "numero" : 5 , "label" : "compte_6" , "solde" : 150.0 }
	// ou bien { "label" : "compte5QueJaime" , "solde" : 150.0 }
	@PutMapping({ "", "/{numeroCompte}" })
	public ResponseEntity<?> postCompteToUpdate(@RequestBody Compte compte,
			@PathVariable("numeroCompte") Long numeroCompte) {
		Long numCompteToUpdate = (numeroCompte != null) ? numeroCompte : compte.getNumero();

		Compte compteQuiDevraitExister = numCompteToUpdate != null ? daoCompteJpa.findById(numCompteToUpdate) : null;

		if (compteQuiDevraitExister == null) {
			return new ResponseEntity<String>("{\"err\": \"ACCOUNT NOT FOUND\"}", HttpStatus.NOT_FOUND);// NOT_FOUND 404

		} else if(compte.getNumero()==null)
		    	compte.setNumero(numCompteToUpdate);
			daoCompteJpa.update(compte);
		return new ResponseEntity<Compte>(compte, HttpStatus.OK);

	}

}