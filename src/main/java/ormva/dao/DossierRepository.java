package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Cda;
import ormva.entities.Dossier;

@RepositoryRestResource
public interface DossierRepository extends JpaRepository<Dossier, Long> {
	Dossier findDossierBySaba(String saba);
}
