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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ormva.Auth.Role;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Emplacement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private Long periodeA;
	private Long periodeR;
	
	@OneToMany(mappedBy = "emplacement")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Historique> historiques;

}
