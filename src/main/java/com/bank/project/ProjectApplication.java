package com.bank.project;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.dao.EtatBCMFluxSortantsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	EtatBCMBalanceGeneraleDao etatBCMBalanceGeneraleDao;

	@Autowired
	EtatBCMFluxSortantsDao etatBCMFluxSortantsDao;

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
//		EtatBCMFluxSortants etatBCMFluxSortants = new EtatBCMFluxSortants();
//		etatBCMFluxSortants.setModeReglement("compte");
//		etatBCMFluxSortants.setId(1L);
//		etatBCMFluxSortants.setDateTransaction(new Date());
//		etatBCMFluxSortantsDao.save(etatBCMFluxSortants);

	}
}
