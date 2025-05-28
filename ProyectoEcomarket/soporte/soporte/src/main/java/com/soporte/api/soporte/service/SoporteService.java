package com.soporte.api.soporte.service;

import com.soporte.api.soporte.model.Soporte;
import com.soporte.api.soporte.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoporteService {

    @Autowired
    private SoporteRepository soporteRepository;

    public List<Soporte> obtenerTodos() {
        return soporteRepository.findAll();
    }

    public Optional<Soporte> obtenerPorId(Long id) {
        return soporteRepository.findById(id);
    }

    public Soporte guardar(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public void eliminar(Long id) {
        soporteRepository.deleteById(id);
    }
}