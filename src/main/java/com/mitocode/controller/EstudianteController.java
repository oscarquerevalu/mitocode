package com.mitocode.controller;

import com.mitocode.dto.EstudianteDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Estudiante;
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
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService service;

    @Autowired
    @Qualifier("estudianteMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{
        List<EstudianteDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, EstudianteDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return new ResponseEntity<>(mapper.map(obj, EstudianteDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.create(mapper.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapper.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.readById(dto.getIdEstudiante());

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdEstudiante());
        }
        Estudiante cat = service.update(mapper.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapper.map(cat, EstudianteDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.readById(id);

        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/order")
    public ResponseEntity<List<EstudianteDTO>> readAllOrder() throws Exception{
        List<EstudianteDTO> list = service.findAllOrderByEdad().stream().map(cat -> mapper.map(cat, EstudianteDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
