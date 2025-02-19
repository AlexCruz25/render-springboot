/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Carrito;
import com.tienda.vale.model.CarritoProducto;
import com.tienda.vale.model.Producto;
import com.tienda.vale.repository.ICarritoProductoRepository;
import com.tienda.vale.repository.ICarritoRepository;
import com.tienda.vale.repository.IProductoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService{
    
    @Autowired
    private ICarritoRepository carritoRepo;
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Autowired
    private ICarritoProductoRepository carritoProductoRepo;

    @Override
    public void saveCarrito(Carrito carrito) {
        carritoRepo.save(carrito);
    }

    @Override
    public void deleteCarrito(Long id) {
        carritoRepo.deleteById(id);
    }
    @Override
    public Carrito findCarrito(Long id) {
        Carrito carro= carritoRepo.findById(id).orElse(null);
        return carro;
    }

    @Override
    public Carrito agregarProducto(Long clienteId, Long productoId, int cantidad) {
        
        //Buscar el carrito del cliente
        Carrito carrito = carritoRepo.findById(clienteId).orElse(null);
        
        //Buscar el producto
        Producto producto= productoRepo.findById(productoId).orElse(null);
        
        //verificar que el producto esta en el carrito
        Optional<CarritoProducto> carritoProductoExistente= carrito.getProductos().stream()
                .filter(cp -> cp.getProducto().getId().equals(productoId)).findFirst();
        
        if(carritoProductoExistente.isPresent()){
            //Si el producto ya esta el carrito, aumentar la cantidad
            CarritoProducto cp= carritoProductoExistente.get();
            cp.setCantidad(cp.getCantidad()+cantidad);
            carritoProductoRepo.save(cp);
            
        }
        else{
            //si no esta, creamos una nueva relacion CarritoProducto
            CarritoProducto cp= new CarritoProducto();
            cp.setCarrito(carrito);
            cp.setProducto(producto);
            cp.setCantidad(cantidad);
            carritoProductoRepo.save(cp);
        }
        
        return carritoRepo.save(carrito);
        
        
    }
    
    
}
