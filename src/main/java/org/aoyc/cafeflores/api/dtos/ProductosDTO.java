/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author odraude
 */
public class ProductosDTO {
    private int id_producto;
    
    @NotEmpty
    @Size(max = 30, message ="El  articulo deberia tener mas de 2 caracteres")
    private String articulo;
    
    @NotEmpty
    private long precio;
    
    @NotEmpty
    @Size(min = 10, message ="La descripcion deberia tener al menos 10 caracteres")
    private String descripcion;
    
    @NotEmpty
    private int disponibilidad;
    
    @NotEmpty
    private String imagen;
    
    public ProductosDTO() {
        super();
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
