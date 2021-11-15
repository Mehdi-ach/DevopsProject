package tn.esprit.Devops.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.Devops.entities.Contrat;
import tn.esprit.Devops.repositories.ContratRepository;


@Service

public class ContratServiceImpl implements IContratService{
	@Autowired
    ContratRepository contratRepository;
	
	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}
	@Transactional
	@Override
	public void deleteContrat(int id) {
		contratRepository.delete(contratRepository.findById(id).orElse(new Contrat()));
		
	}

	@Override
	public void modifierContartById(Contrat c, int id) {
		Contrat contrat=contratRepository.findById(id).orElse(new Contrat());
		contrat.setDateDebut(c.getDateDebut());
		contrat.setSalaire(c.getSalaire());
		contrat.setTypeContrat(c.getTypeContrat());
		contratRepository.save(contrat);
		
	}

}
