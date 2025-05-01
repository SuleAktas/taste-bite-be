package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipe;
import com.suleaktasyazan.TasteBiteBE.dto.DtoRecipePreview;
import com.suleaktasyazan.TasteBiteBE.dto.DtoMeal;
import com.suleaktasyazan.TasteBiteBE.entity.Category;
import com.suleaktasyazan.TasteBiteBE.entity.Recipe;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;
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

    public void saveMeals(List<DtoMeal> mealDTOs) {

        List<Recipe> recipes = new ArrayList<>();
        Random rand = new Random();


        for (DtoMeal mealDTO : mealDTOs) {
            Recipe recipe = new Recipe();
            recipe.setName(mealDTO.getStrMeal());
            recipe.setRating( String.valueOf(rand.nextInt(8) + 1));
            recipe.setPhotoUrl(mealDTO.getStrMealThumb());
            recipe.setVideoUrl(mealDTO.getStrYoutube());
            recipe.setIngredients(mapIngredientsWithMeasures(mealDTO));
            recipe.setInstructions(mealDTO.getStrInstructions());
            recipe.setDescription(mealDTO.getStrCategory());
            recipe.setPrepTime( String.valueOf(rand.nextInt(60) + 1));
            recipe.setServings( rand.nextInt(6) + 1);
            recipe.setCreatedDate(new Date());

            Optional<Category> opt = categoryRepository.findByName(mealDTO.getStrCategory());
            if(opt.isPresent()){
                recipe.setCategory(opt.get());
            }
            else{
                Category category = new Category();
                category.setCreatedDate(new Date());
                category.setName(mealDTO.getStrCategory());
                category.setPhotoUrl("sadfasf");
                categoryRepository.save(category);
            }

            Optional<Writer> optWriter = writerRepository.findByName("Sule Aktas");
            if(optWriter.isPresent()){
                recipe.setWriter(optWriter.get());
            }
            else{
                Writer writer = new Writer();
                writer.setName("Sule Yazan");
                writer.setCreatedDate(new Date());
                writerRepository.save(writer);
                recipe.setWriter(writer);
            }


            recipes.add(recipe);
        }

        recipeRepository.saveAll(recipes);
    }
    private String mapIngredientsWithMeasures(DtoMeal mealDTO) {
        List<String> combinedList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            try {
                String ingredient = (String) DtoMeal.class.getMethod("getStrIngredient" + i).invoke(mealDTO);
                String measure = (String) DtoMeal.class.getMethod("getStrMeasure" + i).invoke(mealDTO);

                if (ingredient != null && !ingredient.trim().isEmpty()) {
                    StringBuilder item = new StringBuilder();

                    if (measure != null && !measure.trim().isEmpty()) {
                        item.append(measure.trim()).append(" ");
                    }

                    item.append(ingredient.trim());
                    combinedList.add(item.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return String.join(",", combinedList);

    }

}
