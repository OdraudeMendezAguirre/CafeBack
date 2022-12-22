/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author odraude
 */
@Entity
@Table(name = "informacion_empresarial_tb")
public class InfoEmpr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_informacion;
    
    @Column
    private String descripcion;
    
    @Column
    private String imagen;

    public int getId_informacion() {
        return id_informacion;
    }

    public void setId_informacion(int id_informacion) {
        this.id_informacion = id_informacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
