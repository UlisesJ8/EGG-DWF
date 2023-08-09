
package com.Prj.Noticia.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Noticia implements Comparable<Noticia>{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2" )
    private String id_noticia;
    
    @Basic
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String cuerpo;
    private Date FechaCarga;
    
    @OneToOne
    private Periodista creador;
    
    public Noticia() {
    }

    public Noticia(String id_noticia, String titulo, String cuerpo, Date FechaCarga) {
        this.id_noticia = id_noticia;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.FechaCarga = FechaCarga;
    }

    public String getId_noticia() {
        return id_noticia;
    }

    public void setId_noticia(String id_noticia) {
        this.id_noticia = id_noticia;
    }

 
   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFechaCarga() {
        return FechaCarga;
    }

    public void setFechaCarga(Date FechaCarga) {
        this.FechaCarga = FechaCarga;
    }

    @Override
    public int compareTo(Noticia otraNoticia) {
        return this.FechaCarga.compareTo(otraNoticia.getFechaCarga());
    }
    
   
    }
    
    
    

