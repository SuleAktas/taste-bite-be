package com.suleaktasyazan.TasteBiteBE.repository;

import com.suleaktasyazan.TasteBiteBE.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WriterRepository extends JpaRepository<Writer,Long> {
    Optional<Writer> findByName(String name);

}
