package com.cenfotec.grillitofeliz.services;

import com.cenfotec.grillitofeliz.domain.Encargado;
import com.cenfotec.grillitofeliz.domain.Estudiante;
import com.cenfotec.grillitofeliz.repositories.EncargadoRepository;
import com.cenfotec.grillitofeliz.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncargadoServiceImpl implements EncargadoService {

    @Autowired
    EncargadoRepository encargadoRepo;
    @Autowired
    EstudianteRepository estudianteRepo;

    @Override
    public Optional<Encargado> save(Encargado encargado) {

        return Optional.of(encargadoRepo.save(encargado));
    }

    @Override
    public List<Encargado> getAll() {

        return encargadoRepo.findAll();
    }

    @Override
    public Optional<Encargado> findById(long id) {

        return encargadoRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Encargado> findByNombreStartingWith(String nombre) {
        return encargadoRepo.findByNombreStartingWith(nombre);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Encargado> result = encargadoRepo.findById(id);
        if (result.isPresent()){
            encargadoRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Encargado> update(Encargado encargado) {

        Optional<Encargado> record = encargadoRepo.findById(encargado.getId());

        if (record.isPresent()) {

            Encargado data = record.get();

            data.setNombre(encargado.getNombre());
            data.setCedula(encargado.getCedula());
            data.setDireccion(encargado.getDireccion());
            data.setTelefonoPrimario(encargado.getTelefonoPrimario());
            data.setTelefonoSecundario(encargado.getTelefonoSecundario());

            return Optional.of(encargadoRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Encargado> asignEstudiante (long idEncargado, long idEstudiante ) {

        Optional<Encargado> objetoEncargado = encargadoRepo.findById(idEncargado);
        Optional<Estudiante> objetoEstudiate = estudianteRepo.findById(idEstudiante);

        if (objetoEstudiate.isPresent() && objetoEncargado.isPresent()) {

            Encargado dataEnc = objetoEncargado.get();
            Estudiante dataEst = objetoEstudiate.get();

            dataEnc.setEstudiantes(dataEst);
            //dataEst.setEncargado(dataEnc);

            return Optional.of(encargadoRepo.save(dataEnc));
        }

        return Optional.empty();
    }

}
