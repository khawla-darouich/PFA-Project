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

public class Cda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String description;
	@OneToMany(mappedBy = "cda")
	Collection<Dossier> dossiers;
	@ManyToOne
	Antenne antenne;


}
