package com.mitocode.service;

import com.mitocode.model.DetalleMatricula;
import com.mitocode.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IDetalleMatriculaService extends ICRUD<DetalleMatricula, Integer>{

    Map<String, List<String>> findGroup();

}
