/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Equipo
 */
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numpaginas;

//    public Libro() {
//    }
//
//    public Libro(String ISBN, String titulo, String autor, int numpaginas) {
//        this.ISBN = ISBN;
//        this.titulo = titulo;
//        this.autor = autor;
//        this.numpaginas = numpaginas;
//    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(int numpaginas) {
        this.numpaginas = numpaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", numpaginas=" + numpaginas + '}';
    }
    

            
            
}
