package tn.esprit.Devops;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Devops.entities.Departement;
import tn.esprit.Devops.repositories.DepartementRepository;
import tn.esprit.Devops.services.DepartementService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	
	@Autowired
	DepartementService ds;
	@Autowired
	DepartementRepository dr;
	
	private static final Logger l = LogManager.getLogger(DepartementTest.class);
	
	@Test
	public void ajouterDep() {
	int id = ds.ajouterdep(new Departement("mohamed"));
	System.out.println("**************AJOUTER**************");
	assertThat(id).isGreaterThan(0);
	//ds.deletedep(id);
	System.out.println("**************DELETE AFTER ADD SUCCESS**************");
	}
	

}
