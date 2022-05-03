package com.cenfotec.grillitofeliz.services;

import com.cenfotec.grillitofeliz.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    public  Optional<Estudiante> save(Estudiante estudiante);
    public List<Estudiante> getAll();
    public Optional<Estudiante> findById(long id);
    public  Optional<Estudiante> update(Estudiante estudiante);
    public Optional<Estudiante> asignEncargado (long idEstudiante, long idEncargado);

    public boolean delete(Long id);
}
