package tn.esprit.operationservice.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Retrait")
public class Retrait extends Operation {

	@Column(name = "montant")
	private long montant;
	@Column(name = "date_retrait")
	private Date Date_retrait;

	public Retrait( Date date_operation, Date date_valeur, String statut, String commentaire,
			tn.esprit.operationservice.model.Compte compte) {
		super( date_operation, date_valeur, statut, commentaire, compte);
		// TODO Auto-generated constructor stub
	}
	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getMontant() {
		return montant;
	}
	public void setMontant(long montant) {
		this.montant = montant;
	}
	public Date getDate_retrait() {
		return Date_retrait;
	}
	public void setDate_retrait(Date date_retrait) {
		Date_retrait = date_retrait;
	}
}
