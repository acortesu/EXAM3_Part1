package com.cenfotec.grillitofeliz.services;

import com.cenfotec.grillitofeliz.domain.Encargado;
import com.cenfotec.grillitofeliz.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EncargadoService {

    public List<Encargado> getAll();
    public Optional<Encargado> findById(long id);
    public Optional<Encargado> save(Encargado encargado);
    public Optional<Encargado> update(Encargado encargado);
    public Optional<Encargado> findByNombreStartingWith(String nombre);
    public Optional<Encargado> asignEstudiante (long idEncargado, long idEstudiante);


    public boolean delete(Long id);
}
