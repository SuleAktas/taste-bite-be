package com.suleaktasyazan.TasteBiteBE.repository;

import com.suleaktasyazan.TasteBiteBE.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    Recipe findTopByOrderByRatingDesc();

    List<Recipe> findByCategoryId(Long categoryId);

    List<Recipe> findAllByNameStartingWithIgnoreCase(String name);

    @Query(value = "SELECT * FROM taste_bite.recipe ORDER BY RANDOM() LIMIT 30", nativeQuery = true)
    List<Recipe> findRandom30Recipes();

}
