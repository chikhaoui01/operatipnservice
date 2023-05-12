package tn.esprit.operationservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Credit")
public class Credits implements Serializable  {
	    public enum TypeCredit {
	        IMMOBILIER,CONSOMMATION;
	    }

	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)

	    private Long idCredit;

	    @DecimalMin(value = "0.0",message = "Veuillez specifier un Montant superieure ou egale à zero")
	    private Double montantCredit;

	    @Temporal(TemporalType.DATE)
	    private Date dateCredit;

	    private Double mensualite;

	    @NotNull(message = "Veuillez preciser le type de credit")
	    @Enumerated(EnumType.STRING)
	    private TypeCredit typeCredit;

	    private Long nombreMensualitesCredit;

	    private Long montantReste;

	    private Long montantReglee;
	    private Boolean Approuver = false ; 
	    private Double interet; 

	    @ManyToOne
	    @JoinColumn(name = "numeroCompte")
	    @JsonIgnore
	    private Compte compteCredit;

	


		public Credits(Long idCredit,
				@DecimalMin(value = "0.0", message = "Veuillez specifier un Montant superieure ou egale à zero") Double montantCredit,
				Date dateCredit, Double mensualite,
				@NotNull(message = "Veuillez preciser le type de credit") TypeCredit typeCredit,
				Long nombreMensualitesCredit, Long montantReste, Long montantReglee, Boolean approuver,
				 Double interet, Compte compteCredit) {
			super();
			this.idCredit = idCredit;
			this.montantCredit = montantCredit;
			this.dateCredit = dateCredit;
			this.mensualite = mensualite;
			this.typeCredit = typeCredit;
			this.nombreMensualitesCredit = nombreMensualitesCredit;
			this.montantReste = montantReste;
			this.montantReglee = montantReglee;
			Approuver = approuver;
			this.interet = interet;
			this.compteCredit = compteCredit;
		}

		public Credits(){

	    }

	   

		public Double getInteret() {
			return interet;
		}

		public void setInteret(Double interet) {
			this.interet = interet;
		}

		public Boolean getApprouver() {
			return Approuver;
		}

		public void setApprouver(Boolean approuver) {
			Approuver = approuver;
		}

		public Long getIdCredit() {
	        return idCredit;
	    }

	    public void setIdCredit(Long idCredit) {
	        this.idCredit = idCredit;
	    }

	    public Double getMontantCredit() {
	        return montantCredit;
	    }

	    public void setMontantCredit(Double montantCredit) {
	        this.montantCredit = montantCredit;
	    }

	    public Date getDateCredit() {
	        return dateCredit;
	    }

	    public void setDateCredit(Date dateCredit) {
	        this.dateCredit = dateCredit;
	    }

	    public Double getMensualite() {
	        return mensualite;
	    }

	    public void setMensualite(Double mensualite) {
	        this.mensualite = mensualite;
	    }

	    public TypeCredit getTypeCredit() {
	        return typeCredit;
	    }

	    public void setTypeCredit(TypeCredit typeCredit) {
	        this.typeCredit = typeCredit;
	    }

	    public Long getNombreMensualitesCredit() {
	        return nombreMensualitesCredit;
	    }

	    public void setNombreMensualitesCredit(Long nombreMensualitesCredit) {
	        this.nombreMensualitesCredit = nombreMensualitesCredit;
	    }

	    public Long getMontantReste() {
	        return montantReste;
	    }

	    public void setMontantReste(Long montantReste) {
	        this.montantReste = montantReste;
	    }

	    public Long getMontantReglee() {
	        return montantReglee;
	    }

	    public void setMontantReglee(Long montantReglee) {
	        this.montantReglee = montantReglee;
	    }

	    public Compte getCompteCredit() {
	        return compteCredit;
	    }

	    public void setCompteCredit(Compte compteCredit) {
	        this.compteCredit = compteCredit;
	    }
}
