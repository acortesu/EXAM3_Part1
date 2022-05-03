package com.cenfotec.grillitofeliz.controller;

import com.cenfotec.grillitofeliz.domain.Encargado;
import com.cenfotec.grillitofeliz.domain.Estudiante;
import com.cenfotec.grillitofeliz.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/estudiantes"})
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante).get();
    }

    @GetMapping
    public List getAll(){
        return estudianteService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Estudiante> findById(@PathVariable long id){
        Optional<Estudiante> result = estudianteService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable("id") long id,
                                            @RequestBody Estudiante estudiante){
        estudiante.setId(id);
        Optional<Estudiante> result = estudianteService.update(estudiante);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{idEstudiante}/encargado/{idEncargado}")
    public ResponseEntity<Estudiante> asignEncargado(@PathVariable("idEstudiante") long idEstudiante,
                                                     @PathVariable("idEncargado") long idEncargado){

        Optional<Estudiante> result = estudianteService.asignEncargado(idEstudiante, idEncargado);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (estudianteService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
