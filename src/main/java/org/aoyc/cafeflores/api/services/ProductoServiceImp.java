/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.services;

import java.util.List;
import java.util.stream.Collectors;
import org.aoyc.cafeflores.api.dtos.ProductosDTO;
import org.aoyc.cafeflores.api.entities.Producto;
import org.aoyc.cafeflores.api.exceptions.ResourceNotFoundException;
import org.aoyc.cafeflores.api.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author odraude
 */
@Service
public class ProductoServiceImp implements ProductoService{
    
    @Autowired
    private ProductoRepository prodRepo;

    @Override
    public ProductosDTO guardarProductos(ProductosDTO prodDTO) {
        Producto producto = mapearEntidad(prodDTO);
        Producto nuevoProducto = prodRepo.save(producto);
        return mapearDTO(nuevoProducto);
    }

    @Override
    public List<ProductosDTO> obtenerTodos() {
        List<Producto> productos = prodRepo.findAll();
        return productos.stream().map(producto -> mapearDTO(producto)).collect(Collectors.toList());
    }

    @Override
    public ProductosDTO obtenerById(int id) {
        Producto producto = prodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
        return mapearDTO(producto);
    }

    @Override
    public ProductosDTO actualizarProducto(ProductosDTO prodDTO, int id) {
        Producto producto = prodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));

        producto.setId_producto(prodDTO.getId_producto());
        producto.setArticulo(prodDTO.getArticulo());
        producto.setDescripcion(prodDTO.getDescripcion());
        producto.setDisponibilidad(prodDTO.getDisponibilidad());
        producto.setImagen(prodDTO.getImagen());
        producto.setPrecio(prodDTO.getPrecio());
        Producto prodact = prodRepo.save(producto);
        return mapearDTO(prodact);
    }

    @Override
    public void eliminarProducto(int id) {
        Producto producto = prodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("producto", "id", id));

        prodRepo.delete(producto);
    }
    
    private ProductosDTO mapearDTO(Producto producto) {
        ProductosDTO empDTO = new ProductosDTO();
        empDTO.setId_producto(producto.getId_producto());
        empDTO.setArticulo(producto.getArticulo());
        empDTO.setDescripcion(producto.getDescripcion());
        empDTO.setDisponibilidad(producto.getDisponibilidad());
        empDTO.setImagen(producto.getImagen());
        empDTO.setPrecio(producto.getPrecio());

        return empDTO;
    }
    
    private Producto mapearEntidad(ProductosDTO prodDTO){
        Producto producto = new Producto();
        
        producto.setId_producto(prodDTO.getId_producto());
        producto.setArticulo(prodDTO.getArticulo());
        producto.setDescripcion(prodDTO.getDescripcion());
        producto.setDisponibilidad(prodDTO.getDisponibilidad());
        producto.setImagen(prodDTO.getImagen());
        producto.setPrecio(prodDTO.getPrecio());
        
        return producto;
    }
    
}
