package com.coctails.Coctails.Service;

import com.coctails.Coctails.model.MainCocktailsDrinks;
import com.coctails.Coctails.model.MainDrinkEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Service
public class DrinkDetailsService {

    public MainDrinkEntity getDrinksDetailsByIngredient(String ingredient) {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + ingredient;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<MainDrinkEntity> result = restTemplate.exchange(url, HttpMethod.POST, entity, MainDrinkEntity.class);
        return result.getBody();
    }

    public MainCocktailsDrinks getCocktailsDetailsById(String idDrink) {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + idDrink;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<MainCocktailsDrinks> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, MainCocktailsDrinks.class);
        return responseEntity.getBody();
    }
}
