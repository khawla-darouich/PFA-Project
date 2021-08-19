package ormva.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ormva.Auth.User;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Rubrique{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String desgnation;
	@OneToMany(mappedBy = "rubrique")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Sous_Rubrique> sousRubriques;

}