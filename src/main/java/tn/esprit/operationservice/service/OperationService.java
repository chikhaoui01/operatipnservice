package tn.esprit.operationservice.service;

import java.math.BigDecimal;
import java.util.List;


import tn.esprit.operationservice.model.Operation;

public interface OperationService {
	public void verser(Long codeCpte, BigDecimal montant,String commentaire);
	public void retirer(Long codeCpte, BigDecimal montant,String commentaire);
	public void virement(Long cpt1, Long cpt2, BigDecimal montant, String Commentaire);
	public void remiseCheque(Long cpt1, Long cpt2, BigDecimal montant, String Commentaire,Long numCheque);
	//public List<Operation> listOperation();

}
