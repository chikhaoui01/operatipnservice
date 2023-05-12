package tn.esprit.operationservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Virement")
public class Virement extends Operation {

	@Column(name = "num_compte_recepteur")
	private long num_compte_recepteur;
	@Column(name = "montant")
	private long montant;
	@Column(name = "date_virement")
	private Date Date_virement;

	public Virement( Date date_operation, Date date_valeur, String statut, String commentaire,
			tn.esprit.operationservice.model.Compte compte) {
		super( date_operation, date_valeur, statut, commentaire, compte);
		// TODO Auto-generated constructor stub
	}
	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getNum_compte_recepteur() {
		return num_compte_recepteur;
	}
	public void setNum_compte_recepteur(long num_compte_recepteur) {
		this.num_compte_recepteur = num_compte_recepteur;
	}
	public long getMontant() {
		return montant;
	}
	public void setMontant(long montant) {
		this.montant = montant;
	}
	public Date getDate_virement() {
		return Date_virement;
	}
	public void setDate_virement(Date date_virement) {
		Date_virement = date_virement;
	}
}
