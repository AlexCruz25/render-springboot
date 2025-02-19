
package com.tienda.vale.controller;

import com.tienda.vale.model.Administrador;
import com.tienda.vale.model.Producto;
import com.tienda.vale.service.IAdministradorService;
import com.tienda.vale.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministradorController {
    @Autowired
    private IAdministradorService adminServ;
    
    @Autowired
    private IProductoService productoService;

    @PostMapping ("/administrador/crear")
    public String saveAdministrador (@RequestBody Administrador admin){
        adminServ.saveAdministrador(admin);
        return "El administrador fue creado correctamente";
    }
    
    @DeleteMapping ("/administrador/delete/{id}")
   public String deleteAdministrador (@PathVariable Long id){
       adminServ.deleteAdministrador(id);
       return ("Administrador Eliminado");
   }
}
