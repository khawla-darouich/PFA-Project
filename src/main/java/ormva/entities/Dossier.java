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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ormva.Auth.Role;
import ormva.Auth.User;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Dossier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String saba;
	private String reference;
	private Boolean envoyer;
	
	@OneToMany(mappedBy = "dossier")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Note> notes;
	
	@ManyToOne
	private Agriculteur agriculteur;
	
	@ManyToOne 
	private Sous_Rubrique sousRubrique;
	
	@ManyToOne
	private Cda cda;
	
	@OneToMany(mappedBy = "dossier")
	private Collection<Historique> historiques;

	@ManyToMany
	@JoinTable(
			name="etat",
			joinColumns = @JoinColumn(
					name="dossier_id", referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
					name="etape_id", referencedColumnName = "id"
					)
			)
	//@JsonProperty(access = Access.WRITE_ONLY)
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
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<User> users;
}
