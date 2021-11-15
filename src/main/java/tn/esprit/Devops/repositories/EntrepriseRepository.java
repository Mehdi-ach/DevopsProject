package tn.esprit.Devops.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.Devops.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	
	
}
