package tn.esprit.Devops;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
	int id = ds.ajouterdep(new Departement("Dembele"));
	l.info("ADD FOR ADD TEST");
	assertThat(id).isGreaterThan(0);
	ds.deletedep(id);
	l.info("DELETED");
	}
	
	@Test
	public void verifTaille() {
		List<Departement> departement = ds.getAlldep();
		assertTrue(!departement.isEmpty());
		int s = departement.size();
		l.info("LENGTH TEST = "+s);
	}
	
	@Test
	public void Update() {
	int id = ds.ajouterdep(new Departement("Havertz"));
	l.info("ADD FOR UPDATE TEST");
	Departement dep = ds.getDepById(id);
	dep.setName("Laya");
	String name = dep.getName();
	l.info("NAME UPDATED TO : "+name);
	assertEquals("Laya" ,dep.getName());
	l.info("TEST UPDATE");
	ds.deletedep(id);
	l.info("DELETE UPDATE");
	}

}
