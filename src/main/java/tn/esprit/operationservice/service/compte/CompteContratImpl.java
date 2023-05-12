package tn.esprit.operationservice.service.compte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.operationservice.exceptions.InvalidAccountException;
import tn.esprit.operationservice.exceptions.InvalidAdminDeletionException;
import tn.esprit.operationservice.exceptions.InvalidConfirmationException;
import tn.esprit.operationservice.exceptions.InvalidPasswordException;
import tn.esprit.operationservice.model.Compte;
import tn.esprit.operationservice.repository.CompteRepository;

@Service
public class CompteContratImpl implements CompteContrat {
	private CompteRepository compteRepo;
	    @Autowired
	    public void setCompteRepo(CompteRepository compteRepo) {
	        this.compteRepo = compteRepo;
	    }

	@Transactional
	@Override
	public Compte findLeCompte(Long id) throws InvalidAccountException {

		Compte compte = compteRepo.findById(id).orElseThrow(() -> new InvalidAccountException("Compte indisponible"));

		if (!compte.isEtatCompte()) {
			throw new InvalidAccountException("Compte n'est plus disponible veuillez contacter votre agence");
		}

		return compte;
	}

	

	@Override
	public Compte updateAccount(Compte compte, Long aId) {
		compte.setNumeroCompte(aId);
		return compteRepo.save(compte);
	}

	@Override
	public List<Compte> allAccounts() {
		return compteRepo.findAll();

	}

	@Transactional
	@Override
	public Compte disactivateAccount(Long idCompte, String motDePasse)
			throws InvalidAccountException, InvalidPasswordException, InvalidConfirmationException,
			InvalidAdminDeletionException {

		Compte compte = findLeCompte(idCompte);

		System.out.println("****db**** Le mot de passe dans data base");
		System.out.println(compte.getMotDePasse());
		System.out.println("****received****");
		System.out.println("le mot de passe recu est :" + motDePasse);
		System.out.println("le mot de passe recu crypté:***");
			compte.setEtatCompte(false);
		return updateAccount(compte, compte.getNumeroCompte());
	}



}
