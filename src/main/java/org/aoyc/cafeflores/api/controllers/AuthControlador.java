/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.Collections;
import java.util.List;
import org.aoyc.cafeflores.api.dtos.LoginDTO;
import org.aoyc.cafeflores.api.dtos.RegistroDTO;
import org.aoyc.cafeflores.api.entities.Rol;
import org.aoyc.cafeflores.api.entities.Usuario;
import org.aoyc.cafeflores.api.repositories.RolRepository;
import org.aoyc.cafeflores.api.repositories.UsuarioRepository;
import org.aoyc.cafeflores.api.security.JWTAuthResonseDTO;
import org.aoyc.cafeflores.api.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author odraude
 */
@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/iniciarSesion")
    public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);

        return ResponseEntity.ok(new JWTAuthResonseDTO(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody RegistroDTO registroDTO) {
        if (usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setUsername(registroDTO.getUsername());
        usuario.setNombre_completo(registroDTO.getNombre_completo());
        usuario.setTelefono(registroDTO.getTelefono());
        usuario.setEmail(registroDTO.getEmail());
        usuario.setContrasena(passwordEncoder.encode(registroDTO.getContrasena()));
        usuario.setSpam(registroDTO.isSpam());
        Rol roles = rolRepositorio.findByNombre("ROLE_USER").get();
        usuario.setRoles(Collections.singleton(roles));
        
        usuario.setCarrito(registroDTO.getCarrito());
        usuario.setEnvio(registroDTO.getEnvio());
        
        return usuarioRepositorio.saveAndFlush(usuario);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/user")
    public Usuario getUsuario(@RequestBody LoginDTO loginDTO) {
        return usuarioRepositorio.findByEmail(loginDTO.getUsernameOrEmail()).get();
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/act")
    public Usuario actUsuario(@RequestBody Usuario user) {
        return usuarioRepositorio.saveAndFlush(user);
    }
    
}
