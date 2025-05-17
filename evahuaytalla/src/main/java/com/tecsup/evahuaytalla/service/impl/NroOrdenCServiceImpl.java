package com.tecsup.evahuaytalla.service.impl;

import com.tecsup.evahuaytalla.entity.NroOrdenC;
import com.tecsup.evahuaytalla.repository.NroOrdenCRepository;
import com.tecsup.evahuaytalla.service.NroOrdenCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NroOrdenCServiceImpl implements NroOrdenCService {
    @Autowired
    private NroOrdenCRepository repo;

    public List<NroOrdenC> findAll() { return repo.findAll(); }
    public NroOrdenC findById(Long id) { return repo.findById(id).orElse(null); }
    public NroOrdenC save(NroOrdenC orden) { return repo.save(orden); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
