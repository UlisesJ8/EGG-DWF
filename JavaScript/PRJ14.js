var libro = {
ISBN: '',
titulo: '',
autor: '',
Np: 0,


cargarLibro : function(){
this.ISBN = prompt("Ingrese el ISBN: "),
this.titulo = prompt("Ingrese el titulo del libro: "),
this.autor = prompt("Ingrese el nombre del autor"),
this.Np = parseInt(prompt("Ingrese el numero de paginas"))

},

MostrarLibro: function(){
    alert("Mostrando Libro cargado: \n ISBN: " + libro.ISBN + " \n Titulo: " + libro.titulo + "\n Autor: " + libro.autor + "\n Numero de Paginas: " + libro.Np )
}

}


libro.cargarLibro()
libro.MostrarLibro()