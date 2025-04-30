package com.suleaktasyazan.TasteBiteBE.service;

import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipe;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipePreview;
import com.suleaktasyazan.TasteBiteBE.dto.MealDto;
import com.suleaktasyazan.TasteBiteBE.entity.Recipe;

import java.util.List;

public interface IRecipeService {

    public List<DtoRecipePreview> getAllRecipe();

    public Recipe getRecipe(Long id);

    public DtoRecipePreview getPopularRecipe();

    public List<DtoRecipePreview> getRecipeByCategoryName(String name);

    public List<DtoRecipePreview> getRecipeByName(String name);


    public DtoRecipe createRecipe(DtoRecipe recipe);


    public void saveMeals(List<MealDto> mealDTOs);

    public Recipe updateRecipe(Long id,Recipe recipe);

}
