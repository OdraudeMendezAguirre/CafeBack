/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aoyc.cafeflores.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author odraude
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private long valorDelCampo;

    public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(String.format("%s no encontrada con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }


}
