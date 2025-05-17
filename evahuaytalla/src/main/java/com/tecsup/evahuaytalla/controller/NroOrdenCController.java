package com.tecsup.evahuaytalla.controller;

import com.tecsup.evahuaytalla.entity.NroOrdenC;
import com.tecsup.evahuaytalla.service.NroOrdenCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class NroOrdenCController {
    @Autowired
    private NroOrdenCService service;

    @GetMapping
    public List<NroOrdenC> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public NroOrdenC getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public NroOrdenC create(@RequestBody NroOrdenC orden) { return service.save(orden); }

    @PutMapping("/{id}")
    public NroOrdenC update(@PathVariable Long id, @RequestBody NroOrdenC orden) {
        orden.setId(id);
        return service.save(orden);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
