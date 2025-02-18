/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.controller;

import com.tienda.vale.model.Cliente;
import com.tienda.vale.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServ;
    
    @GetMapping("/cliente/traer")
    public List <Cliente> getClientes(){
        return clienteServ.getClientes();
    }
    
    
    
    @PostMapping ("/cliente/crear")
    public String saveCliente (@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
        return "Cliente creado correctamente";
        
    }
    
    @DeleteMapping ("/cliente/borrar/{id}")
    public String deleteCliente (@PathVariable Long id){
        clienteServ.deleteCliente(id);
        
        return "Cliete borrado correctamente";
    }
    
    @PutMapping ("/cliente/editar/{idOriginal}")
    public Cliente editCliente(@PathVariable Long idOriginal,
                               @RequestParam(required= false, name ="id") Long nuevaId,
                               @RequestParam(required= false, name = "nombre") String nuevoNombre,
                               @RequestParam(required= false, name= "apellido") String nuevoApellido,
                               @RequestParam(required= false, name= "edad") int nuevaEdad
                               ){
        clienteServ.editCliente(idOriginal, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);
        Cliente cli= clienteServ.findCliente(nuevaId);
        return cli;
    }
    
}
