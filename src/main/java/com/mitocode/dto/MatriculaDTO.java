package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Integer idMatricula;
    private LocalDateTime fechaMatricula;

    @JsonIncludeProperties(value= {"idEstudiante"})
    private EstudianteDTO estudiante;

    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatriculas;

    private boolean estadoMatricula;
}
