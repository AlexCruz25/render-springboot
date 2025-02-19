/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.repository.IPedidoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProductoService implements IPedidoProductoService {
    
    @Autowired
    private IPedidoProductoRepository pedidoProductoRepo;
    
    
    
}
