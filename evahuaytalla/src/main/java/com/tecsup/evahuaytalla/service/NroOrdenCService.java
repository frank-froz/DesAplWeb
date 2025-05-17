package com.tecsup.evahuaytalla.service;

import com.tecsup.evahuaytalla.entity.NroOrdenC;

import java.util.List;

public interface NroOrdenCService {
    List<NroOrdenC> findAll();
    NroOrdenC findById(Long id);
    NroOrdenC save(NroOrdenC orden);
    void deleteById(Long id);
}
