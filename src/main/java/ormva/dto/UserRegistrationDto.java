package ormva.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserRegistrationDto {

	private String prenom;
	private String nom;
	private String email;
	private Long antenne;
	private String password;
	private Long role;
	

}
