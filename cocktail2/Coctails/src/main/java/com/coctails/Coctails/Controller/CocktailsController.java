package com.coctails.Coctails.Controller;

import com.coctails.Coctails.Service.CocktailsDrinkService;
import com.coctails.Coctails.model.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CocktailsController {
    private final CocktailsDrinkService cocktailsDrinkService;

    @Autowired
    public CocktailsController(CocktailsDrinkService cocktailsDrinkService) {
        this.cocktailsDrinkService  = cocktailsDrinkService;
    }


    @GetMapping("/cocktail")
    public List<ResponseEntity> getDrinksDetailsByIngredient(@RequestParam List<String> ingredients){
        return cocktailsDrinkService.getDrinksDetailsByIngredient(ingredients);
    }
}
