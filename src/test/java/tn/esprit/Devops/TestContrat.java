package tn.esprit.Devops;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.Devops.entities.Contrat;
import tn.esprit.Devops.repositories.ContratRepository;
import tn.esprit.Devops.services.ContratServiceImpl;
import tn.esprit.Devops.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestContrat {



	@DateTimeFormat(pattern = "dd.MM.yyyy") Date date;



	@Autowired
	IContratService es;
	@Autowired
	ContratServiceImpl ess;
	@Autowired
    ContratRepository entrepriseRepoistory;
	private static final Logger l = LogManager.getLogger(TestContrat.class);
	
@org.junit.Test
	public void ajouterContrat() {
	int id = es.ajouterContrat(new Contrat(date, "test",5f));
	l.info("************AJOUTER************");
	assertThat(id).isGreaterThan(0);
	l.info("************DELETE************");
	es.deleteContrat(id);
	}

@org.junit.Test
public void modifierContrat() {
int id = es.ajouterContrat(new Contrat(date, "test",5f));
l.info("************AJOUTER************");
ess.modifierContartById(new Contrat(date, "test",5f), id);
assertThat(id).isGreaterThan(0);
l.info("************UPDATE************");
es.deleteContrat(id);
l.info("************DELETE************");
}

@org.junit.Test
public void supprimerContrat(){
	int id = es.ajouterContrat(new Contrat(date, "test",5f));
	l.info("************AJOUTER************");
	es.deleteContrat(id);
	l.info("************DELETE************");
	assertEquals(null, entrepriseRepoistory.findById(id).orElse(null));
	
}
}
	
