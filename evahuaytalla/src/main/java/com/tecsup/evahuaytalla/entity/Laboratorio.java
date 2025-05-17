package com.tecsup.evahuaytalla.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.Id;

@Entity
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codLab;

    private String razonSocial;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;

    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.ALL)
    private List<NroOrdenC> ordenes;

    // Getters y setters
}
