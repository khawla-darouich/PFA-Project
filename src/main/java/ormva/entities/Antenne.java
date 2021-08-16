package ormva.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
public class Antenne implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private String abreviation;
	
	@OneToMany(mappedBy = "antenne")
	Collection<User> users;
	
	@OneToMany(mappedBy = "antenne")
	Cda cdas;
}
