/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Prj.Noticia.entidades;

import com.Prj.Noticia.enumeraciones.Rol;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String idUsuario, String nombreUsuario, String password, Date fechaDeAlta, Rol rol, Boolean activo) {
        super(idUsuario, nombreUsuario, password, fechaDeAlta, rol, activo);
    }
    
    
    
    
    
    
}
