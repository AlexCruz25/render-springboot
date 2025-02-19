
package com.tienda.vale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PedidoProducto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Long id;
    
    @ManyToOne
    private Pedido pedido;
    
    @ManyToOne
    private Producto producto;
    
    private int cantidad;
    private double precioUnitario;

    public PedidoProducto() {
    }

    public PedidoProducto(Long id, Pedido pedido, Producto producto, int cantidad, double precioUnitario) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    
    
    
    
}
