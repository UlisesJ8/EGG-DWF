
package com.egg.Biblioteca.servicios;

import com.egg.Biblioteca.entidades.Autor;
import com.egg.Biblioteca.entidades.Editorial;
import com.egg.Biblioteca.entidades.Libro;
import com.egg.Biblioteca.excepciones.MiException;
import com.egg.Biblioteca.repositorios.AutorRepositorio;
import com.egg.Biblioteca.repositorios.EditorialRepositorio;
import com.egg.Biblioteca.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer Ejemplares, String idAutor, String idEditorial) throws MiException{
    
        validar(isbn, titulo, Ejemplares, idAutor, idEditorial);
        
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        Autor autor = new Autor();
        Editorial editorial= new Editorial();
        
        if(respuestaAutor.isPresent()){
            
            autor = respuestaAutor.get();
        }
        
        if(respuestaEditorial.isPresent()){
            
            editorial = respuestaEditorial.get();
        }
      
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(Ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
       libroRepositorio.save(libro);
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Libro> listarLibros(){
    
    List<Libro> libros = new ArrayList<>();
    
    libros = libroRepositorio.findAll();
    
    return libros;
    
    
    
    }
    
    public Libro getOne(Long isbn){
    return libroRepositorio.getOne(isbn);
    
    }
    
    
    public void modificarLibro(Long isbn, String titulo, Integer Ejemplares, String idAutor, String idEditorial) throws MiException{
        
        validar(isbn, titulo, Ejemplares, idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> resputaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        
        if(resputaAutor.isPresent()){
        autor = resputaAutor.get();
        }
        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();
        }
        
        
        
        
        
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(Ejemplares);
            libroRepositorio.save(libro);
            
        } 
    
    
    
    
    }
    
    
    private void validar(Long isbn, String titulo, Integer Ejemplares, String idAutor, String idEditorial) throws MiException{
    
     if (isbn ==null) {
            throw new MiException("El isbn no puede ser null");
        }
        
        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo no puede ser nulo o estar vacio");
        }
        
         if (Ejemplares == null) {
            throw new MiException("Ejemplares no puede ser null");
        }
         
         if (idAutor.isEmpty() || idAutor ==null) {
            throw new MiException("El id autor no puede ser null");
        }
         if (idEditorial.isEmpty() || idEditorial ==null) {
            throw new MiException("El id Editorial no puede ser null");
        }
        
    
    
    }
    
    
    
    
}
