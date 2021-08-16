package ormva.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Sous_Rubrique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String designation;
	@ManyToOne
	Rubrique rubrique;
	@OneToMany(mappedBy = "sousRubrique")
	Collection<Dossier> dossiers;
}