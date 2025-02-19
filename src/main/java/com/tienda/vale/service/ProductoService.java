/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Administrador;
import com.tienda.vale.model.Producto;
import com.tienda.vale.model.TipoProducto;
import com.tienda.vale.repository.IAdministradorRepository;
import com.tienda.vale.repository.IProductoRepository;
import com.tienda.vale.repository.ITipoProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Autowired
    private ITipoProductoRepository tipoProductoRepo;
    
    @Autowired
    private IAdministradorRepository adminRepo;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos= productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto saveProducto(Producto producto) {
        productoRepo.save(producto);
        return producto;
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto= productoRepo.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Long idOriginal, Long idNueva, String nuevoNombre, String descripcion, Double precio, int stock,String url) {
        Producto product = this.findProducto(idNueva);
        product.setId(idNueva);
        product.setNombre(nuevoNombre);
        product.setDescripcion(descripcion);
        product.setPrecio(precio);
        product.setStock(stock);
        product.setUrl(url);
        
        this.saveProducto(product);
        
    }

    @Override
    public Producto guardarProducto(String nombre,String descripcion, double precio, int stock,String url, Long tipoProductoId) {
        TipoProducto tipo= tipoProductoRepo.findById(tipoProductoId).orElse(null);
        Administrador admin= adminRepo.findById(tipoProductoId).orElse(null);
        
        if(tipo==null || admin== null){
            throw new RuntimeException("Tipo de producto o administrador no encontrado");
        }
        
        Producto producto= new Producto(null,nombre,descripcion,precio,stock,url,tipo,admin);
        return productoRepo.save(producto);
    }
    
    
}
