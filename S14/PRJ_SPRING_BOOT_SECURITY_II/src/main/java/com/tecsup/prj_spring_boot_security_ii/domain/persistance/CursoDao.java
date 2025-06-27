package com.tecsup.prj_spring_boot_security_ii.domain.persistance;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoDao extends CrudRepository<Curso,Integer> {
}

