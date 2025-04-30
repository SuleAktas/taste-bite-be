package com.suleaktasyazan.TasteBiteBE.service;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCategory;
import com.suleaktasyazan.TasteBiteBE.entity.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAllCategory();

    public Category getCategory(Long id);

    public DtoCategory createCategory(DtoCategory category);

    public Category updateCategory(Long id,Category category);
}
