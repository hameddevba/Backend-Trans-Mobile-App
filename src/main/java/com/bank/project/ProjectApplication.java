package com.bank.project;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.dao.EtatBCMFluxSortantsDao;
import com.bank.project.dao.EtatBCMReleveDesComptesCorrespondantsDao;
import com.bank.project.model.*;
import com.bank.project.model.enums.ResidentEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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
	EtatBCMReleveDesComptesCorrespondantsDao etatBCMReleveDesComptesCorrespondantsDao;
	@Override
	public void run(String... args) throws Exception {
		EtatBCMBalanceGenerale etatBCMBalanceGenerale = new EtatBCMBalanceGenerale();
		etatBCMBalanceGenerale.setCompte("compte1");
		etatBCMBalanceGenerale.setBanque("banque1");

		etatBCMBalanceGenerale.setDateClotureBalance(new Date());
		etatBCMBalanceGenerale.setIntituleCompte("intitule compteintitule compteintitule compte");
		etatBCMBalanceGenerale.setDevise("EUR");
		etatBCMBalanceGenerale.setResident(ResidentEnum.NA);
		etatBCMBalanceGenerale.setSoldeCrediteur(new BigDecimal("222.22"));
		etatBCMBalanceGenerale.setSoldeDebiteur(new BigDecimal("111.22"));
		etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale);
		EtatBCMBalanceGenerale etatBCMBalanceGenerale2 = new EtatBCMBalanceGenerale();
		etatBCMBalanceGenerale2.setCompte("compte2");
		etatBCMBalanceGenerale2.setBanque("banque2");
		etatBCMBalanceGenerale2.setDateClotureBalance(new Date());
		etatBCMBalanceGenerale2.setIntituleCompte("intitule compte");
		etatBCMBalanceGenerale2.setDevise("USD");
		etatBCMBalanceGenerale2.setResident(ResidentEnum.NR);
		etatBCMBalanceGenerale2.setSoldeCrediteur(new BigDecimal("222.22"));
		etatBCMBalanceGenerale2.setSoldeDebiteur(new BigDecimal("111.22"));
		etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale2);

	}
}
