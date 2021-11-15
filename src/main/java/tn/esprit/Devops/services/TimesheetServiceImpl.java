package tn.esprit.Devops.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Devops.entities.Departement;
import tn.esprit.Devops.entities.Employe;
import tn.esprit.Devops.entities.Mission;
import tn.esprit.Devops.entities.Role;
import tn.esprit.Devops.entities.Timesheet;
import tn.esprit.Devops.entities.TimesheetPK;
import tn.esprit.Devops.repositories.DepartementRepository;
import tn.esprit.Devops.repositories.EmployeRepository;
import tn.esprit.Devops.repositories.MissionRepository;
import tn.esprit.Devops.repositories.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger l = LogManager.getLogger(TimesheetServiceImpl.class);
	
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission mission = missionRepository.findById(missionId).orElse(new Mission());
		Departement dep = deptRepoistory.findById(depId).orElse(new Departement());
		mission.setDepartement(dep);
		missionRepository.save(mission);
		
	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		l.info("In valider Timesheet");
		Employe validateur = employeRepository.findById(validateurId).orElse(new Employe());
		Mission mission = missionRepository.findById(missionId).orElse(new Mission());
		//verifier s'il est un chef de departement (interet des enum)
		if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
			l.info("l'employe doit etre chef de departement pour valider une feuille de temps !");
			return;
		}
		//verifier s'il est le chef de departement de la mission en question
		boolean chefDeLaMission = false;
		for(Departement dep : validateur.getDepartements()){
			if(dep.getId() == mission.getDepartement().getId()){
				chefDeLaMission = true;
				break;
			}
		}
		if(!chefDeLaMission){
			l.info("l'employe doit etre chef de departement de la mission en question");
			return;
		}
//
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet = timesheetRepository.findBytimesheetPK(timesheetPK);
		timesheet.setValide(true);
		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String info = "dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut());
		l.info(info);
		
	}

	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
