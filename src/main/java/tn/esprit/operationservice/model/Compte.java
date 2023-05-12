package tn.esprit.operationservice.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "Compte")
public class Compte {
	public enum TypeCompte {
        EPARGNE,COURANT;
    }
	public enum CategorieCompte {
        SILVER,GOLD,PLATINUM;
    }


    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

    private Long numeroCompte;

    @JsonProperty(access =JsonProperty.Access.READ_ONLY)
    private boolean etatCompte;

    @JsonProperty(access =JsonProperty.Access.READ_ONLY)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @DecimalMin(value = "0.0",message = "Veuillez specifier un solde superieure ou egale à zero")
    private BigDecimal soldeCompte;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Veuillez saisir un mot de passe")
    private String motDePasse;

    @NotNull(message = "Veuillez preciser le type du compte")
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    @Enumerated(EnumType.STRING)
    private CategorieCompte categorieCompte ;
    @ManyToOne
    @JoinColumn(name = "username")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "num_carte")
    private List<Carte> cartetList = new ArrayList<>();

    @OneToMany(mappedBy = "id_operation")
    private List<Operation> operationList = new ArrayList<>();

    @OneToMany(mappedBy = "compteCredit")
    private List<Credits> creditsList = new ArrayList<>();

    /**
     * Constructeur de l'entité Compte
     * @param numeroCompte
     * @param etatCompte
     * @param dateCreation
     * @param soldeCompte
     * @param typeCompte
     * @param motDePasse
     */

    public Compte(Long numeroCompte, boolean etatCompte, Date dateCreation, BigDecimal soldeCompte, TypeCompte typeCompte , String motDePasse) {
        this.numeroCompte = numeroCompte;
        this.etatCompte = etatCompte;
        this.dateCreation = dateCreation;
        this.soldeCompte = soldeCompte;
        this.typeCompte = typeCompte;
        this.motDePasse = motDePasse;
    }

    public Compte(){
    }

  

    public Long getNumeroCompte() {
		return numeroCompte;
	}

	

    public CategorieCompte getCategorieCompte() {
		return categorieCompte;
	}

	public void setCategorieCompte(CategorieCompte categorieCompte) {
		this.categorieCompte = categorieCompte;
	}
	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public boolean isEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(boolean etatCompte) {
		this.etatCompte = etatCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public BigDecimal getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(BigDecimal soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Carte> getCartetList() {
		return cartetList;
	}

	public void setCartetList(List<Carte> cartetList) {
		this.cartetList = cartetList;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	public List<Credits> getCreditsList() {
		return creditsList;
	}

	public void setCreditsList(List<Credits> creditsList) {
		this.creditsList = creditsList;
	}

	/**
     * @return Chaines de caracteres des infos sur Compte
     */

    @Override
    public String toString() {
        return "Compte{" +
                "numeroCompte=" + numeroCompte +
                ", etatCompte=" + etatCompte +
                ", dateCreation=" + dateCreation +
                ", soldeCompte=" + soldeCompte +
                ", motDePasse='" + motDePasse + '\'' +
                ", typeCompte=" + typeCompte +
                '}';
    }
}
