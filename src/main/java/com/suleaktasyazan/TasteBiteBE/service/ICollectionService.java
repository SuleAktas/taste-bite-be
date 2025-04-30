package com.suleaktasyazan.TasteBiteBE.service;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCollection;
import com.suleaktasyazan.TasteBiteBE.entity.Collection;

import java.util.List;

public interface ICollectionService {

    public List<Collection> getAllCollection();

    public Collection getCollection(Long id);

    public DtoCollection createCollection(DtoCollection collection);

    public Collection updateCollection(Long id,Collection collection);
}
