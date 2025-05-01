package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipe;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipePreview;
import com.suleaktasyazan.TasteBiteBE.dto.DtoMeal;
import com.suleaktasyazan.TasteBiteBE.entity.Recipe;
import com.suleaktasyazan.TasteBiteBE.service.IRecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController{

    @Autowired
    private IRecipeService recipeService;


    @GetMapping()
    public List<DtoRecipePreview> getAllRecipe() {
        return recipeService.getAllRecipe();
    }


    @GetMapping(path = "/{id}")
    public Recipe getRecipe(@PathVariable(name="id") Long id) {
        return recipeService.getRecipe(id);
    }


    @GetMapping(path ="/popularRecipe")
    public DtoRecipePreview getPopularRecipe(){
        return recipeService.getPopularRecipe();
    }


    @GetMapping(path="recipeByName/q={name}")
    public List<DtoRecipePreview> getRecipeByName(@PathVariable(name="name") String name){
        return recipeService.getRecipeByName(name);
    }


    @GetMapping(path="/recipeByCategoryName/q={name}")
    public List<DtoRecipePreview> getRecipeByCategoryName(@PathVariable(name="name") String name){
        return recipeService.getRecipeByCategoryName(name);
    }



    @PostMapping()
    public DtoRecipe createRecipe(@RequestBody @Valid DtoRecipe recipe) {
        return recipeService.createRecipe(recipe);
    }


    @PutMapping(path = "/{id}")
    public Recipe updateRecipe(@PathVariable(name="id") Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id,recipe);
    }


    @PostMapping(path = "/saveMealsFromApi")
    public void saveMealsFromApi(@RequestBody List<DtoMeal> meals){
        recipeService.saveMeals(meals);
    }
}
