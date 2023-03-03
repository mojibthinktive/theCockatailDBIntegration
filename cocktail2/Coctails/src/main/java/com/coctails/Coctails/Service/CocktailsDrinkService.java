package com.coctails.Coctails.Service;

import com.coctails.Coctails.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CocktailsDrinkService {
    private final DrinkDetailsService drinkDetailsService;

    @Autowired
    public  CocktailsDrinkService(DrinkDetailsService drinkDetailsService1){
        this.drinkDetailsService = drinkDetailsService1;
    }

    public List<ResponseEntity> getDrinksDetailsByIngredient(List<String> ingredients) {

        List<DrinkResponse> drinkResponseList=new ArrayList<>();
        List<CocktailEntity> cocktails = new ArrayList<>();
        List<CocktailEntity> drinkList = new ArrayList<>();

        getDrinkResponseList(ingredients, drinkResponseList);
        getDrinkList(drinkResponseList, drinkList);
        getCocktails(ingredients, cocktails, drinkList);

        List<ResponseEntity> responseEntities = new ArrayList<>();
        cocktails.forEach(cocktail -> createResponseEntity(ingredients, responseEntities, cocktail));
        return responseEntities;
    }

    private static void createResponseEntity(List<String> ingredients, List<ResponseEntity> responseEntities, CocktailEntity cocktail) {
        ResponseEntity responseEntity =new ResponseEntity();
        List<IngredientAndMeasureDTO> ingredientAndMeasureDTO = new ArrayList<>();
        List<String> missingIngredientList = new ArrayList<>();
        getMissingIngredients(ingredients, cocktail, missingIngredientList);
        getIngredients(ingredients, cocktail, ingredientAndMeasureDTO);
        createResponse(responseEntities, cocktail, responseEntity, ingredientAndMeasureDTO, missingIngredientList);
    }

    private static void createResponse(List<ResponseEntity> responseEntities, CocktailEntity cocktail, ResponseEntity responseEntity, List<IngredientAndMeasureDTO> ingredientAndMeasureDTO, List<String> missingIngredientList) {
        responseEntity.setIngredients(ingredientAndMeasureDTO);
        responseEntity.setMissingIngredients(missingIngredientList);
        responseEntity.setCocktail(cocktail.getStrDrink());
        responseEntity.setInstructions(cocktail.getStrInstructions());
        responseEntities.add(responseEntity);
    }

    private static void getIngredients(List<String> ingredients, CocktailEntity cocktail, List<IngredientAndMeasureDTO> ingredientAndMeasureDTO) {
        if(cocktail.getStrIngredient1()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient1(), cocktail.getStrMeasure1()));
        if(cocktail.getStrIngredient2()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient2(), cocktail.getStrMeasure2()));
        if(cocktail.getStrIngredient3()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient3(), cocktail.getStrMeasure3()));
        if(cocktail.getStrIngredient4()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient4(), cocktail.getStrMeasure4()));
        if(cocktail.getStrIngredient5()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient5(), cocktail.getStrMeasure5()));
        if(cocktail.getStrIngredient6()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient6(), cocktail.getStrMeasure6()));
        if(cocktail.getStrIngredient7()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient7(), cocktail.getStrMeasure7()));
        if(cocktail.getStrIngredient8()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient8(), cocktail.getStrMeasure8()));
        if(cocktail.getStrIngredient9()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient9(), cocktail.getStrMeasure9()));
        if(cocktail.getStrIngredient10()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient10(), cocktail.getStrMeasure10()));
        if(cocktail.getStrIngredient11()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient11(), cocktail.getStrMeasure11()));
        if(cocktail.getStrIngredient12()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient12(), cocktail.getStrMeasure12()));
        if(cocktail.getStrIngredient13()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient13(), cocktail.getStrMeasure13()));
        if(cocktail.getStrIngredient14()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient14(), cocktail.getStrMeasure14()));
        if(cocktail.getStrIngredient15()!=null) ingredientAndMeasureDTO.add(new IngredientAndMeasureDTO(cocktail.getStrIngredient15(), cocktail.getStrMeasure15()));
    }

    private static void getMissingIngredients(List<String> ingredients, CocktailEntity cocktail, List<String> missingIngredientList) {
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient1()))) missingIngredientList.add(cocktail.getStrIngredient1());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient2()))) missingIngredientList.add(cocktail.getStrIngredient2());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient3()))) missingIngredientList.add(cocktail.getStrIngredient3());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient4()))) missingIngredientList.add(cocktail.getStrIngredient4());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient5()))) missingIngredientList.add(cocktail.getStrIngredient5());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient6()))) missingIngredientList.add(cocktail.getStrIngredient6());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient7()))) missingIngredientList.add(cocktail.getStrIngredient7());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient8()))) missingIngredientList.add(cocktail.getStrIngredient8());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient9()))) missingIngredientList.add(cocktail.getStrIngredient9());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient10()))) missingIngredientList.add(cocktail.getStrIngredient10());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient11()))) missingIngredientList.add(cocktail.getStrIngredient11());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient12()))) missingIngredientList.add(cocktail.getStrIngredient12());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient13()))) missingIngredientList.add(cocktail.getStrIngredient13());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient14()))) missingIngredientList.add(cocktail.getStrIngredient14());
        if(ingredients.stream().noneMatch(ingredient-> ingredient.equals(cocktail.getStrIngredient15()))) missingIngredientList.add(cocktail.getStrIngredient15());
        missingIngredientList.removeIf(Objects::isNull);
    }

    private static void getCocktails(List<String> ingredients, List<CocktailEntity> cocktails, List<CocktailEntity> drinkList) {
        drinkList.forEach(drink -> {
            AtomicInteger ingredientExistsCount = new AtomicInteger();
            ingredients.forEach(ingredient-> {
                if((ingredient.equals(drink.getStrIngredient1())||ingredient.equals(drink.getStrIngredient2())||ingredient.equals(drink.getStrIngredient3())||ingredient.equals(drink.getStrIngredient4())||ingredient.equals(drink.getStrIngredient5())||ingredient.equals(drink.getStrIngredient6())||ingredient.equals(drink.getStrIngredient7())||ingredient.equals(drink.getStrIngredient8())||ingredient.equals(drink.getStrIngredient9())||ingredient.equals(drink.getStrIngredient10())||ingredient.equals(drink.getStrIngredient11())||ingredient.equals(drink.getStrIngredient12())||ingredient.equals(drink.getStrIngredient13())||ingredient.equals(drink.getStrIngredient14())||ingredient.equals(drink.getStrIngredient15()))) ingredientExistsCount.getAndIncrement();
            });
            if(ingredientExistsCount.get() == ingredients.size()) {
                cocktails.add(drink);
            }
        });
    }

    private void getDrinkList(List<DrinkResponse> drinkResponseList, List<CocktailEntity> drinkList) {
        drinkResponseList.forEach(drinkResponse -> {
            drinkList.addAll(drinkDetailsService.getCocktailsDetailsById(drinkResponse.getIdDrink()).getDrinks());
        });
    }

    private void getDrinkResponseList(List<String> ingredients, List<DrinkResponse> drinkResponseLists) {
        ingredients.forEach(ingredient ->{
            MainDrinkEntity drinkResponseList = drinkDetailsService.getDrinksDetailsByIngredient(ingredient);
            drinkResponseLists.addAll(drinkResponseList.getDrinks());
        });
    }

}
