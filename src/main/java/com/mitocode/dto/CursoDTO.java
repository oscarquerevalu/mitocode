package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private Integer idCurso;
    private String nombreCurso;
    private String siglasCurso;
    private boolean estadoCurso;
}
