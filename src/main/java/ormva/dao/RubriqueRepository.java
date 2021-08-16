package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Rubrique;


@RepositoryRestResource
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

}