package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoWriter;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;

import java.util.List;

public interface IWriterController {
    public List<Writer> getAllWriter();

    public Writer getWriter(Long id);

    public DtoWriter createWriter(DtoWriter writer);

    public Writer updateWriter(Long id,Writer writer);
}
