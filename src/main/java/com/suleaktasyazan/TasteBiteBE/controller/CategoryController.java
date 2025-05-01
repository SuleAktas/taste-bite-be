package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCategory;
import com.suleaktasyazan.TasteBiteBE.entity.Category;
import com.suleaktasyazan.TasteBiteBE.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping()
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }


    @GetMapping(path="/{id}")
    public Category getCategory(@PathVariable(name="id") Long id) {
        return categoryService.getCategory(id);
    }


    @PostMapping()
    public DtoCategory createCategory(@RequestBody @Valid DtoCategory category) {
        return categoryService.createCategory((category));

    }

    @PutMapping(path="/{id}")
    public Category updateCategory(@PathVariable(name="id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id,category);

    }
}
