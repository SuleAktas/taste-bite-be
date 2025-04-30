package com.suleaktasyazan.TasteBiteBE.repository;

import com.suleaktasyazan.TasteBiteBE.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
}
