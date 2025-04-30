package com.suleaktasyazan.TasteBiteBE.controller.impl;

import com.suleaktasyazan.TasteBiteBE.controller.IBlogController;
import com.suleaktasyazan.TasteBiteBE.dto.DtoBlog;
import com.suleaktasyazan.TasteBiteBE.entity.Blog;
import com.suleaktasyazan.TasteBiteBE.service.IBlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogControllerImpl implements IBlogController {

    @Autowired
    private IBlogService blogService;

    @Override
    @GetMapping()
    public List<Blog> getAllBlog() {
        return blogService.getAllBlog();
    }

    @Override
    @GetMapping(path = "/{id}")
    public Blog getBlog(@PathVariable(name="id") Long id) {
        return blogService.getBlog(id);
    }



    @Override
    @PostMapping()
    public DtoBlog createBlog(@RequestBody @Valid DtoBlog blog) {
        return blogService.createBlog(blog);
    }

    @Override
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable(name="id") Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id,blog);
    }
}
