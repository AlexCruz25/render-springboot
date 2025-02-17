/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.vale.service;

import com.tienda.vale.model.Carrito;
import com.tienda.vale.model.Cliente;
import com.tienda.vale.repository.ICarritoRepository;
import com.tienda.vale.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository clienteRepo;
    
    @Autowired 
    private ICarritoRepository carritoRepo;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente>listaClientes= clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
        if(cliente.getCarrito()== null){
            Carrito carro= new Carrito();
            carro.setCliente(cliente);//Relacion bidireccional
            cliente.setCarrito(carro);
        }
        
        //Guardar primero el carrito
        carritoRepo.save(cliente.getCarrito());
        clienteRepo.save(cliente);
        
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente= clienteRepo.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void editCliente(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        Cliente cli = this.findCliente(idOriginal);
        cli.setId(idNueva);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setEdad(nuevaEdad);
        
        this.saveCliente(cli);
    }
    
    
    
    
}
