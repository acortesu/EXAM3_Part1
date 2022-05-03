package com.cenfotec.grillitofeliz.repositories;

import com.cenfotec.grillitofeliz.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}