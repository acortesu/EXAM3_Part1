package com.cenfotec.grillitofeliz.controller;

import com.cenfotec.grillitofeliz.domain.Encargado;
import com.cenfotec.grillitofeliz.domain.Estudiante;
import com.cenfotec.grillitofeliz.services.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/encargados"})
public class EncargadoController {

    @Autowired
    private EncargadoService encargadoService;

    @PostMapping
    public Encargado create(@RequestBody Encargado encargado){
        return encargadoService.save(encargado).get();
    }

    @GetMapping
    public List getAll(){
        return encargadoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Encargado> findById(@PathVariable long id){
        Optional<Encargado> result = encargadoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Encargado> update(@PathVariable("id") long id,
                                          @RequestBody Encargado encargado){
        encargado.setId(id);
        Optional<Encargado> result = encargadoService.update(encargado);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/porNombre/{nombre}"})
    public ResponseEntity<Object> findByNombreStartingWith(@PathVariable String nombre){
        Optional<Encargado> result = encargadoService.findByNombreStartingWith(nombre);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{idEncargado}/estudiante/{idEstudiante}")
    public ResponseEntity<Encargado> asignEncargado(@PathVariable("idEncargado") long idEncargado,
                                                     @PathVariable ("idEstudiante") long idEstudiante)
                                                     {
        Optional<Encargado> result = encargadoService.asignEstudiante(idEncargado,idEstudiante);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (encargadoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
