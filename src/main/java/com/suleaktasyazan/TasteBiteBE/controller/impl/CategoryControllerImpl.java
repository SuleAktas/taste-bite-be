package com.suleaktasyazan.TasteBiteBE.controller.impl;

import com.suleaktasyazan.TasteBiteBE.controller.ICategoryController;
import com.suleaktasyazan.TasteBiteBE.dto.DtoCategory;
import com.suleaktasyazan.TasteBiteBE.entity.Category;
import com.suleaktasyazan.TasteBiteBE.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryControllerImpl implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Override
    @GetMapping()
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @Override
    @GetMapping(path="/{id}")
    public Category getCategory(@PathVariable(name="id") Long id) {
        return categoryService.getCategory(id);
    }

    @Override
    @PostMapping()
    public DtoCategory createCategory(@RequestBody @Valid DtoCategory category) {
        return categoryService.createCategory((category));

    }

    @Override
    @PutMapping(path="/{id}")
    public Category updateCategory(@PathVariable(name="id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id,category);

    }
}
