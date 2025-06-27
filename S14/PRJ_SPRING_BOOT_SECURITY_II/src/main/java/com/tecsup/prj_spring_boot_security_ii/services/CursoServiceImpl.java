package com.tecsup.prj_spring_boot_security_ii.services;

import com.tecsup.prj_spring_boot_security_ii.domain.entities.Curso;
import com.tecsup.prj_spring_boot_security_ii.domain.persistance.CursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursoDao dao;

    @Override
    @Transactional
    public void grabar(Curso curso) {
        dao.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return (List<Curso>)dao.findAll();
    }
}
