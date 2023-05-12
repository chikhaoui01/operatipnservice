package tn.esprit.operationservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RemiseCheque")
public class RemiseCheque extends Operation {

	@Column(name = "num_cheque")
	private long num_cheque;
	@Column(name = "cin")
	private String cin;
	@Column(name = "date_remise")
	private Date Date_remise;
	@Column(name = "montant")
	private long montant;

	public RemiseCheque( Date date_operation, Date date_valeur, String statut, String commentaire,
			tn.esprit.operationservice.model.Compte compte) {
		super( date_operation, date_valeur, statut, commentaire, compte);
		// TODO Auto-generated constructor stub
	}
	public RemiseCheque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getNum_cheque() {
		return num_cheque;
	}
	public void setNum_cheque(long num_cheque) {
		this.num_cheque = num_cheque;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDate_remise() {
		return Date_remise;
	}
	public void setDate_remise(Date date_remise) {
		Date_remise = date_remise;
	}
	public long getMontant() {
		return montant;
	}
	public void setMontant(long montant) {
		this.montant=montant; 
	}
}
