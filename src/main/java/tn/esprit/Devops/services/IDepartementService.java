package tn.esprit.Devops.services;

import java.util.List;

import tn.esprit.Devops.entities.Departement;

public interface IDepartementService {
	
	public int ajouterdep(Departement Departement);
	public void deletedep(int idDep);
	public List<Departement> getAlldep();

}
