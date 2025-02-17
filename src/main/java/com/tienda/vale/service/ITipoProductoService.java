/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.TipoProducto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ITipoProductoService {
    
    public List<TipoProducto> listarTipoDeProductos();
    
    public TipoProducto guardarTipoProducto(TipoProducto tipoProducto);
}
