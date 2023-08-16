var text = document.getElementById("exampleFormControlTextarea1")
var fondo = document.getElementById("fondo")

text.addEventListener("input", function(){
    var palabras = text.value.split(" ")
    var nuevoContenido = ""

    for (let i = 0; i < palabras.length; i++) {

        if (palabras[i].length > 8)   {
            nuevoContenido += `<span style="background-color: #FFFF33">${palabras[i]}</span>`
        }else{
            nuevoContenido += palabras[i]
        }

        if (i < palabras.length - 1) {
            nuevoContenido += " "; 
        }
        
    }

    fondo.innerHTML = nuevoContenido
    
})
