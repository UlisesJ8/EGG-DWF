var persona ={
nombre,
apellido    
}

function getFormValores() {
    //event.preventDefault(); // Evitar el envío del formulario
  
    var nombreInput = document.querySelector('input[name="nombre"]');
    var apellidoInput = document.querySelector('input[name="apellido"]');
  
    var nombre = nombreInput.value;
    var apellido = apellidoInput.value;
  
    // Puedes hacer lo que quieras con los valores, como mostrarlos en una alerta
    alert("DATOS GUARDADOS! \nNombre: " + nombre + "\nApellido: " + apellido);
  }
