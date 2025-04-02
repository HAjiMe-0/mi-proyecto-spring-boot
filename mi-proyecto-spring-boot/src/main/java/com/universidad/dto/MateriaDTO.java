package com.universidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MateriaDTO {
    private Long id;
    private String nombreMateria;
    private String codigoUnico;
    private Integer creditos;
}
