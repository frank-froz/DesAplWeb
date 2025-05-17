package com.tecsup.evahuaytalla.service.impl;

import com.tecsup.evahuaytalla.entity.Laboratorio;
import com.tecsup.evahuaytalla.repository.LaboratorioRepository;
import com.tecsup.evahuaytalla.service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {
    @Autowired
    private LaboratorioRepository repo;

    public List<Laboratorio> findAll() { return repo.findAll(); }
    public Laboratorio findById(Long id) { return repo.findById(id).orElse(null); }
    public Laboratorio save(Laboratorio lab) { return repo.save(lab); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
