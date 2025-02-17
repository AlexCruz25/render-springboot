/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TipoProducto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;

    @OneToMany(mappedBy ="tipoProducto", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> listaTipoProducto;
    
    public TipoProducto() {
    }

    public TipoProducto(Long id, String nombre, String genero, List<Producto> listaTipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.listaTipoProducto = listaTipoProducto;
    }

    
    

    
}
