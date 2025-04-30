package com.suleaktasyazan.TasteBiteBE.service;

import com.suleaktasyazan.TasteBiteBE.dto.DtoWriter;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;

import java.util.List;

public interface IWriterService {

    public List<Writer> getAllWriter();

    public Writer getWriter(Long id);

    public DtoWriter createWriter(DtoWriter writer);

    public Writer updateWriter(Long id,Writer writer);
}
