/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Carrito;


public interface ICarritoService {
    //Metodo CRUD 
    public void saveCarrito (Carrito carrito);
    
    public void deleteCarrito (Long id);
    
    public Carrito findCarrito(Long id);
    
    public Carrito agregarProducto(Long clienteId, Long productoId, int cantidad);
    
    
}
