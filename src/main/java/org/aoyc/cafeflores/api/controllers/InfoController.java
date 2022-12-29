/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.List;
import org.aoyc.cafeflores.api.entities.Envio;
import org.aoyc.cafeflores.api.entities.InfoEmpr;
import org.aoyc.cafeflores.api.repositories.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author odraude
 */
@RestController
@RequestMapping("/api/info")
public class InfoController {
    @Autowired
    InfoRepo repo;
    
    @CrossOrigin(origins = "*")
    @GetMapping
    public InfoEmpr info() {
        return repo.findById(1).get();
    }
   
    
}
