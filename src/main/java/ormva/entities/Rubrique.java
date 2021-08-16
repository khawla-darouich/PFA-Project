package ormva.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ormva.Auth.User;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rubrique{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String desgnation;
	@OneToMany(mappedBy = "rubrique")
	private Collection<Sous_Rubrique> sousRubriques;

}