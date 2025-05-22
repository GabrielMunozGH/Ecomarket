package com.productos.ejemplo.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.ejemplo.productos.model.Producto;
import com.productos.ejemplo.productos.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    // Guardar un nuevo producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener un producto por ID
    public Producto getProductoId(int id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    // Actualizar un producto existente
    public Producto updateProducto(Producto producto) {
        if (productoRepository.existsById(producto.getId())) {
            return productoRepository.save(producto); // save() también actualiza si el ID existe
        }
        return null;
    }

    // Eliminar un producto por ID
    public String deleteProducto(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return "Producto eliminado";
        }
        return "Producto no encontrado";
    }

    // Buscar producto por nombre (opcional)
    public Producto getProductoPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
