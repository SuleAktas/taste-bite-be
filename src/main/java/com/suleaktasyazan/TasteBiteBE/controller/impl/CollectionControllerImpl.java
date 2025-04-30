package com.suleaktasyazan.TasteBiteBE.controller.impl;

import com.suleaktasyazan.TasteBiteBE.controller.ICollectionController;
import com.suleaktasyazan.TasteBiteBE.dto.DtoCollection;
import com.suleaktasyazan.TasteBiteBE.entity.Collection;
import com.suleaktasyazan.TasteBiteBE.service.ICollectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collection")
public class CollectionControllerImpl implements ICollectionController {

    @Autowired
    private ICollectionService collectionService;

    @Override
    @GetMapping()
    public List<Collection> getAllCollection() {
        return collectionService.getAllCollection();
    }

    @Override
    @GetMapping(path = "/{id}")
    public Collection getCollection(@PathVariable(name="id") Long id) {
        return collectionService.getCollection(id);
    }

    @Override
    @PostMapping()
    public DtoCollection createCollection(@RequestBody @Valid DtoCollection collection) {
        return collectionService.createCollection(collection);
    }

    @Override
    @PutMapping(path = "/{id}")
    public Collection updateCollection(@PathVariable(name="id") Long id, @RequestBody Collection collection) {
        return collectionService.updateCollection(id,collection);
    }
}
