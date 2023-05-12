package tn.esprit.operationservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Operation")

public abstract class Operation {

	public enum statut {
	        VALIDER,WAITING,REJECTED;
	    }
	   @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id_operation;
	   @Column(name = "date_operation")
		private Date date_operation;
	   @Column(name = "date_valeur")
		private Date date_valeur;
	   @Column(name = "statut")
		private String statut;
	   @Column(name = "commentaire")
		private String commentaire;
	   
	   @ManyToOne
	    @JoinColumn(name = "numeroCompte")
	    private Compte Compte;
	   
	   
	   public Operation( Date date_operation, Date date_valeur, String statut, String commentaire,
				tn.esprit.operationservice.model.Compte compte) {
			super();
			this.date_operation = date_operation;
			this.date_valeur = date_valeur;
			this.statut = statut;
			this.commentaire = commentaire;
			Compte = compte;
		}
	   public Operation() {
			super();
			// TODO Auto-generated constructor stub
		}


	public Long getId_operation() {
		return id_operation;
	}


	public void setId_operation(Long id_operation) {
		this.id_operation = id_operation;
	}


	public Date getDate_operation() {
		return date_operation;
	}


	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}


	public Date getDate_valeur() {
		return date_valeur;
	}


	public void setDate_valeur(Date date_valeur) {
		this.date_valeur = date_valeur;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Compte getCompte() {
		return Compte;
	}


	public void setCompte(Compte compte) {
		Compte = compte;
	}
	   
}
