package ormva.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DossierEmplacementPk {
	
	@Column(name = "DOSSIER_ID")
	private Long dossier_id;
	
	@Column(name = "EMPLACEMENT_ID")
	private Long emplacement_id;
}
