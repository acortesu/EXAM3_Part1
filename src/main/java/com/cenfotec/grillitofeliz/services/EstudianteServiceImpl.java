package com.cenfotec.grillitofeliz.services;

import com.cenfotec.grillitofeliz.domain.Encargado;
import com.cenfotec.grillitofeliz.domain.Estudiante;
import com.cenfotec.grillitofeliz.repositories.EncargadoRepository;
import com.cenfotec.grillitofeliz.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepo;
    @Autowired
    EncargadoRepository encargadoRepo;

    @Override
    public Optional<Estudiante> save(Estudiante estudiante) {

        return Optional.of(estudianteRepo.save(estudiante));
    }

    @Override
    public List<Estudiante> getAll() {

        return estudianteRepo.findAll();
    }

    @Override
    public Optional<Estudiante> findById(long id) {

        return estudianteRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Estudiante> update(Estudiante estudiante) {

        Optional<Estudiante> record = estudianteRepo.findById(estudiante.getId());

        if (record.isPresent()) {

            Estudiante data = record.get();

            data.setNombre(estudiante.getNombre());
            data.setTipoUsuario(estudiante.getTipoUsuario());
            data.setAlergias(estudiante.getAlergias());

            return Optional.of(estudianteRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Estudiante> asignEncargado (long idEstudiante, long idEncargado) {

        Optional<Estudiante> objetoEstudiate = estudianteRepo.findById(idEstudiante);
        Optional<Encargado> objetoEncargado = encargadoRepo.findById(idEncargado);

        if (objetoEstudiate.isPresent() && objetoEncargado.isPresent()) {

            Estudiante dataEst = objetoEstudiate.get();
            Encargado dataEnc = objetoEncargado.get();

            dataEnc.setEstudiantes(dataEst);
            //dataEst.setEncargado(dataEnc);

            return Optional.of(estudianteRepo.save(dataEst));
        }

        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Estudiante> result = estudianteRepo.findById(id);
        if (result.isPresent()){
            estudianteRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
