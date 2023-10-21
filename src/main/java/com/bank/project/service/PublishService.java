package com.bank.project.service;

import ch.qos.logback.classic.Logger;
import com.bank.project.dto.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PublishService {
    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Value("${publish.etat.bcm.balance.generale.api}")
    public String etatBCMBalanceGeneraleApi;

    @Value("${publish.etat.bcm.balance.generale.mensuel.api}")
    public String etatBCMBalanceGeneraleMensuelApi;

    @Value("${publish.etat.bcm.balance.generale.annuel.api}")
    public String etatBCMBalanceGeneraleAnnuelApi;
    @Value("${publish.etat.bcm.balance.detaillee.api}")
    public String etatBCMBalanceDetailleeApi;

    @Value("${publish.etat.bcm.balance.detaillee.mensuel.api}")
    public String etatBCMBalanceDetailleeMensuelApi;

    @Value("${publish.etat.bcm.balance.detaillee.annuel.api}")
    public String etatBCMBalanceDetailleeAnnuelApi;
    @Value("${publish.etat.bcm.flux.sortants.api}")
    public String etatBCMFluxSortantsApi;

    @Value("${publish.etat.bcm.ouverture.credit.documentaire.api}")
    public String etatBCMOuvertureCreditDocumentaireApi;

    @Value("${publish.etat.bcm.prevision.echeance.api}")
    public String etatBCMPrevisionEcheanceApi;

    @Value("${publish.etat.bcm.flux.entrants.api}")
    public String etatBCMFluxEntrantsApi;

    @Value("${publish.etat.bcm.releve.comptes.correspondants.api}")
    public String etatBCMReleveDesComptesCorrespondantsApi;
    @Value("${publish.login.api}")
    public String loginApi;
    @Value("${publish.api.url}")
    String url;
    @Value("${publish.api.banque}")
    String banque;
    @Value("${publish.api.password}")
    String password;
    @Autowired
    RestTemplate restTemplate;

    public String getToken(RestTemplate restTemplate) {
        HttpEntity<UserDto> request = new HttpEntity<>(new UserDto(banque,password));
        ResponseEntity<String> response = restTemplate.exchange(
                url+loginApi, HttpMethod.POST, request, String.class
        );
        if(response.getStatusCode().is2xxSuccessful()) return "Bearer " + response.getBody();
        throw new RuntimeException("authentification failed");
    }

    public boolean publishEtatGenerale(List<BalanceGeneralePublishDto> etatBCMBalanceGenerales){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceGeneralePublishDto>> request = new HttpEntity<>(etatBCMBalanceGenerales, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceGeneraleApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatGeneraleMensuel(List<BalanceGeneralePublishDto> etatBCMBalanceGenerales){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceGeneralePublishDto>> request = new HttpEntity<>(etatBCMBalanceGenerales, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceGeneraleMensuelApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatGeneraleAnnuel(List<BalanceGeneralePublishDto> etatBCMBalanceGenerales){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceGeneralePublishDto>> request = new HttpEntity<>(etatBCMBalanceGenerales, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceGeneraleAnnuelApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatBalanceDetaillee(List<BalanceDetailleePublishDto> etatBCMBalanceDetaillees){

        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceDetailleePublishDto>> request = new HttpEntity<>(etatBCMBalanceDetaillees, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceDetailleeApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatBalanceDetailleeMensuel(List<BalanceDetailleePublishDto> etatBCMBalanceDetaillees){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);

        int partitionSize = 5000;
        List<List<BalanceDetailleePublishDto>> partitions = new ArrayList<>();

        for (int i=0; i<etatBCMBalanceDetaillees.size(); i += partitionSize) {
            partitions.add(etatBCMBalanceDetaillees.subList(i, Math.min(i + partitionSize, etatBCMBalanceDetaillees.size())));
        }

        boolean result=false;
        HttpEntity<List<BalanceDetailleePublishDto>> request=null;
        ResponseEntity<String> response=null;
        for (List<BalanceDetailleePublishDto> list : partitions) {
            //Do your stuff on each sub list
            try {
         request = new HttpEntity<>(list, headers);
         response = restTemplate.exchange(url + etatBCMBalanceDetailleeMensuelApi, HttpMethod.POST, request, String.class);
            result=response.getStatusCode().is2xxSuccessful();
            }catch (Exception e){
                e.toString();
            }
         if(!result){
           break;
       }
        }
        return result;
    }
    public boolean publishEtatBalanceDetailleeAnnuel(List<BalanceDetailleePublishDto> etatBCMBalanceDetaillees){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);

        int partitionSize = 5000;
        List<List<BalanceDetailleePublishDto>> partitions = new ArrayList<>();

        for (int i=0; i<etatBCMBalanceDetaillees.size(); i += partitionSize) {
            partitions.add(etatBCMBalanceDetaillees.subList(i, Math.min(i + partitionSize, etatBCMBalanceDetaillees.size())));
        }

        boolean result=false;

        HttpEntity<List<BalanceDetailleePublishDto>> request=null;
        ResponseEntity<String> response=null;
        for (List<BalanceDetailleePublishDto> list : partitions) {
           try {
               request = new HttpEntity<>(list, headers);
               response = restTemplate.exchange(url + etatBCMBalanceDetailleeAnnuelApi, HttpMethod.POST, request, String.class);
               result = response.getStatusCode().is2xxSuccessful();
           }catch (Exception e){
               e.toString();
           }
            if(!result){
                break;
            }
        }
        return result;
    }
    public boolean publishFluxSortant(List<FluxSortantsPublishDto> fluxSortantsPublishDto){

        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<FluxSortantsPublishDto>> request = new HttpEntity<>(fluxSortantsPublishDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMFluxSortantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishOuvertureCreditDocumentaire(List<OuvertureCreditDocumentairePublishDto> etatBCMOuvertureCreditDocumentaireDtos){

        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<OuvertureCreditDocumentairePublishDto>> request = new HttpEntity<>(etatBCMOuvertureCreditDocumentaireDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMOuvertureCreditDocumentaireApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatBCMPrevisionEcheance(List<PrevisionEcheancePublishDto> etatBCMPrevisionEcheanceDtos){

        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<PrevisionEcheancePublishDto>> request = new HttpEntity<>(etatBCMPrevisionEcheanceDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMPrevisionEcheanceApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishEtatBCMFluxEntrants(List<EtatBCMFluxEntrantsPublishDto> etatBCMFluxEntrantsDtos){

        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<EtatBCMFluxEntrantsPublishDto>> request = new HttpEntity<>(etatBCMFluxEntrantsDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMFluxEntrantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishEtatBCMReleveDesComptesCorrespondants(List<ReleveDesComptesCorrespondantsPublishDto> etatBCMReleveDesComptesCorrespondantsDtos){
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<ReleveDesComptesCorrespondantsPublishDto>> request = new HttpEntity<>(etatBCMReleveDesComptesCorrespondantsDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMReleveDesComptesCorrespondantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();

    }

}
