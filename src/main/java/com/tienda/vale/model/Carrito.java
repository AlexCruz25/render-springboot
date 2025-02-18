/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Carrito {
    
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long carritoId;
  
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrito")
    @JsonIgnore  // Evita el bucle infinito
    private Cliente cliente;
    
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List <CarritoProducto> productos;
    
    public Carrito() {
    }

    public Carrito(Long carritoId, Cliente cliente, List<CarritoProducto> productos) {
        this.carritoId = carritoId;
        this.cliente = cliente;
        this.productos = productos;
    }

    

    
    
}
