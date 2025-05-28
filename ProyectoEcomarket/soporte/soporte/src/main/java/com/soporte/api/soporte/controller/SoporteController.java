package com.soporte.api.soporte.controller;

import com.soporte.api.soporte.model.Soporte;
import com.soporte.api.soporte.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soportes")
@CrossOrigin(origins = "*")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public List<Soporte> obtenerTodos() {
        return soporteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Soporte> obtenerPorId(@PathVariable Long id) {
        return soporteService.obtenerPorId(id);
    }

    @PostMapping
    public Soporte crear(@RequestBody Soporte soporte) {
        return soporteService.guardar(soporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        soporteService.eliminar(id);
    }
}