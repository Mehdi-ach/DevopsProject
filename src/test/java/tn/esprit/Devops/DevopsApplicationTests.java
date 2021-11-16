package tn.esprit.Devops;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.Devops.entities.Departement;
import tn.esprit.Devops.repositories.DepartementRepository;
import tn.esprit.Devops.services.DepartementService;

@SpringBootTest
class DevopsApplicationTests {
	
	@Autowired
	DepartementService ds;
	@Autowired
	DepartementRepository dr;
	
	private static final Logger l = LogManager.getLogger(DevopsApplicationTests.class);


	
	@Test
	public void ajouterDep() {
	int id = ds.ajouterdep(new Departement("salah"));
	System.out.println("**************AJOUTER**************");
	assertThat(id).isGreaterThan(0);
	ds.deletedep(id);
	System.out.println("**************DELETE AFTER ADD SUCCESS**************");
	}

}
