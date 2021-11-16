package tn.esprit.Devops.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Devops.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Integer>{

}
