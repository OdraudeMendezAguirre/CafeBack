/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.List;
import org.aoyc.cafeflores.api.entities.Compra;
import org.aoyc.cafeflores.api.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashly
 */
@RestController
@RequestMapping("/api/compra")
public class CompraController {
    @Autowired
    CompraRepository repo;
    
    @CrossOrigin(origins = "*")
    @PostMapping()
    public Compra guardarCompra(@RequestBody Compra compra){
        return repo.save(compra);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<Compra> getCompras(){
        return repo.findAll();
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping()
    public Compra putCompra(@RequestBody Compra compra){
        return repo.save(compra);
    }
    
}
