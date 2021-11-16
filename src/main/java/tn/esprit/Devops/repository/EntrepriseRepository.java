package tn.esprit.Devops.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.Devops.entities.Employe;
import tn.esprit.Devops.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	
	
}
