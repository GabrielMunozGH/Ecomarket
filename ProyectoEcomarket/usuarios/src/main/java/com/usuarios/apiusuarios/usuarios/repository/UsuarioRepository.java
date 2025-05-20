package com.usuarios.apiusuarios.usuarios.repository;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario agregar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    public Usuario actualizar(Usuario usuario) {
        int posicion = -1;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == usuario.getId()) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            listaUsuarios.set(posicion, usuario);
            return usuario;
        }
        return null;
    }

    public void eliminar(int id) {
        listaUsuarios.removeIf(u -> u.getId() == id);
    }
}
