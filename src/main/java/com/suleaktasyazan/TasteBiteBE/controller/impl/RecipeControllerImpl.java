package com.suleaktasyazan.TasteBiteBE.controller.impl;

import com.suleaktasyazan.TasteBiteBE.controller.IRecipeController;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipe;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipePreview;
import com.suleaktasyazan.TasteBiteBE.dto.MealDto;
import com.suleaktasyazan.TasteBiteBE.entity.Recipe;
import com.suleaktasyazan.TasteBiteBE.service.IRecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeControllerImpl implements IRecipeController {

    @Autowired
    private IRecipeService recipeService;

    @Override
    @GetMapping()
    public List<DtoRecipePreview> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @Override
    @GetMapping(path = "/{id}")
    public Recipe getRecipe(@PathVariable(name="id") Long id) {
        return recipeService.getRecipe(id);
    }

    @Override
    @GetMapping(path ="/popularRecipe")
    public DtoRecipePreview getPopularRecipe(){
        return recipeService.getPopularRecipe();
    }

    @Override
    @GetMapping(path="recipeByName/q={name}")
    public List<DtoRecipePreview> getRecipeByName(@PathVariable(name="name") String name){
        return recipeService.getRecipeByName(name);
    }

    @Override
    @GetMapping(path="/recipeByCategoryName/q={name}")
    public List<DtoRecipePreview> getRecipeByCategoryName(@PathVariable(name="name") String name){
        return recipeService.getRecipeByCategoryName(name);
    }


    @Override
    @PostMapping()
    public DtoRecipe createRecipe(@RequestBody @Valid DtoRecipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @Override
    @PutMapping(path = "/{id}")
    public Recipe updateRecipe(@PathVariable(name="id") Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id,recipe);
    }

    @Override
    @PostMapping(path = "/saveMealsFromApi")
    public void saveMealsFromApi(@RequestBody List<MealDto> meals){
        recipeService.saveMeals(meals);
    }
}
