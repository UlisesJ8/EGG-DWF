
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Editorial;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorios.EditorialRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {
    
    @Autowired
    EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void CrearEditorial(String nombre) throws MiException{
        validar(nombre);
        Editorial editorial = new Editorial();
                
        editorial.setNombre(nombre);
    
        editorialRepositorio.save(editorial);
    }
    
    public List<Editorial> listarEditorial(){
    List<Editorial> editoriales = new ArrayList();
    editoriales = editorialRepositorio.findAll();
    return editoriales;
    
    
    
    }
    
     public void modificarEditorial(String nombre, String id) throws MiException{
         validar(nombre);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }
    
    
    }
     
     public List<Editorial>listarEditoriales() {
        List<Editorial> listaeditorial = new ArrayList<>();
        listaeditorial = editorialRepositorio.findAll();


        return listaeditorial;
    }
     
     public Editorial getOne(String id){
         return editorialRepositorio.getOne(id);
         
     }
     
     
      private void validar(String nombre) throws MiException{
    
     
        
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre del autor no puede ser null o estar vacio");
        }
        
     
    
    
    }
    
     
    
}
