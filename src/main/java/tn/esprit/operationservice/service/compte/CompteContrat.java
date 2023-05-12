package tn.esprit.operationservice.service.compte;

import java.util.List;

import tn.esprit.operationservice.exceptions.InvalidAccountException;
import tn.esprit.operationservice.exceptions.InvalidAdminDeletionException;
import tn.esprit.operationservice.exceptions.InvalidConfirmationException;
import tn.esprit.operationservice.exceptions.InvalidHashPasswordException;
import tn.esprit.operationservice.exceptions.InvalidPasswordException;
import tn.esprit.operationservice.model.Compte;

public interface CompteContrat {


  

    Compte updateAccount(Compte compte, Long aId);

    List<Compte> allAccounts();

    Compte findLeCompte(Long id) throws InvalidAccountException;

    Compte disactivateAccount(Long idCompte,String motDePasse) throws InvalidAccountException, InvalidPasswordException, InvalidConfirmationException, InvalidAdminDeletionException, InvalidHashPasswordException;

}


