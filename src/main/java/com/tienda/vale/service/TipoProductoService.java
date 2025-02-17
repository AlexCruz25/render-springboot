/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.TipoProducto;
import com.tienda.vale.repository.ITipoProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoService implements ITipoProductoService{
    
    @Autowired 
    private ITipoProductoRepository tipoProductoRepo;

    @Override
    public List<TipoProducto> listarTipoDeProductos() {
        return tipoProductoRepo.findAll();
    }

    @Override
    public TipoProducto guardarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepo.save(tipoProducto);
    }
    
    
}
