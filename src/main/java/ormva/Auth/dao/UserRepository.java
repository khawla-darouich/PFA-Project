package ormva.Auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.Auth.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String email);
}
