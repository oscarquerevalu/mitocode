package com.mitocode.controller;

import com.mitocode.dto.CursoDTO;
import com.mitocode.dto.EstudianteDTO;
import com.mitocode.dto.MatriculaDTO;

import com.mitocode.model.Matricula;
import com.mitocode.service.ICursoService;
import com.mitocode.service.IDetalleMatriculaService;
import com.mitocode.service.IMatriculaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaService service;

    @Autowired
    private IDetalleMatriculaService serviceDetalleMatricula;

    @Autowired
    @Qualifier("matriculaMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<MatriculaDTO> list = service.readAll().stream().map(cat -> mapper.map(cat, MatriculaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@Valid @RequestBody MatriculaDTO dto) throws Exception{
        Matricula obj = service.create(mapper.map(dto, Matricula.class));
        return new ResponseEntity<>(mapper.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/group")
    public ResponseEntity<Map<String,List<String>>> readAllGroup() throws Exception{
        Map<String,List<String>> result = serviceDetalleMatricula.findGroup();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
