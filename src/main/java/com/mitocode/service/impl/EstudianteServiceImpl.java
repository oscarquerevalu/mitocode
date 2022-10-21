package com.mitocode.service.impl;

import com.mitocode.model.Estudiante;
import com.mitocode.repo.IEstudianteRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    @Autowired
    private IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> findAllOrderByEdad() {
        //return repo.findAll(Sort.by(Sort.Direction.DESC, "edad"));
        Comparator<Estudiante> inverse = (x1,x2) -> x2.getEdad() - x1.getEdad();
        List<Estudiante> list = repo.findAll();

        return list.stream()
                //.sorted(Comparator.comparing(Estudiante::getEdad))
                .sorted(inverse)
                .collect(Collectors.toList());
    }
}
