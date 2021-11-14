package tn.esprit.Devops.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.Devops.entities.Entreprise;
import tn.esprit.Devops.repositories.EntrepriseRepository;




@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;

	
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	
	


	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	

	public Entreprise getEntrepriseById(int entrepriseId) {
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}
	
	public void modifierEntrpriseById (int id,Entreprise e)
	{
		Entreprise entreprise=entrepriseRepoistory.findById(id).get();
		entreprise.setName(e.getName());
		entreprise.setRaisonSocial(e.getRaisonSocial());
		entrepriseRepoistory.save(entreprise);
	}


}
