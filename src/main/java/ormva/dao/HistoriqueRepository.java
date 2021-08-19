package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.DossierEmplacementPk;
import ormva.entities.Historique;


@RepositoryRestResource
public interface HistoriqueRepository extends JpaRepository<Historique, DossierEmplacementPk> {

}
