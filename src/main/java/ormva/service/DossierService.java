package ormva.service;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ormva.Auth.User;
import ormva.Auth.dao.RoleRepository;
import ormva.Auth.dao.UserRepository;
import ormva.dao.AgriculteurRepository;
import ormva.dao.AntenneRepository;
import ormva.dao.CdaRepository;
import ormva.dao.DossierRepository;
import ormva.dao.EmplacementRepository;
import ormva.dao.EtapeRepository;
import ormva.dao.HistoriqueRepository;
import ormva.dao.NoteRepository;
import ormva.dao.RubriqueRepository;
import ormva.dao.Sous_RubriqueRepository;
import ormva.entities.Dossier;
import ormva.entities.DossierEmplacementPk;
import ormva.entities.Emplacement;
import ormva.entities.Historique;
@Service
public class DossierService implements IService<Dossier> {

	@Autowired UserRepository userRepository;
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
	@Autowired HistoriqueRepository historiqueRepository;
	@Override
	public Dossier one(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dossier add(Dossier object, Principal currentUser) {
		User user =userRepository.findUserByEmail(currentUser.getName());
		object.setUsers(Arrays.asList(user));
		object.setEtapes(Arrays.asList(etapeRepository.findById(1L).get()));
		object.setEnvoyer(false);
		dossierRepository.save(object);
		
		Dossier dossier =dossierRepository.findDossierBySaba(object.getSaba());
		Historique historique =new Historique();
		historique.setEmplacement(emplacementRepository.findById(1L).get());
		historique.setId(new DossierEmplacementPk(dossier.getId(),1L));
		historique.setDossier(dossier);
		historique.setDate_reception(new Date());
		historiqueRepository.save(historique);
		return dossier;
	}

	@Override
	public Dossier update(Dossier object, Long id, Principal currentUser) {
		Dossier dossier=dossierRepository.findById(id).get();
		if(dossier.getEnvoyer()) throw new RuntimeException("Dossier déjà Envoyé");
		else {
			dossier.setCda(object.getCda());
			dossier.setAgriculteur(object.getAgriculteur());
			dossier.setReference(object.getReference());
			dossier.setSousRubrique(object.getSousRubrique());
			dossier.setSaba(object.getSaba());
		return	dossierRepository.save(dossier);
		}
		
	}
	@Override
	public void delete(Long id, Principal currentUser) {
		Dossier dossier=dossierRepository.findById(id).get();
		if(dossier.getEnvoyer()) throw new RuntimeException("Dossier déjà Envoyé");
		else  dossierRepository.delete(dossier);
	}

	@Override
	public Dossier envoyer(Long dossier_id, Principal currentUser,Long emplacement_id) {
		Dossier dossier=dossierRepository.findById(dossier_id).get();
		dossier.setEnvoyer(true);
		
		Historique historique=historiqueRepository.findById(new DossierEmplacementPk(dossier_id,emplacement_id)).get();
		historique.setDate_envoi(new Date());
		historiqueRepository.save(historique);
		return dossierRepository.save(dossier);
		 
	}



}
