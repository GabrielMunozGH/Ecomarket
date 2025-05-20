package com.productos.ejemplo.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productos.ejemplo.productos.repository.ProductoRepository;
import com.productos.ejemplo.productos.model.Producto;


@Service

public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos(){
        return productoRepository.obtenerProductos();
    }

    public Producto saveProducto(Producto producto){
        return productoRepository.agregar(producto);
    }

    public Producto getProductoId(int id){
        return productoRepository.buscarporId(id);
    }

    public Producto updateProducto(Producto prod){
        return productoRepository.actualizar(prod);
    }

    public String deleteProducto(int id){
         productoRepository.eliminar(id);
         return "Producto eliminado";
    }









}
