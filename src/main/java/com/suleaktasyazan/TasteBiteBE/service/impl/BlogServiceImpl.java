package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoBlog;
import com.suleaktasyazan.TasteBiteBE.entity.Blog;
import com.suleaktasyazan.TasteBiteBE.repository.BlogRepository;
import com.suleaktasyazan.TasteBiteBE.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlog(Long id) {
        Optional<Blog> optional = blogRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public DtoBlog createBlog(DtoBlog dtoBlog) {
        DtoBlog response = new DtoBlog();
        Blog blog = new Blog();

        BeanUtils.copyProperties(dtoBlog,blog);
        blog.setCreatedDate(new Date());

        Blog dbBlog = blogRepository.save(blog);

        BeanUtils.copyProperties(dbBlog,response);
        return response;
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog dbBlog = getBlog(id);
        if(dbBlog !=null){
            dbBlog.setDescription(blog.getDescription());
            dbBlog.setText(blog.getText());
            dbBlog.setTitle(blog.getTitle());
            dbBlog.setVideoUrl(blog.getVideoUrl());
            dbBlog.setPhotoUrl(blog.getPhotoUrl());
            dbBlog.setPhotoUrl2(blog.getPhotoUrl2());
            dbBlog.setPhotoUrl3(blog.getPhotoUrl3());

            blogRepository.save(dbBlog);
        }
        return null;
    }
}
