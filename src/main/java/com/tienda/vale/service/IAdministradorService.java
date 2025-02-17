/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Administrador;


public interface IAdministradorService {
    // Metodos CRUD
    public void saveAdministrador (Administrador admin);
    
    public void deleteAdministrador (Long id);
    
    public Administrador findAdministrador(Long id);
}
