package com.bank.project;

import com.bank.project.dao.EtatBCMBalanceGeneraleDao;
import com.bank.project.dao.EtatBCMFluxSortantsDao;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.model.EtatBCMFluxSortants;
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

	@Override
	public void run(String... args) throws Exception {
		EtatBCMBalanceGenerale etatBCMBalanceGenerale = new EtatBCMBalanceGenerale();
		etatBCMBalanceGenerale.setCompte("compte");
		etatBCMBalanceGenerale.setId(1L);
		etatBCMBalanceGenerale.setDateClotureBalance(new Date());
		etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale);

		EtatBCMFluxSortants etatBCMFluxSortants = new EtatBCMFluxSortants();
		etatBCMFluxSortants.setModeReglement("compte");
		etatBCMFluxSortants.setId(1L);
		etatBCMFluxSortants.setDateTransaction(new Date());
		etatBCMFluxSortantsDao.save(etatBCMFluxSortants);

	}
}
