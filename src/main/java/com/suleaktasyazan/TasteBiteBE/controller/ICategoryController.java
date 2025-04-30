package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCategory;
import com.suleaktasyazan.TasteBiteBE.entity.Category;

import java.util.List;

public interface ICategoryController {

    public List<Category> getAllCategory();

    public Category getCategory(Long id);

    public DtoCategory createCategory(DtoCategory category);

    public Category updateCategory(Long id,Category category);

}
