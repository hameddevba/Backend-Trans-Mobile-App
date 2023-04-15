package com.bank.project;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.dao.EtatBCMFluxSortantsDao;
import com.bank.project.dao.EtatBCM_OuvertureCreditDocumentaireDao;
import com.bank.project.model.EtatBCM_OuvertureCreditDocumentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	EtatBCMBalanceGeneraleDao etatBCMBalanceGeneraleDao;

	@Autowired
	EtatBCMFluxSortantsDao etatBCMFluxSortantsDao;

	@Autowired
	EtatBCM_OuvertureCreditDocumentaireDao etatBCM_OuvertureCreditDocumentaireDao;
	@Override
	public void run(String... args) throws Exception {
//		EtatBCMBalanceGenerale etatBCMBalanceGenerale = new EtatBCMBalanceGenerale();
//		etatBCMBalanceGenerale.setCompte("compte");
//		etatBCMBalanceGenerale.setId(1L);
//		etatBCMBalanceGenerale.setDateClotureBalance(new Date());
//		etatBCMBalanceGenerale.setIntituleCompte("intitule compte");
//		etatBCMBalanceGenerale.setDevise("EUR");
//		etatBCMBalanceGenerale.setResident(1);
//		etatBCMBalanceGenerale.setSoldeCrediteur(new BigDecimal("222.22"));
//		etatBCMBalanceGenerale.setSoldeDebiteur(new BigDecimal("111.22"));
//		etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale);
//		EtatBCMBalanceGenerale etatBCMBalanceGenerale2 = new EtatBCMBalanceGenerale();
//		etatBCMBalanceGenerale2.setCompte("compte");
//		etatBCMBalanceGenerale2.setId(2L);
//		etatBCMBalanceGenerale2.setDateClotureBalance(new Date());
//		etatBCMBalanceGenerale2.setIntituleCompte("intitule compte");
//		etatBCMBalanceGenerale2.setDevise("USD");
//		etatBCMBalanceGenerale2.setResident(1);
//		etatBCMBalanceGenerale2.setSoldeCrediteur(new BigDecimal("222.22"));
//		etatBCMBalanceGenerale2.setSoldeDebiteur(new BigDecimal("111.22"));
//		etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale2);
		EtatBCM_OuvertureCreditDocumentaire etatBCM_OuvertureCreditDocumentaire = new EtatBCM_OuvertureCreditDocumentaire();
		//etatBCM_OuvertureCreditDocumentaire.setModeReglement("compte");
		etatBCM_OuvertureCreditDocumentaire.setId(1L);
		etatBCM_OuvertureCreditDocumentaire.setDateOuverture(new Date());
		etatBCM_OuvertureCreditDocumentaireDao.save(etatBCM_OuvertureCreditDocumentaire);

	}
}
