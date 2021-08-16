package ormva.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ormva.Auth.Role;
import ormva.Auth.User;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Dossier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String saba;
	String reference;
	
	@OneToMany(mappedBy = "dossier")
	Collection<Note> notes;
	
	@ManyToOne
	Agriculteur agriculteur;
	
	@ManyToOne 
	Sous_Rubrique sousRubrique;
	
	@ManyToOne
	Cda cda;
	
	@OneToMany(mappedBy = "dossier")
	Collection<Historique> historiques;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="etat",
			joinColumns = @JoinColumn(
					name="dossier_id", referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
					name="etape_id", referencedColumnName = "id"
					)
			)
	private Collection<Etape> etapes;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="trace",
			joinColumns = @JoinColumn(
					name="dossier_id", referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
					name="user_id", referencedColumnName = "id"
					)
			)
	private Collection<User> users;
}
