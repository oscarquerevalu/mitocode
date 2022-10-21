package com.mitocode.service.impl;

import com.mitocode.model.Curso;
import com.mitocode.repo.ICursoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService {

    @Autowired
    private ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
