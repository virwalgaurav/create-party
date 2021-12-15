package com.example.party.security.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressValitade {

    @Value("${java.app.url}")
    private String addressUrl;
    public String validateAddress(String city, Integer zip){
        RestTemplate restTemplate = new RestTemplate();
      return   restTemplate.getForObject(addressUrl+"/v1/validate?city="+city+"&zip="+zip,String.class);
    }
}
