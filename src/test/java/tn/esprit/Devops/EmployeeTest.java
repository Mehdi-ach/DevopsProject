package tn.esprit.Devops;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Devops.entities.Employe;
import tn.esprit.Devops.repositories.EmployeRepository;
import tn.esprit.Devops.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
	@Autowired
	IEmployeService es;
	@Autowired
	EmployeRepository er;

	private static final Logger l = LogManager.getLogger(EmployeeTest.class);
	private static final String NOM = "BenMansour"; 
	private static final String PRENOM = "Ahmed"; 
	private static final String EMAIL = "hmedM@esprit.tn"; 

	@Test
	public void verifTaille() {
		List<Employe> employes = es.getAllEmployes();
		assertTrue(!employes.isEmpty());
		String s = "Taille: " + employes.size();
		l.info(s);
	}

	@Test
	public void verifEmail() {
		Employe employe = es.getAllEmployes().get(0);
		assertEquals("mallek", employe.getNom());
		assertTrue(employe.getEmail().contains(".tn"));
		l.info("Employe: " + employe.getEmail());
	}

	@Test
	public void testAjout() {
		long i = es.getNombreEmployeJPQL();

		Employe emp = new Employe();
		emp.setNom(NOM);
		emp.setPrenom(PRENOM);
		emp.setEmail(EMAIL);
		emp = es.ajouterEmploye(emp);
		l.info("Nbr: " + es.getNombreEmployeJPQL());
		assertEquals(i + 1, es.getNombreEmployeJPQL());
		er.delete(emp);
	}
	
	@Test
	public void testModif() {
		Employe emp = new Employe();
		emp.setNom(NOM);
		emp.setPrenom(PRENOM);
		emp.setEmail(EMAIL);
		emp = es.ajouterEmploye(emp);
		emp.setPrenom("abbas");
		emp = er.save(emp);
		assertEquals("abbas" ,emp.getPrenom());
		er.delete(emp);
	}
	
	@Test
	public void testSuppr() {
		Employe emp = new Employe();
		emp.setNom(NOM);
		emp.setPrenom(PRENOM);
		emp.setEmail(EMAIL);
		emp = es.ajouterEmploye(emp);
		long i = es.getNombreEmployeJPQL();
		er.delete(emp);
		assertEquals(i - 1, es.getNombreEmployeJPQL());
		
	}
}
