package com.tecsup.evahuaytalla.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class NroOrdenC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaEmision;
    private String situacion;
    private Double total;
    private String nroFacturaProv;

    @ManyToOne
    @JoinColumn(name = "codLab")
    private Laboratorio laboratorio;

    // Getters y setters
}
