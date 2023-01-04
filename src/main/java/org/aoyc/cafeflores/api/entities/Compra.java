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
    long sub_total;
    
    @Column
    long total;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public long getSub_total() {
        return sub_total;
    }

    public void setSub_total(long sub_total) {
        this.sub_total = sub_total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
