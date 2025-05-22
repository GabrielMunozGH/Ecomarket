package com.usuarios.apiusuarios.usuarios.repository;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // Optional<Usuario> findByEmail(String email);
}
