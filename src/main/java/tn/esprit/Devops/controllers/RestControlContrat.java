package tn.esprit.Devops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Devops.entities.Contrat;
import tn.esprit.Devops.services.ContratServiceImpl;



@RestController
public class RestControlContrat {

	@Autowired
	ContratServiceImpl cs;
	
	
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterMission(@RequestBody Contrat contrat) {
		cs.ajouterContrat(contrat);
		return contrat.getReference();
	}
	
	 @DeleteMapping("/deleteContrat/{id}") 
		@ResponseBody 
		public void deleteContratById(@PathVariable("reference")int id)
		{
			cs.deleteContrat(id);
		}
	 
}
