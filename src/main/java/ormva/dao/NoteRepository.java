package ormva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ormva.entities.Note;


@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Long> {

}