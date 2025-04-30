package com.suleaktasyazan.TasteBiteBE.controller;


import com.suleaktasyazan.TasteBiteBE.dto.DtoBlog;
import com.suleaktasyazan.TasteBiteBE.entity.Blog;

import java.util.List;

public interface IBlogController {
    public List<Blog> getAllBlog();

    public Blog getBlog(Long id);

    public DtoBlog createBlog(DtoBlog blog);

    public Blog updateBlog(Long id, Blog blog);
}
