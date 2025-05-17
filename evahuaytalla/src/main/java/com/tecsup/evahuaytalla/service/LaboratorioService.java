package com.tecsup.evahuaytalla.service;

import com.tecsup.evahuaytalla.entity.Laboratorio;

import java.util.List;

public interface LaboratorioService {
    List<Laboratorio> findAll();
    Laboratorio findById(Long id);
    Laboratorio save(Laboratorio lab);
    void deleteById(Long id);
}
