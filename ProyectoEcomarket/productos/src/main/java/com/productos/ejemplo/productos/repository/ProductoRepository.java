package com.productos.ejemplo.productos.repository;

import com.productos.ejemplo.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Ejemplo de método personalizado (opcional)
    Producto findByNombre(String nombre);
}
