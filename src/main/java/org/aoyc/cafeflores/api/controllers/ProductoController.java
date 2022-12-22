/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.aoyc.cafeflores.api.dtos.ProductosDTO;
import org.aoyc.cafeflores.api.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author odraude
 */

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService prodSer;

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProductosDTO> guardarProducto(@Valid @RequestBody ProductosDTO prodDTO) {
        return new ResponseEntity<>(prodSer.guardarProductos(prodDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<ProductosDTO> listarProducto() {
        return prodSer.obtenerTodos();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ProductosDTO> obtenerById(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(prodSer.obtenerById(id));
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductosDTO> actualizarProducto(@Valid @RequestBody ProductosDTO prodDTO, @PathVariable(name = "id") int id) {

        ProductosDTO prodResp = prodSer.actualizarProducto(prodDTO, id);
        return new ResponseEntity<>(prodResp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable(name = "id") int id) {

        prodSer.eliminarProducto(id);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);

    }

}
