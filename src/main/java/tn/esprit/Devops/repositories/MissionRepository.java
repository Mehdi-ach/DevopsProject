package tn.esprit.Devops.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.Devops.entities.Mission;


public interface MissionRepository extends CrudRepository<Mission, Integer> {

}
