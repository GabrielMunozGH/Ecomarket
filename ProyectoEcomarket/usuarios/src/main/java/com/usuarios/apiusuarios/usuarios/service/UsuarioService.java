package com.usuarios.apiusuarios.usuarios.service;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import com.usuarios.apiusuarios.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioId(int id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public String deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado correctamente";
    }
    public Optional<Usuario> loginUsuario(String email, String contrasena) {
        return usuarioRepository.findByEmailAndContrasena(email, contrasena);
    }
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


}
