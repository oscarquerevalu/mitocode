package com.mitocode.service.impl;

import com.mitocode.model.Curso;
import com.mitocode.model.Matricula;
import com.mitocode.repo.ICursoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMatriculaRepo;
import com.mitocode.service.ICursoService;
import com.mitocode.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    @Autowired
    private IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
