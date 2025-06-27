package com.tecsup.prj_spring_boot_security_ii.domain.persistance;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.Auditoria;
import org.springframework.data.repository.CrudRepository;

public interface AuditoriaDao extends CrudRepository<Auditoria, Integer> {

}
