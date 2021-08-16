package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Agriculteur;


@RepositoryRestResource
public interface AgriculteurRepository extends JpaRepository<Agriculteur, Long>{

}
