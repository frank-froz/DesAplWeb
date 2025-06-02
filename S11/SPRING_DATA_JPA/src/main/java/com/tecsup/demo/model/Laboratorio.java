package com.tecsup.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codLab;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;

    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.ALL)
    private List<OrdenCompra> ordenes;

    // Getters y Setters

    public Long getCodLab() {return codLab;}

    public void setCodLab(Long codLab) {this.codLab = codLab;}

    public String getRazon_social() {return razon_social;}

    public void setRazon_social(String razon_social) {this.razon_social = razon_social;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getContacto() {return contacto;}

    public void setContacto(String contacto) {this.contacto = contacto;}

    public List<OrdenCompra> getOrdenes() {return ordenes;}

    public void setOrdenes(List<OrdenCompra> ordenes) {this.ordenes = ordenes;}
}

