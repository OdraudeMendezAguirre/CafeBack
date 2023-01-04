/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.List;
import java.util.Optional;
import org.aoyc.cafeflores.api.entities.Envio;
import org.aoyc.cafeflores.api.entities.Usuario;
import org.aoyc.cafeflores.api.repositories.EnvioRepository;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/envio")
public class EnvioController {
    
    @Autowired
    EnvioRepository repo;
    
    
    @CrossOrigin(origins = "*")
    @PostMapping("/guardar")
    public Envio guardarEnvio(@RequestBody Envio envio){
        return repo.saveAndFlush(envio);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Envio> getEnvios(){
        return repo.findAll();
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Envio getEnvio(@PathVariable int id){
        return repo.findById(id).get();
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/act")
    public Envio putEnvios(@RequestBody Envio envio){
        return repo.save(envio);
    }
    
}
