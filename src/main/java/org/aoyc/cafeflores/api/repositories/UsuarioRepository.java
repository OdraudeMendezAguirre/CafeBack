/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.aoyc.cafeflores.api.repositories;

import java.util.Optional;
import org.aoyc.cafeflores.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author odraude
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    public Optional<Usuario> findByEmail(String email);
	
    public Optional<Usuario> findByUsernameOrEmail(String username,String email);

    public Optional<Usuario> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
}
