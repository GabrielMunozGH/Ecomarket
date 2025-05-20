package com.productos.ejemplo.productos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.productos.ejemplo.productos.model.Producto;
import com.productos.ejemplo.productos.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    private final ProductoService productoService;

    // Constructor para inyección de dependencias
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listaProductos() {
        return productoService.getProductos();
    }

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }
    
    @GetMapping("{id}")
    public Producto buscaProducto(@PathVariable int id) {
        return productoService.getProductoId(id);
    }
    
    @PutMapping("{id}")
    public Producto actualizaProducto(@PathVariable int id, @RequestBody Producto producto) {
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("{id}")
    public String eliminarProducto(@PathVariable int id) {
        return productoService.deleteProducto(id);
    }
}
