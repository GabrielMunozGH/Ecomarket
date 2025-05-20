package com.productos.ejemplo.productos.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.productos.ejemplo.productos.model.Producto;

@Repository
public class ProductoRepository {


    private List<Producto> listaProductos = new ArrayList<>();

    //obtener todos los productos
    public List<Producto> obtenerProductos () {
        return listaProductos;
    }

    //buscar producto por id

    public Producto buscarporId(int id) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;

    }

    //BUSCA POR NOMBRE
    public Producto buscarporNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public Producto agregar (Producto prod){
        listaProductos.add(prod);
        return prod;
    }

    public Producto actualizar(Producto prod){
        int id = 0;
        int idPosicion =0;

        for(int i=0; i < listaProductos.size();i++){
            if (listaProductos.get(i).getId() == prod.getId()){
                id =prod.getId();
                idPosicion = i;

            }
        }

        Producto producto1 = new Producto();
        producto1.setId(id);
        producto1.setNombre(prod.getNombre());
        producto1.setPrecio(prod.getPrecio());
        producto1.setDescripcion(prod.getDescripcion());
        producto1.setCantidad(prod.getCantidad());

        listaProductos.set(idPosicion, producto1);
        return producto1;

    }

    public void eliminar(int id){
        Producto producto = buscarporId(id);
        if (producto != null){
            listaProductos.remove(producto);
        }

        // alternativa 2
        int idPosicion=0;
        for (int i = 0; i < listaProductos.size(); i++){
            if (listaProductos.get(i).getId() == id){
                idPosicion =i;
                break;
            }  
        }
        if (idPosicion > 0){
            listaProductos.remove(idPosicion);
        }


        listaProductos.removeIf(x -> x.getId () == id);

    }

}


