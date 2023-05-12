package tn.esprit.operationservice.service.compte;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CompteCreation {
	
	@DecimalMin(value = "0.0",message = "Veuillez specifier un solde superieure ou egale à zero")
    private BigDecimal soldeCompte;

    @NotBlank(message = "Veuillez saisir un mot de passe")
    private String motDePasse;

    @NotBlank(message = "Veuillez resaisir le mot de passe correctement")
    private String reMotDePasse;

    @NotBlank(message = "Entrez un username valide et coherent")
    private String username;

    @NotBlank(message = "Entrez le type du compte ex: 'COURANT' 'EPARGNE' 'ADMIN' ")
    private String typecompte;

    public CompteCreation(@DecimalMin(value = "0.0", message = "Veuillez specifier un solde superieure ou egale à zero") BigDecimal soldeCompte, @NotBlank(message = "Veuillez saisir un mot de passe") String motDePasse, @NotBlank(message = "Veuillez resaisir le mot de passe correctement") String reMotDePasse, @NotBlank(message = "Entrez un email valide et coherent") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Entrez un email valide") String username, @NotBlank(message = "Entrez le type du compte ex: 'COURANT' 'EPARGNE'  ") String typecompte) {
        this.soldeCompte = soldeCompte;
        this.motDePasse = motDePasse;
        this.reMotDePasse = reMotDePasse;
        this.username = username;
        this.typecompte = typecompte;
    }

    public CompteCreation(){

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

    public String getReMotDePasse() {
        return reMotDePasse;
    }

    public void setReMotDePasse(String reMotDePasse) {
        this.reMotDePasse = reMotDePasse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

}
