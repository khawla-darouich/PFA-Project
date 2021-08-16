package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Sous_Rubrique;


@RepositoryRestResource
public interface Sous_RubriqueRepository extends JpaRepository<Sous_Rubrique, Long> {

}