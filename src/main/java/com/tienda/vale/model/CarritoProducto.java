/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class CarritoProducto {
    
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne
    private Carrito carrito;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    
    private int cantidad;

    public CarritoProducto() {
    }

    public CarritoProducto(Long id, Carrito carrito, Producto producto, int cantidad) {
        this.id = id;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
}
