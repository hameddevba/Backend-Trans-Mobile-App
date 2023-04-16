package com.bank.project.service;

import com.bank.project.dto.EtatBCMBalanceGeneraleDto;
import com.bank.project.dto.EtatBCMFluxSortantsDto;
import com.bank.project.dto.UserDto;
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
    public String etatBCM_BalanceGeneraleApi;
    @Value("${publish.etat.bcm.flux.sortants.api}")
    public String etatBCM_FluxSortantsApi;
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
        if(response.getStatusCode().is2xxSuccessful()) return response.getBody();
        throw new RuntimeException("authentification failed");
    }

    public boolean publishEtatGenerale(List<EtatBCMBalanceGeneraleDto> etatBCMBalanceGenerales){
        RestTemplate restTemplate = new RestTemplate();
        //login
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization",token);
        HttpEntity<List<EtatBCMBalanceGeneraleDto>> request = new HttpEntity<>(etatBCMBalanceGenerales, headers);
        // appel de webservice
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCM_BalanceGeneraleApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
    public boolean publishFluxSortant(List<EtatBCMFluxSortantsDto> etatBCMFluxSortantsDtos){
        RestTemplate restTemplate = new RestTemplate();
        //login
        String token = getToken(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization",token);
        HttpEntity<List<EtatBCMFluxSortantsDto>> request = new HttpEntity<>(etatBCMFluxSortantsDtos, headers);
        // appel de webservice
        ResponseEntity<String> response = restTemplate.exchange(url + etatBCM_FluxSortantsApi, HttpMethod.POST, request, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
}
