/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    //Metodos CRUD
    public List <Cliente> getClientes();
    
    public void saveCliente (Cliente cliente);
    
    public void deleteCliente (Long id);
    
    public Cliente findCliente (Long id);
    
    public void editCliente (Long idOriginal, Long idNueva, String nuevoNombre,
                            String nuevoApellido, int nuevaEdad);
    
}
