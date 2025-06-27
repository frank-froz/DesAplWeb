package com.tecsup.prj_spring_boot_security_ii.domain.persistance;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
