
package com.Prj.Noticia.entidades;

import com.Prj.Noticia.enumeraciones.Rol;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("periodista")
public class Periodista extends Usuario{
    
    private ArrayList<Noticia> misNoticias; 
    private Integer sueldoMensual;

    public Periodista() {
    }

    public Periodista(ArrayList<Noticia> misNoticias, Integer sueldoMensual) {
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public Periodista(ArrayList<Noticia> misNoticias, Integer sueldoMensual, String idUsuario, String nombreUsuario, String password, Date fechaDeAlta, Rol rol, Boolean activo) {
        super(idUsuario, nombreUsuario, password, fechaDeAlta, rol, activo);
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public ArrayList<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(ArrayList<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    
    
    
    
}
