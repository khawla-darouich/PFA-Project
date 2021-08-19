package ormva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable @AllArgsConstructor @ToString @NoArgsConstructor
public class DossierEmplacementPk implements Serializable {
	
	@Column(name = "DOSSIER_ID")
	private Long dossier_id;
	
	@Column(name = "EMPLACEMENT_ID")
	private Long emplacement_id;
}
