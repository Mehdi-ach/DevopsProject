package tn.esprit.Devops.services;

import tn.esprit.Devops.entities.Contrat;

public interface IContratService {
	
	public int ajouterContrat(Contrat contrat);
	public void deleteContrat(int id);
	public void modifierContartById(Contrat contrat,int id);

}
