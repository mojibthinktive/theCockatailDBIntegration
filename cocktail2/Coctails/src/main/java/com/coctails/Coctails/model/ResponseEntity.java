package com.coctails.Coctails.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseEntity {
    private String cocktail;
    private List<String> missingIngredients;
    private String instructions;
    private List<IngredientAndMeasureDTO> ingredients;
}
