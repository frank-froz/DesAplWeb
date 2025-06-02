package com.tecsup.demo.controller;

import com.tecsup.demo.model.Laboratorio;
import com.tecsup.demo.model.OrdenCompra;
import com.tecsup.demo.repository.LaboratorioRepository;
import com.tecsup.demo.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @GetMapping
    public List<OrdenCompra> listar() {
        return ordenRepository.findAll();
    }

    @PostMapping
    public OrdenCompra guardar(@RequestBody OrdenCompra orden) {
        Long idLab = orden.getLaboratorio().getCodLab();
        Laboratorio lab = laboratorioRepository.findById(idLab)
                .orElseThrow(() -> new RuntimeException("Laboratorio no encontrado"));
        orden.setLaboratorio(lab);
        return ordenRepository.save(orden);
    }


    @PutMapping("/{id}")
    public OrdenCompra actualizar(@PathVariable Long id, @RequestBody OrdenCompra orden) {
        orden.setNro_orden_c(id);
        return ordenRepository.save(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ordenRepository.deleteById(id);
    }
}
