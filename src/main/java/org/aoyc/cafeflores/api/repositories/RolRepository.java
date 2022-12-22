/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.aoyc.cafeflores.api.repositories;

import java.util.Optional;
import org.aoyc.cafeflores.api.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author odraude
 */
public interface RolRepository extends JpaRepository<Rol, Integer>{
    public Optional<Rol> findByNombre(String nombre);
}
