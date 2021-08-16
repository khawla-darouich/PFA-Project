package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Cda;

@RepositoryRestResource
public interface CdaRepository extends JpaRepository<Cda, Long> {

}
