package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCollection;
import com.suleaktasyazan.TasteBiteBE.entity.Collection;

import java.util.List;

public interface ICollectionController {
    public List<Collection> getAllCollection();

    public Collection getCollection(Long id);

    public DtoCollection createCollection(DtoCollection collection);

    public Collection updateCollection(Long id,Collection collection);
}
