package com.bank.project.service;

import com.bank.project.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PublishService {
    @Value("${publish.etat.bcm.balance.generale.api}")
    public String etatBCMBalanceGeneraleApi;
    @Value("${publish.etat.bcm.balance.detaillee.api}")
    public String etatBCMBalanceDetailleeApi;
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

    public String getToken(RestTemplate restTemplate) {
        HttpEntity<UserDto> request =
                new HttpEntity<>(
                        new UserDto(banque,password));
        ResponseEntity<String> response = restTemplate.exchange(
                url+loginApi, HttpMethod.POST, request, String.class
        );
        if(response.getStatusCode().is2xxSuccessful()) return "Bearer " + response.getBody();
        throw new RuntimeException("authentification failed");
    }

    public boolean publishEtatGenerale(List<BalanceGeneralePublishDto> etatBCMBalanceGenerales){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceGeneralePublishDto>> request = new HttpEntity<>(etatBCMBalanceGenerales, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceGeneraleApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatBalanceDetaillee(List<BalanceDetailleePublishDto> etatBCMBalanceDetaillees){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<BalanceDetailleePublishDto>> request = new HttpEntity<>(etatBCMBalanceDetaillees, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMBalanceDetailleeApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishFluxSortant(List<FluxSortantsPublishDto> fluxSortantsPublishDto){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<FluxSortantsPublishDto>> request = new HttpEntity<>(fluxSortantsPublishDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMFluxSortantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishOuvertureCreditDocumentaire(List<OuvertureCreditDocumentairePublishDto> etatBCMOuvertureCreditDocumentaireDtos){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<OuvertureCreditDocumentairePublishDto>> request = new HttpEntity<>(etatBCMOuvertureCreditDocumentaireDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMOuvertureCreditDocumentaireApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishEtatBCMPrevisionEcheance(List<PrevisionEcheancePublishDto> etatBCMPrevisionEcheanceDtos){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<PrevisionEcheancePublishDto>> request = new HttpEntity<>(etatBCMPrevisionEcheanceDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMPrevisionEcheanceApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishEtatBCMFluxEntrants(List<EtatBCMFluxEntrantsPublishDto> etatBCMFluxEntrantsDtos){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<EtatBCMFluxEntrantsPublishDto>> request = new HttpEntity<>(etatBCMFluxEntrantsDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMFluxEntrantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean publishEtatBCMReleveDesComptesCorrespondants(List<ReleveDesComptesCorrespondantsPublishDto> etatBCMReleveDesComptesCorrespondantsDtos){
        RestTemplate restTemplate = new RestTemplate();
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<List<ReleveDesComptesCorrespondantsPublishDto>> request = new HttpEntity<>(etatBCMReleveDesComptesCorrespondantsDtos, headers);
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCMReleveDesComptesCorrespondantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();

    }

}
