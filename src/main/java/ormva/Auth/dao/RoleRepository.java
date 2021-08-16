package ormva.Auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.Auth.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {

}
