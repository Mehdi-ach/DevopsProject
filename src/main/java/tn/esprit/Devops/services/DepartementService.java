package tn.esprit.Devops.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Devops.entities.Departement;
import tn.esprit.Devops.repositories.DepartementRepository;

@Service
public class DepartementService implements IDepartementService {
	
	@Autowired
	DepartementRepository dr;

	@Override
	public int ajouterdep(Departement Departement) {
		dr.save(Departement);
		return Departement.getId();
	}

	@Override
	public void deletedep(int idDep) {
		Departement department = dr.findById(idDep).get();
		dr.delete(department);
		
	}
	
	public Departement getDepById(int id) {
		return dr.findById(id).get();

	}

	@Override
	public List<Departement> getAlldep() {
		
		return (List<Departement>) dr.findAll();
	}

}
