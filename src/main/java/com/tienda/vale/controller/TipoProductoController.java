/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.controller;

import com.tienda.vale.model.TipoProducto;
import com.tienda.vale.service.ITipoProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TipoProductoController {
    @Autowired
    private ITipoProductoService tipoProductoServ;
    
    //listar todos los tipos de productos
    @GetMapping("/tipoProducto/listar")
    public List<TipoProducto>listarTiposProductos(){
        return tipoProductoServ.listarTipoDeProductos();
    }
    
    //agregar un nuevo tipo de producto
    @PostMapping("/crear")
    public ResponseEntity<TipoProducto> crearTipoProducto(@RequestBody TipoProducto tipoProducto){
        TipoProducto nuevoTipo = tipoProductoServ.guardarTipoProducto(tipoProducto);
        return ResponseEntity.ok(nuevoTipo);
    }
    
}
