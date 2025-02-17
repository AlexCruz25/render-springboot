
package com.tienda.vale.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Entity
public class Cliente extends Usuario{
    
    private int edad;
    private String pago;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name ="carrito_carrito_id", referencedColumnName= "carritoId")
    private Carrito carrito;
    
    @OneToMany
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(int edad, String pago, Carrito carrito, List<Pedido> pedidos, Long id, String nombre, String apellido, String email, String telefono, String password, String direccion) {
        super(id, nombre, apellido, email, telefono, password, direccion);
        this.edad = edad;
        this.pago = pago;
        this.carrito = carrito;
        this.pedidos = pedidos;
    }
    
    
    
    
    
}
