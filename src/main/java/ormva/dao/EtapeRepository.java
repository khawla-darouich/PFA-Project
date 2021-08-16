package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Emplacement;
import ormva.entities.Etape;


@RepositoryRestResource
public interface EtapeRepository extends JpaRepository<Etape, Long> {

}
