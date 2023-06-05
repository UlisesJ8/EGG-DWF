/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpalibreria.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Basic
    private String nombre;
    @Transient
    private boolean alta;

    public Autor() {
    }


    public Autor(String nombre) {
        this.nombre = nombre;
    }
    

    public Autor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Autor(boolean alta) {
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = true;
    }
    
  
  

    @Override
    public String toString() {
        return "Autor:" + "id=" + id + ", nombre=" + nombre ;
    }
    
    
    
    
}
