/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.controller;

import com.tienda.vale.model.Pedido;
import com.tienda.vale.service.IPedidoService;
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
public class PedidoController {
    @Autowired
    private IPedidoService pedidoServ;
    
    @PostMapping ("/pedido/crear")
    public String createPedido(@RequestBody Pedido pedido){
        pedidoServ.savePedido(pedido);
        return "El pedido fue creado correctamente";
    }
    
    @GetMapping ("/pedido/traer")
    public List<Pedido> getPersonas(){
        return pedidoServ.getPedidos();
    }
    
    @DeleteMapping("/pedido/borrar/{id}")
    public String deletePedido(@PathVariable Long id){
        pedidoServ.deletePedido(id);
        return "Pedido Eliminado correctamente";
    }
    
    @PostMapping("/realizar/{clienteId}")
    public ResponseEntity<String> realizarPedido(@PathVariable Long clienteId){
        try{
            pedidoServ.realizarCompra(clienteId);
            return ResponseEntity.ok("Pedido realizado con exito");
        } catch (RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
    }
    
    
    
}
