/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.aoyc.cafeflores.api.repositories;

import org.aoyc.cafeflores.api.entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ashly
 */
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
    
}
