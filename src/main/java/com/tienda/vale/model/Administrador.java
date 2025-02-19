
package com.tienda.vale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Entity

public class Administrador extends Usuario {
       
    @ManyToMany
    private List <Producto> listaProductos;
    
    @OneToMany
    private List<Reporte> reportes;

    public Administrador() {
    }

    public Administrador(List<Producto> listaProductos, List<Reporte> reportes) {
        this.listaProductos = listaProductos;
        this.reportes = reportes;
    }

    public Administrador(List<Producto> listaProductos, List<Reporte> reportes, Long id, String nombre, String apellido, String email, String telefono, String password, String direccion) {
        super(id, nombre, apellido, email, telefono, password, direccion);
        this.listaProductos = listaProductos;
        this.reportes = reportes;
    }
}
