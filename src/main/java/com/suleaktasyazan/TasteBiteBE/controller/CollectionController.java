package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCollection;
import com.suleaktasyazan.TasteBiteBE.entity.Collection;
import com.suleaktasyazan.TasteBiteBE.service.ICollectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection")
public class CollectionController  {

    @Autowired
    private ICollectionService collectionService;

    @GetMapping()
    public List<Collection> getAllCollection() {
        return collectionService.getAllCollection();
    }

    @GetMapping(path = "/{id}")
    public Collection getCollection(@PathVariable(name="id") Long id) {
        return collectionService.getCollection(id);
    }

    @PostMapping()
    public DtoCollection createCollection(@RequestBody @Valid DtoCollection collection) {
        return collectionService.createCollection(collection);
    }

    @PutMapping(path = "/{id}")
    public Collection updateCollection(@PathVariable(name="id") Long id, @RequestBody Collection collection) {
        return collectionService.updateCollection(id,collection);
    }
}
