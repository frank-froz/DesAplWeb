package com.tecsup.evahuaytalla.controller;

import com.tecsup.evahuaytalla.entity.Laboratorio;
import com.tecsup.evahuaytalla.service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {
    @Autowired
    private LaboratorioService service;

    @GetMapping
    public List<Laboratorio> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Laboratorio getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Laboratorio create(@RequestBody Laboratorio lab) { return service.save(lab); }

    @PutMapping("/{id}")
    public Laboratorio update(@PathVariable Long id, @RequestBody Laboratorio lab) {
        lab.setCodLab(id);
        return service.save(lab);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
