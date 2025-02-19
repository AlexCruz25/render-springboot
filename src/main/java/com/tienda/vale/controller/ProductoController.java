/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.controller;

import com.tienda.vale.model.Producto;
import com.tienda.vale.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoServ;
    
    @GetMapping ("/producto/traer")
    public List<Producto> listaProductos(){
        List<Producto> listaProductos= productoServ.getProductos();
        return listaProductos;
    }
    
    @PostMapping ("/producto/crear")
    public String saveProducto(Producto producto){
        productoServ.saveProducto(producto);
        return "Producto crado";
    }
    
    @DeleteMapping ("/producto/borrar/{id}")
    public String deleteProducto (@PathVariable Long id){
        productoServ.deleteProducto(id);
        return "Borrar productos";
    }
    
    @PutMapping ("/producto/editar/{idOriginal}")
    public Producto editProducto (@PathVariable Long idOriginal,
                                @RequestParam(required=false, name="id") Long nuevaId,
                                @RequestParam(required=false, name="nuevoNombre") String nuevoNombre,
                                @RequestParam(required=false, name="nuevaDescripcion")String nuevaDescripcion,
                                @RequestParam(required=false, name="nuevoPrecio")Double nuevoPrecio,
                                @RequestParam(required=false, name="stock") int stock,
                                @RequestParam(required=false, name="url")String url
                                ){
        productoServ.editProducto(idOriginal, nuevaId, nuevoNombre, nuevaDescripcion, nuevoPrecio, stock,url);
        Producto product= productoServ.findProducto(nuevaId);
        return product;
    }
    
    
}
