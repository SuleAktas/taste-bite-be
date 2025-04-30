package com.suleaktasyazan.TasteBiteBE.service.impl;

import com.suleaktasyazan.TasteBiteBE.dto.DtoWriter;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;
import com.suleaktasyazan.TasteBiteBE.repository.WriterRepository;
import com.suleaktasyazan.TasteBiteBE.service.IWriterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WriterServiceImpl implements IWriterService {
    @Autowired
    private WriterRepository writerRepository;

    @Override
    public List<Writer> getAllWriter() {
        return writerRepository.findAll();
    }

    @Override
    public Writer getWriter(Long id) {
        Optional<Writer> optional = writerRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;

    }

    @Override
    public DtoWriter createWriter(DtoWriter dtoWriter) {
        Writer writer = new Writer();
        BeanUtils.copyProperties(dtoWriter,writer);
        writer.setCreatedDate(new Date());
        writerRepository.save(writer);
        return dtoWriter;
    }

    @Override
    public Writer updateWriter(Long id, Writer writer) {
        Writer dbWriter = getWriter(id);

        if(dbWriter != null){
            dbWriter.setName(writer.getName());

            writerRepository.save(dbWriter);
        }
        return null;
    }
}
