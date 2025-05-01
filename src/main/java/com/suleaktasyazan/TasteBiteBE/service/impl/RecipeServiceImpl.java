package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipe;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipePreview;
import com.suleaktasyazan.TasteBiteBE.entity.Category;
import com.suleaktasyazan.TasteBiteBE.entity.Recipe;
import com.suleaktasyazan.TasteBiteBE.repository.CategoryRepository;
import com.suleaktasyazan.TasteBiteBE.repository.RecipeRepository;
import com.suleaktasyazan.TasteBiteBE.repository.WriterRepository;
import com.suleaktasyazan.TasteBiteBE.service.IRecipeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceImpl implements IRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private WriterRepository writerRepository;

    @Override
    public List<DtoRecipePreview> getAllRecipe() {
        List<DtoRecipePreview> recipePreviewList = new ArrayList<>();
        List<Recipe> recipeList = recipeRepository.findRandom30Recipes();
        for(Recipe recipe : recipeList){
            DtoRecipePreview recipePreview = new DtoRecipePreview();
            BeanUtils.copyProperties(recipe,recipePreview);
            recipePreviewList.add(recipePreview);
        }

        return recipePreviewList;
    }

    @Override
    public Recipe getRecipe(Long id) {
        Optional<Recipe> optional = recipeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public DtoRecipePreview getPopularRecipe(){
        Recipe recipe = recipeRepository.findTopByOrderByRatingDesc();
        DtoRecipePreview dtoRecipePreview = new DtoRecipePreview();

            BeanUtils.copyProperties(recipe,dtoRecipePreview);
            return dtoRecipePreview;


    }
    public List<DtoRecipePreview> getRecipeByName(String name){
        List<DtoRecipePreview> dtoRecipePreviewList = new ArrayList<>();
        List<Recipe> recipeList = recipeRepository.findAllByNameStartingWithIgnoreCase(name);
        for(Recipe recipe : recipeList){
            DtoRecipePreview dtoRecipePreview = new DtoRecipePreview();
            BeanUtils.copyProperties(recipe,dtoRecipePreview);
            dtoRecipePreviewList.add(dtoRecipePreview);
        }

        return dtoRecipePreviewList;
    }

    public List<DtoRecipePreview> getRecipeByCategoryName(String name){

        List<DtoRecipePreview> dtoRecipePreviewList = new ArrayList<>();

        Optional<Category> category = categoryRepository.findByName(name);
        if(category.isPresent()){

            List<Recipe> recipeList = recipeRepository.findByCategoryId(category.get().getId());
            for(Recipe recipe : recipeList){
                DtoRecipePreview dtoRecipePreview = new DtoRecipePreview();
                BeanUtils.copyProperties(recipe,dtoRecipePreview);
                dtoRecipePreviewList.add(dtoRecipePreview);
            }
        }

        return dtoRecipePreviewList;
    }

    @Override
    public DtoRecipe createRecipe(DtoRecipe dtoRecipe) {
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(dtoRecipe,recipe);
        recipe.setCreatedDate(new Date());
        recipeRepository.save(recipe);
        return dtoRecipe;
    }


    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        Recipe dbRecipe = getRecipe(id);
        if(dbRecipe != null) {
            dbRecipe.setName(recipe.getName());
            dbRecipe.setDescription(recipe.getDescription());
            dbRecipe.setPhotoUrl(recipe.getPhotoUrl());
            dbRecipe.setIngredients(recipe.getIngredients());
            dbRecipe.setInstructions(recipe.getInstructions());
            dbRecipe.setPrepTime(recipe.getPrepTime());
            dbRecipe.setRating(recipe.getRating());
            dbRecipe.setServings(recipe.getServings());
            dbRecipe.setVideoUrl(recipe.getVideoUrl());

            recipeRepository.save(dbRecipe);
        }
        return null;
    }


}
