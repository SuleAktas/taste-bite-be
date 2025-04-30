package com.suleaktasyazan.TasteBiteBE.controller.impl;

import com.suleaktasyazan.TasteBiteBE.controller.IWriterController;
import com.suleaktasyazan.TasteBiteBE.dto.DtoWriter;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;
import com.suleaktasyazan.TasteBiteBE.service.IWriterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/writer")
public class WriterControllerImpl implements IWriterController {

    @Autowired
    private IWriterService writerService;

    @Override
    @GetMapping()
    public List<Writer> getAllWriter() {
        return writerService.getAllWriter();
    }

    @Override
    @GetMapping(path = "/{id}")
    public Writer getWriter(@PathVariable(name="id") Long id) {
        return writerService.getWriter(id);
    }

    @Override
    @PostMapping()
    public DtoWriter createWriter(@RequestBody @Valid DtoWriter writer) {
        return writerService.createWriter(writer);
    }

    @Override
    @PutMapping("/{id}")
    public Writer updateWriter(@PathVariable(name="id") Long id, @RequestBody Writer writer) {
        return writerService.updateWriter(id,writer);
    }
}
