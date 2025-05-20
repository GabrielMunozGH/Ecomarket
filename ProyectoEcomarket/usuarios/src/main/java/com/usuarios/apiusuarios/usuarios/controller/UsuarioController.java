package com.usuarios.apiusuarios.usuarios.controller;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import com.usuarios.apiusuarios.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("{id}")
    public Usuario buscaUsuario(@PathVariable int id) {
        return usuarioService.getUsuarioId(id);
    }

    @PutMapping("{id}")
    public Usuario actualizaUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id); // aseguramos que el ID sea el mismo
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("{id}")
    public String eliminarUsuario(@PathVariable int id) {
        return usuarioService.deleteUsuario(id);
    }
}
