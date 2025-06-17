package com.usuarios.apiusuarios.usuarios.repository;

import com.usuarios.apiusuarios.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByEmailAndContrasena(String email, String contrasena);
    Optional<Usuario> findByEmail(String email);
}
