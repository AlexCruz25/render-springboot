 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate fechaPedido;
    private boolean completado= false;
    
    @ManyToOne 
    private Cliente cliente;
    
    @OneToMany
    private List<PedidoProducto> productos;
    

    public Pedido() {
    }

    public Pedido(Long id, LocalDate fechaPedido, Cliente cliente, List<PedidoProducto> productos) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
        this.productos = productos;
    }

   
    
}
