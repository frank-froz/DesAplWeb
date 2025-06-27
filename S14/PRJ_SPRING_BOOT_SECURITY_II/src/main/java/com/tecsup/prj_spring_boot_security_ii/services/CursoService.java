package com.tecsup.prj_spring_boot_security_ii.services;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.Curso;

import java.util.List;

public interface CursoService {

    public void grabar(Curso curso);
    public void eliminar(int id);
    public Curso buscar(Integer id);
    public List<Curso> listar();
}