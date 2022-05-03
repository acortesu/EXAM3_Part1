package com.cenfotec.grillitofeliz.repositories;

import com.cenfotec.grillitofeliz.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository  extends JpaRepository<Estudiante, Long> {
}