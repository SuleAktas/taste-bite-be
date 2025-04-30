package com.suleaktasyazan.TasteBiteBE.service;

import com.suleaktasyazan.TasteBiteBE.dto.DtoBlog;
import com.suleaktasyazan.TasteBiteBE.entity.Blog;

import java.util.List;

public interface IBlogService {
    public List<Blog> getAllBlog();

    public Blog getBlog(Long id);

    public DtoBlog createBlog(DtoBlog blog);

    public Blog updateBlog(Long id,Blog blog);
}
