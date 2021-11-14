package tn.esprit.Devops.services;


import tn.esprit.Devops.entities.Entreprise;



public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	
	
	public void deleteEntrepriseById(int entrepriseId);
	
	public Entreprise getEntrepriseById(int entrepriseId);
}
