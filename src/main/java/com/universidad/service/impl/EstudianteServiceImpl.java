package com.universidad.service.impl;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteRepository.init(); // Inicializa con datos de ejemplo
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    // 1
    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id);
        if (estudiante == null) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        return convertirADTO(estudiante);
    }

    // 2
    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = convertirAEntidad(estudianteDTO);
        estudiante = estudianteRepository.save(estudiante);
        return convertirADTO(estudiante);
    }

    // 3
    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudianteExistente = estudianteRepository.findById(id);
        if (estudianteExistente == null) {
            throw new RuntimeException("Estudiante no encontrado");
        }

        estudianteExistente.setNombre(estudianteDTO.getNombre());
        estudianteExistente.setApellido(estudianteDTO.getApellido());
        estudianteExistente.setEmail(estudianteDTO.getEmail());
        estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());

        return convertirADTO(estudianteRepository.save(estudianteExistente));
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    private EstudianteDTO convertirADTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
                estudiante.getEmail(), estudiante.getFechaNacimiento(), estudiante.getNumeroInscripcion());
    }

    private Estudiante convertirAEntidad(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }

}
