package com.suleaktasyazan.TasteBiteBE.controller;

import com.suleaktasyazan.TasteBiteBE.dto.DtoWriter;
import com.suleaktasyazan.TasteBiteBE.entity.Writer;
import com.suleaktasyazan.TasteBiteBE.service.IWriterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/writer")
public class WriterController {

    @Autowired
    private IWriterService writerService;


    @GetMapping()
    public List<Writer> getAllWriter() {
        return writerService.getAllWriter();
    }


    @GetMapping(path = "/{id}")
    public Writer getWriter(@PathVariable(name="id") Long id) {
        return writerService.getWriter(id);
    }


    @PostMapping()
    public DtoWriter createWriter(@RequestBody @Valid DtoWriter writer) {
        return writerService.createWriter(writer);
    }


    @PutMapping("/{id}")
    public Writer updateWriter(@PathVariable(name="id") Long id, @RequestBody Writer writer) {
        return writerService.updateWriter(id,writer);
    }
}
