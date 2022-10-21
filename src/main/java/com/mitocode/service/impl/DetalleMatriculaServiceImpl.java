package com.mitocode.service.impl;

import com.mitocode.model.Curso;
import com.mitocode.model.DetalleMatricula;
import com.mitocode.model.Matricula;
import com.mitocode.repo.IDetalleMatriculaRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMatriculaRepo;
import com.mitocode.service.IDetalleMatriculaService;
import com.mitocode.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DetalleMatriculaServiceImpl extends CRUDImpl<DetalleMatricula, Integer> implements IDetalleMatriculaService {

    @Autowired
    private IDetalleMatriculaRepo repo;

    @Override
    protected IGenericRepo<DetalleMatricula, Integer> getRepo() {
        return repo;
    }


    @Override
    public Map<String,List<String>> findGroup() {
        List<DetalleMatricula> list = repo.findAll();
        Map<String,List<String>> result = new HashMap<>();

        list.stream()
                .collect(Collectors.groupingBy(DetalleMatricula::getCurso))
                .forEach((k,v)->{
                    result.put(k.getNombre(),v.stream().map(e ->{
                                return e.getMatricula().getEstudiante().getNombres() + " " +e.getMatricula().getEstudiante().getApellidos();
                            }
                    ).collect(Collectors.toList()));
                });;
        return result;
    }
}
