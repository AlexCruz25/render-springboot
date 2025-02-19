/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Carrito;
import com.tienda.vale.model.CarritoProducto;
import com.tienda.vale.model.Pedido;
import com.tienda.vale.model.PedidoProducto;
import com.tienda.vale.repository.ICarritoProductoRepository;
import com.tienda.vale.repository.ICarritoRepository;
import com.tienda.vale.repository.IPedidoProductoRepository;
import com.tienda.vale.repository.IPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements IPedidoService {

    @Autowired 
    private IPedidoRepository pedidoRepo;
    
    @Autowired
    private ICarritoRepository carritoRepo;
    
    @Autowired 
    private ICarritoProductoRepository carritoProductoRepo;
    
    @Autowired
    private IPedidoProductoRepository pedidoProductoRepo;
    
    @Override
    public void savePedido(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepo.deleteById(id);
    }

    @Override
    public Pedido findPedido(Long id) {
        Pedido pedido= pedidoRepo.findById(id).orElse(null);
        return pedido;
    }

    @Override
    public List<Pedido> getPedidos() {
        List<Pedido> listaPedidos= pedidoRepo.findAll();
        return listaPedidos;
    }

    @Override
    public Pedido realizarCompra(Long clienteId) {
        //Buscar el carrito del cliente
        Carrito carro= carritoRepo.findByClienteId(clienteId).orElse(null);
        
        if (carro ==null || carro.getProductos().isEmpty()){
            throw new RuntimeException("El carrito esta vacio o no existe");
        }
        
        //crear un nuevo pedido
        Pedido pedido= new Pedido();
        pedido.setCliente(carro.getCliente());
        pedido.setCompletado(false);
        pedidoRepo.save(pedido);
        
        //Convertir producto del carrito en productos del pedido
        for(CarritoProducto  cp: carro.getProductos()){
            PedidoProducto pp= new PedidoProducto();
            pp.setPedido(pedido);
            pp.setProducto(cp.getProducto());
            pp.setCantidad(cp.getCantidad());
            pedidoProductoRepo.save(pp);
        }
        
        //Vaciar el carrito
        carro.getProductos().clear();
        carritoRepo.save(carro);
        return pedido;
        
    }
    
}
