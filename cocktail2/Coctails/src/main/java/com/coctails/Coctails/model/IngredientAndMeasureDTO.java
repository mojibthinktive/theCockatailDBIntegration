package com.coctails.Coctails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientAndMeasureDTO {
    private String ingredient;
    private String measure;
}
