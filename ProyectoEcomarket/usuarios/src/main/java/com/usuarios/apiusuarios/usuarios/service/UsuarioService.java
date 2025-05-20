package com.usuarios.apiusuarios.usuarios.service;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import com.usuarios.apiusuarios.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.agregar(usuario);
    }

    public Usuario getUsuarioId(int id) {
        return usuarioRepository.buscarPorId(id);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    public String deleteUsuario(int id) {
        usuarioRepository.eliminar(id);
        return "Usuario eliminado correctamente";
    }
}
