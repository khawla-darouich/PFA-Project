package ormva.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String objet;
	String note;
	Character reponse;
	
	@ManyToOne
	Dossier dossier;

}
