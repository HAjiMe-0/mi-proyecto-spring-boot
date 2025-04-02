package com.universidad.service;

import com.universidad.dto.EstudianteDTO;
import java.util.List;

public interface IEstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);
    void eliminarEstudiante(Long id);


}
