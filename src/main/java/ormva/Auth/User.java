package ormva.Auth;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ormva.entities.Antenne;
import ormva.entities.Dossier;


@Entity
@Table(name="user ", uniqueConstraints=@UniqueConstraint(columnNames="email"))
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(unique = true)
	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password ;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
					name="email", referencedColumnName = "email"
					),
			inverseJoinColumns = @JoinColumn(
					name="role", referencedColumnName = "role"
					)
			)
	private Collection<Role> roles;
	
	@ManyToOne
	private Antenne antenne;
	
	@ManyToMany(mappedBy = "users")
	@JsonProperty(access = Access.WRITE_ONLY)
	Collection<Dossier> dossiers;
	

}
