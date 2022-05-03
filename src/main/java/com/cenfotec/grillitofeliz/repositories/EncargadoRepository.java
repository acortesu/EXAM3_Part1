package com.cenfotec.grillitofeliz.repositories;

import com.cenfotec.grillitofeliz.domain.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {
    Optional<Encargado> findByNombreStartingWith(String nombre);
}
