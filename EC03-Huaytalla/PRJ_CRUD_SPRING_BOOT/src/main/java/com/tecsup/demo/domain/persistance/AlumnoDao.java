package com.tecsup.demo.domain.persistance;

import com.tecsup.demo.domain.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDao extends CrudRepository<Alumno, Integer> {
}
