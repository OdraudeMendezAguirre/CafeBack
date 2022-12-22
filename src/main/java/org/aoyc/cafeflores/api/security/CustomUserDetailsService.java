/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import org.aoyc.cafeflores.api.entities.Rol;
import org.aoyc.cafeflores.api.entities.Usuario;
import org.aoyc.cafeflores.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author odraude
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese username o email : " + username));

        return new User(usuario.getEmail(), usuario.getContrasena(), mapearRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearRoles(Set<Rol> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}
