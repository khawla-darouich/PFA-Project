package ormva.entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "historique")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Historique {

	@EmbeddedId
	private DossierEmplacementPk id;
	
	private Date date_reception;
	private Date date_envoi;
	
	@ManyToOne
	@MapsId("emplacement_id")
	@JoinColumn(name = "EMPLACEMENT_ID")
	private Emplacement emplacement;
	
	@ManyToOne
	@MapsId("dossier_id")
	@JoinColumn(name = "DOSSIER_ID")
	private Dossier dossier;
}
