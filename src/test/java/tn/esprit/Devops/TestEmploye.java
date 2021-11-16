package tn.esprit.Devops;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Devops.entities.Employe;
import tn.esprit.Devops.services.EmployeServiceImpl;
import tn.esprit.Devops.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmploye {

	@Autowired
	EmployeServiceImpl ess;

	private static final Logger l = LogManager.getLogger(TestEmploye.class);

	@org.junit.Test
	public void ajouterEmploye() {
		int id = ess.ajouterEmploye(new Employe("mohannad", "kahdhroaui", "esmail@live.fr", true));
		l.info("*************AJOUTER*************");
		assertThat(id).isGreaterThan(0);
		l.info("*************DELETE*************");
		ess.deleteEmployeById(id);
	}
	
	@org.junit.Test
	public void getEmploye() {
		int id = ess.ajouterEmploye(new Employe("mohannad", "kahdhroaui", "esmail@live.fr", true));
		l.info("*************AJOUTER*************");
		String s = ess.getEmployePrenomById(id);
		l.info("*************get name*************");
		assertThat(s).isEqualTo("kahdhroaui");
		l.info("*************DELETE*************");
		ess.deleteEmployeById(id);
	}
	
	@org.junit.Test
	public void updateEmploye() {
		int id = ess.ajouterEmploye(new Employe("mohannad", "kahdhroaui", "esmail@live.fr", true));
		l.info("*************AJOUTER*************");
		String s = ess.mettreAjourEmailByEmployeId("mohaned@live.fr",id);
		l.info("*************get email*************");
		assertThat(s).isEqualTo("mohaned@live.fr");
		l.info("*************DELETE*************");
		ess.deleteEmployeById(id);
	}

}
