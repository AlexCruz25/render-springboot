/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.controller;

import com.tienda.vale.model.Carrito;
import com.tienda.vale.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarritoController {
    @Autowired
    private ICarritoService carritoServ;
    
    @PostMapping ("/carrito/crear")
    public String saveCarrito (@RequestBody Carrito carrito){
        carritoServ.saveCarrito(carrito);
        return "Carrito creado";
    }
    
    @GetMapping ("/carrito/traer/{id}")
    public Carrito getCarrito(@PathVariable Long id){
        return carritoServ.findCarrito(id);
      
    }
    
    @PostMapping("/{clienteId}/agregar/{productoId}")
    public ResponseEntity<Carrito> agregarProductoCarrito(@PathVariable Long clienteId,
                                                          @PathVariable Long productoId,
                                                          @RequestParam int cantidad){
    Carrito carritoActualizar = carritoServ.agregarProducto(clienteId, productoId, cantidad);
    return ResponseEntity.ok(carritoActualizar);
}
    
    @PostMapping ("/agregar/{clienteId}/{productoId}/{cantidad}")
    public ResponseEntity<String> agregarProductos(@PathVariable Long clienteId,
                                                   @PathVariable Long productoId,
                                                   @PathVariable int cantidad){
        try{
            carritoServ.agregarProducto(clienteId, productoId, cantidad);
            return ResponseEntity.ok("Producto agregado al carrito");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
