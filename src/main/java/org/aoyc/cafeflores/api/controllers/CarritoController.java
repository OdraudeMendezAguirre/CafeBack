/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.List;
import org.aoyc.cafeflores.api.entities.Carrito;
import org.aoyc.cafeflores.api.entities.Usuario;
import org.aoyc.cafeflores.api.repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author ashly
 */
@RestController
@RequestMapping("/api/carrito")
public class CarritoController {
    @Autowired
    CarritoRepository repo;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Carrito getCarrito(@PathVariable int id){
        return repo.findById(id).get();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/crear")
    public Carrito createCarrito(@RequestBody Carrito carrito){
        return repo.saveAndFlush(carrito);
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/update")
    public Carrito updateCarrito(@RequestBody Carrito carrito){
        return repo.save(carrito);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<Carrito> getCarritos(){
        return repo.findAll();
    }
}
