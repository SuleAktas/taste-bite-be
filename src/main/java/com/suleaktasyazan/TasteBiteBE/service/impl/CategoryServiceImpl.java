package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCategory;
import com.suleaktasyazan.TasteBiteBE.entity.Category;
import com.suleaktasyazan.TasteBiteBE.repository.CategoryRepository;
import com.suleaktasyazan.TasteBiteBE.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public DtoCategory createCategory(DtoCategory dtoCategory) {
        Category category = new Category();
        BeanUtils.copyProperties(dtoCategory,category);
        category.setCreatedDate(new Date());
        categoryRepository.save(category);
        return dtoCategory;

    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category dbCategory = getCategory(id);
        if(dbCategory != null){
            dbCategory.setName(category.getName());
            dbCategory.setPhotoUrl(category.getPhotoUrl());

            categoryRepository.save(dbCategory);
        }
        return null;
    }
}
