package com.bank.project;

import com.bank.project.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
  /*      EtatBCMFluxSortants etatBCMFluxSortants = new EtatBCMFluxSortants();
        etatBCMFluxSortants.setBanque("banque2");
        etatBCMFluxSortants.setDevise("USD");
        etatBCMFluxSortantsDao.save(etatBCMFluxSortants);
        EtatBCMBalanceGenerale etatBCMBalanceGenerale = new EtatBCMBalanceGenerale();
        etatBCMBalanceGenerale.setBanque("banque2");
        etatBCMBalanceGenerale.setDevise("USD");
        etatBCMBalanceGenerale.setDateClotureBalance(new Date());
        etatBCMBalanceGenerale.setCompte("compte");
        etatBCMBalanceGeneraleDao.save(etatBCMBalanceGenerale);
        Role role = new Role();
        role.setId(1);
        role.setName(
                RoleEnum.ROLE_ADMIN
        );
        roleDao.save(role);*/
    }
}
