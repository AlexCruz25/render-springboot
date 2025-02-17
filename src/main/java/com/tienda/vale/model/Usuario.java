
package com.tienda.vale.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
    
    
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String password;
    protected String direccion;
    
    
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String telefono, String password, String direccion) {
        this.id = id;
      
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.direccion = direccion;
    }
    
}
