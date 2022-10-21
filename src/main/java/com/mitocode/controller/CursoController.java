package com.mitocode.controller;

import com.mitocode.dto.CursoDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Curso;
import com.mitocode.model.Estudiante;
import com.mitocode.service.ICursoService;
import com.mitocode.service.IEstudianteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICursoService service;

    @Autowired
    @Qualifier("cursoMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{
        List<CursoDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, CursoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, CursoDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto) throws Exception{
        Curso obj = service.create(mapper.map(dto, Curso.class));
        return new ResponseEntity<>(mapper.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO dto) throws Exception{
        Curso obj = service.readById(dto.getIdCurso());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdCurso());
        }
        Curso cat = service.update(mapper.map(dto, Curso.class));
        return new ResponseEntity<>(mapper.map(cat, CursoDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
