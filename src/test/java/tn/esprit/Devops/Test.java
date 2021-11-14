package tn.esprit.Devops;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Devops.entities.Entreprise;
import tn.esprit.Devops.repositories.EntrepriseRepository;
import tn.esprit.Devops.services.EntrepriseServiceImpl;
import tn.esprit.Devops.services.IEntrepriseService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

	@Autowired
	IEntrepriseService es;
	@Autowired
	EntrepriseServiceImpl ess;
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	private static final Logger l = LogManager.getLogger(Test.class);
	
@org.junit.Test
	public void ajouterEntreprise() {
	int id = es.ajouterEntreprise(new Entreprise("esprit", "test"));
	l.info("*************AJOUTER*************");
	assertThat(id).isGreaterThan(0);
	l.info("*************DELETE*************");
	es.deleteEntrepriseById(id);
	}

@org.junit.Test
public void modifierEntreprise() {
int id = es.ajouterEntreprise(new Entreprise("esprit", "test"));
l.info("*************AJOUTER*************");
ess.modifierEntrpriseById(id,new Entreprise("cocacola", "test1"));
assertThat(id).isGreaterThan(0);
l.info("*************UPDATE*************");
es.deleteEntrepriseById(id);
l.info("*************DELETE*************");
}

@org.junit.Test
public void supprimerentreprise(){
	int id = es.ajouterEntreprise(new Entreprise("esprit", "test"));
	l.info("*************AJOUTER*************");
	es.deleteEntrepriseById(id);
	l.info("*************DELETE*************");
	assertEquals(null, entrepriseRepoistory.findById(id).orElse(null));
	
}
	

}
