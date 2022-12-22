/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author odraude
 */
@Entity
@Table(name = "compras_tb")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_compra;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "productos_compra",joinColumns =  @JoinColumn(name = "id_compra",
            referencedColumnName = "id_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_producto",referencedColumnName = "id_producto"))
    private List<Producto> producto;
    
    @ManyToOne()
    @JoinColumn(name = "id_envio")
    Envio envio;
    
    @Column
    int cant_producto;
    
    @Column
    long sub_total;
    
    @Column
    long total;
}
