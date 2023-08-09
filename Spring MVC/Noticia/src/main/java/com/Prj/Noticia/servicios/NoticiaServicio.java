
package com.Prj.Noticia.servicios;

import com.Prj.Noticia.entidades.Noticia;
import com.Prj.Noticia.excepciones.MiException;
import com.Prj.Noticia.repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServicio {
    
    @Autowired
    NoticiaRepositorio noticiaRepositorio;
    
   @Transactional
    public void CrearNoticia(String titulo, String cuerpo) throws MiException{
        validar(titulo, cuerpo);
        
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setFechaCarga(new Date());
        noticiaRepositorio.save(noticia);
    }
    
    
    @Transactional(readOnly = true)
    public Noticia getOne(String id_noticia){
        return noticiaRepositorio.getOne(id_noticia);
    }
    
    @Transactional(readOnly = true)
    public List<Noticia> listaNoticias(){
    
        List<Noticia>listaNoticias = new ArrayList<>();
        listaNoticias = noticiaRepositorio.findAll();
        
        
        // Se crea una collection sort y se ordena por fecha de carga de la noticia
        Collections.sort(listaNoticias, new Comparator<Noticia>() {
            @Override
            public int compare(Noticia noticia1, Noticia noticia2) {
                return noticia1.getFechaCarga().compareTo(noticia2.getFechaCarga());
            }
        });
       
   
        return listaNoticias;
    } 
    
    @Transactional
    public void Modificar(String id_noticia, String titulo, String cuerpo) throws Exception{
        validar(titulo, cuerpo);
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id_noticia);
    
        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setFechaCarga(new Date());
            noticiaRepositorio.save(noticia);
        }
    
    
    }
    
    @Transactional
    public void eliminar(String id_noticia) throws Exception{
    Noticia noticia = noticiaRepositorio.getById(id_noticia);
    noticiaRepositorio.delete(noticia);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void validar(String titulo, String cuerpo) throws MiException{
    
     if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo no puede estar vacio o ser nulo");
        }
        
        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("El cuerpo no puede ser nulo o estar vacio");
        }
        
        
        
    
    
    }
    
    
    
    
   
    
    
}
