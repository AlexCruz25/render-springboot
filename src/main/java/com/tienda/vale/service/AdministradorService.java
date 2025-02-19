/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Administrador;
import com.tienda.vale.model.Producto;
import com.tienda.vale.repository.IAdministradorRepository;
import com.tienda.vale.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService implements IAdministradorService {
    
    @Autowired
    private IAdministradorRepository adminRepo;
    
    @Autowired 
    private IProductoService productoServ;

    @Override
    public void saveAdministrador(Administrador admin) {
        adminRepo.save(admin);
    }

    @Override
    public void deleteAdministrador(Long id) {
        adminRepo.deleteById(id);
    }

    @Override
    public Administrador findAdministrador(Long id) {
        Administrador admin= adminRepo.findById(id).orElse(null);
        
        return admin;
    }
    
    public  Producto crearProduco(Long adminId, Producto product){
        Administrador admin = adminRepo.findById(adminId).orElse(null);
        
        product.setAdministrador(admin);
        return productoServ.saveProducto(product);
        
       
    }
    
}
