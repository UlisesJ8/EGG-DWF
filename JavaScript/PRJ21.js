var nombre = prompt("Ingrese su nombre: ")
var validar = true;
do{
var edad = prompt("Ingrese su edad: ")
if(isNaN(edad)){
    validar = false
}else{
    validar = true
}

}while(validar === false)

do{
    var sexo = prompt("Ingrese su sexo(M. Mujer, H. Hombre, O. Otro): ")
    if(sexo != "M" && sexo != "H" && sexo != "O"){
        validar = false
    }else{
        if (sexo == "M") {
            sexo = "Mujer"
        } else if (sexo == "H"){
            sexo = "Hombre"
        }else {
            sexo = "Otro"

        }


        validar = true
    }
    
}while(validar === false)

do{
    var peso = prompt("Ingrese su peso: ")
    if(isNaN(peso)){
        validar = false
    }else{
    validar = true
    }
    
}while(validar === false)

do{
    var altura= prompt("Ingrese su altura: ")
    if(isNaN(altura)){
        validar = false
    }else{
    validar = true
    }
    
}while(validar === false)


var persona = {
nombre : nombre,
edad : edad,
sexo : sexo,
peso : peso,
altura : altura
}

alert("Sus datos son: " + "\n Nombre: " + persona.nombre +  "\n Edad: " + persona.edad + "\n Sexo: " + persona.sexo  + "\n Peso: " + persona.peso  +"\n Altura: " + persona.altura)