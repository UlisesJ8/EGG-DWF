var frase = prompt("Ingrese una frase")

let cadenaLarga = (frase) => {
    var array = frase.split(' ')  
    var palabraLarga = ''

    array.forEach(palabra => {
        if(palabra.length > palabraLarga.length){
            palabraLarga = palabra
        }

    })
    return palabraLarga
}

var fraseLarga = cadenaLarga(frase)

alert("La palabra mas larga es: " + fraseLarga)