/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Pedido;
import java.util.List;


public interface IPedidoService {
    //Metodo CRUD
    public void savePedido (Pedido pedido);
    
    public void deletePedido(Long id);
    
    public Pedido findPedido(Long id);
    
    public List<Pedido> getPedidos();
    
    public Pedido realizarCompra(Long clienteId);
}
