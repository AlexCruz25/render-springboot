/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.vale.repository;

import com.tienda.vale.model.Carrito;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICarritoRepository extends JpaRepository <Carrito, Long>{
    Optional<Carrito> findByClienteId(Long clienteId);
}
