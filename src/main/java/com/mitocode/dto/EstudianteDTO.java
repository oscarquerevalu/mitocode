package com.mitocode.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private Integer idEstudiante;
    private String nombresEstudiante;
    private String apellidosEstudiante;
    private String dniEstudiante;
    private int edadEstudiante;
}
