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
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    
    
    
    @ManyToOne
    @JoinColumn(name= "tipo_producto_id", nullable= false)
    private TipoProducto tipoProducto;
    
    
    
    @ManyToOne
    @JoinColumn(name="administrador_id", nullable= false)
    private Administrador administrador;
    
   

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Double precio, int stock, TipoProducto tipoProducto, Administrador administrador) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tipoProducto = tipoProducto;
        this.administrador = administrador;
    }
    
}
