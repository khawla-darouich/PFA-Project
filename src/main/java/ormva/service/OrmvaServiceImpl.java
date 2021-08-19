package ormva.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import ormva.Auth.Role;
import ormva.Auth.dao.RoleRepository;
import ormva.Auth.dao.UserRepository;
import ormva.dao.AgriculteurRepository;
import ormva.dao.AntenneRepository;
import ormva.dao.CdaRepository;
import ormva.dao.DossierRepository;
import ormva.dao.EmplacementRepository;
import ormva.dao.EtapeRepository;
import ormva.dao.NoteRepository;
import ormva.dao.RubriqueRepository;
import ormva.dao.Sous_RubriqueRepository;
import ormva.entities.Agriculteur;
import ormva.entities.Antenne;
import ormva.entities.Cda;
import ormva.entities.Emplacement;
import ormva.entities.Etape;
import ormva.entities.Rubrique;
import ormva.entities.Sous_Rubrique;
@Service
@Transactional @AllArgsConstructor
public class OrmvaServiceImpl implements IOrmvaService{

	@Autowired AntenneRepository antenneRepository;
	@Autowired RoleRepository roleRepository;
	@Autowired AgriculteurRepository agriculteurRepository;
	@Autowired CdaRepository cdaRepository;
	@Autowired DossierRepository dossierRepository;
	@Autowired EmplacementRepository emplacementRepository;
	@Autowired NoteRepository noteRepository;
	@Autowired RubriqueRepository rubriqueRepository;
	@Autowired Sous_RubriqueRepository sousRubriqueRepository;
	@Autowired EtapeRepository etapeRepository;
	
	@Override
	public void initAntenne() {
		Stream.of("AAA","BBB","CCC").forEach(str->{
			Antenne antenne=new Antenne();
			antenne.setAbreviation(str);
			antenne.setDesignation(str);
			antenneRepository.save(antenne);
		});
		
	}

	@Override
	public void initRole() {
		Stream.of("Admin","GUC","ADA").forEach(str->{
			Role role=new Role();
			role.setRole(str);
			roleRepository.save(role);
		});
	}

	@Override
	public void initAgriculteur() {
		Stream.of("BW4422","AV6657","BX9902","MR7209").forEach(cin->{
			Agriculteur agriculteur= new Agriculteur();
			agriculteur.setNom("Nom");
			agriculteur.setPrenom("Prenom");
			agriculteur.setCin(cin);
			agriculteur.setTel("0600110092");
			agriculteur.setDate_notification(new Date());
			agriculteurRepository.save(agriculteur);
		});
		
	}

	@Override
	public void initCda() {
		
		antenneRepository.findAll().forEach(antenne->{
			Stream.of("C1","C2","C3").forEach(c->{
				Cda cda=new Cda();
				cda.setAntenne(antenne);
				cda.setDescription(c);
				cdaRepository.save(cda);
			});
		});
		
		
	}

	@Override
	public void initDossier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initEmplacement() {

			Emplacement emplacement= new Emplacement();
			emplacement.setDesignation("Antenne");
			emplacement.setPeriodeA(3L);
			emplacement.setPeriodeR(3L);
			emplacementRepository.save(emplacement);
			emplacement= new Emplacement();
			emplacement.setDesignation("Guichet unique central");
			emplacement.setPeriodeA(4L);
			emplacement.setPeriodeR(2L);
			emplacementRepository.save(emplacement);
			emplacement= new Emplacement();
			emplacement.setDesignation("Commission");
			emplacement.setPeriodeA(15L);
			emplacement.setPeriodeR(0L);
			emplacementRepository.save(emplacement);

		
	}

	@Override
	public void initEtape() {
		
		Etape etape=new Etape();
		etape.setDesignation("approbation");
		etape.setPeriode(22L);
		etapeRepository.save(etape);
		etape=new Etape();
		etape.setDesignation("realisation");
		etape.setPeriode(28L);
		etapeRepository.save(etape);
		
	}

	@Override
	public void initNote() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initRubrique() {
		Stream.of("arrosage","labourage").forEach(r->{
			Rubrique rubrique=new Rubrique();
			rubrique.setDesgnation(r);
			rubriqueRepository.save(rubrique);
		});
		
	}

	@Override
	public void initSousRubrique() {
		Rubrique rub1=rubriqueRepository.getById(1L);
		
		Stream.of("en surface","enterre","goutte a goutte").forEach(des->{
			Sous_Rubrique sous_rub=new Sous_Rubrique();
			sous_rub.setDesignation(des);
			sous_rub.setRubrique(rub1);
			sousRubriqueRepository.save(sous_rub);
		});
		Rubrique rub2=rubriqueRepository.getById(2L);
		Stream.of("en adossant","en refendant","a plat").forEach(des->{
			Sous_Rubrique sous_rub=new Sous_Rubrique();
			sous_rub.setDesignation(des);
			sous_rub.setRubrique(rub2);
			sousRubriqueRepository.save(sous_rub);
		});
		
		
	}

}

