/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.aoyc.cafeflores.api.services;

import java.util.List;
import org.aoyc.cafeflores.api.dtos.ProductosDTO;

/**
 *
 * @author odraude
 */
public interface ProductoService {
    public ProductosDTO guardarProductos(ProductosDTO prodDTO);
    
    public List<ProductosDTO>obtenerTodos();
    
    public ProductosDTO obtenerById(int id);
    
    public  ProductosDTO actualizarProducto( ProductosDTO prodDTO,int id);
    
    public void eliminarProducto(int id);
}
