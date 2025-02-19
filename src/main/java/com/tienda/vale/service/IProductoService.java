/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Producto;
import java.util.List;


public interface IProductoService {
    
    //Metodo CRUD
    public List<Producto> getProductos();
    
    public Producto saveProducto(Producto producto);
    
    public void deleteProducto (Long id);
    
    public Producto findProducto(Long id);
    
    public void editProducto(Long idOriginal, Long idNueva, String nuevoNombre, String descripcion, Double precio, int stock,String url);
    
    public Producto guardarProducto(String nombre,String descripcion, double precio, int stock, Long tipoProductoId,String url);
}
