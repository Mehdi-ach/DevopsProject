package tn.esprit.Devops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Devops.entities.Departement;
import tn.esprit.Devops.repositories.DepartementRepository;
import tn.esprit.Devops.services.DepartementService;

@RestController
public class DepartementController {
	
	@Autowired
	DepartementService ds;
	@Autowired
	DepartementRepository dr;
	
	@PostMapping("/ajouterDepartement")
	@ResponseBody
	public Departement ajouterdep(Departement Departement) {
		ds.ajouterdep(Departement);
		return Departement;
	}
	
	@DeleteMapping("/deleteDepartementById/{iddep}") 
	@ResponseBody 
	public void deleteDepById(@PathVariable int iddep) {
		ds.deletedep(iddep);
	}
	
	@GetMapping(value ="/getDepartementById/{id}")
	public Departement getDepById(@PathVariable int id) {
		return ds.getDepById(id);
	}
	
	@GetMapping(value = "/getAllDepartement")
    @ResponseBody
    public List<Departement> getAllDepartement(){
		return ds.getAlldep();
	}

}
