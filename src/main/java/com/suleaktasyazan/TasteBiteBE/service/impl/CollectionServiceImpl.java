package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoCollection;
import com.suleaktasyazan.TasteBiteBE.entity.Collection;
import com.suleaktasyazan.TasteBiteBE.repository.CollectionRepository;
import com.suleaktasyazan.TasteBiteBE.service.ICollectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImpl implements ICollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    @Override
    public List<Collection> getAllCollection() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection getCollection(Long id) {
        Optional<Collection> optional = collectionRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public DtoCollection createCollection(DtoCollection dtoCollection) {
        Collection collection = new Collection();
        BeanUtils.copyProperties(dtoCollection,collection);
        collection.setCreatedDate(new Date());
        collectionRepository.save(collection);
        return dtoCollection;
    }

    @Override
    public Collection updateCollection(Long id, Collection collection) {
        Collection dbCollection = getCollection(id);

        if(dbCollection != null){
            dbCollection.setName(collection.getName());
            dbCollection.setPhotoUrl(collection.getPhotoUrl());

            collectionRepository.save(dbCollection);
        }
        return null;
    }
}
