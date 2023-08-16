
var tipo = prompt("Ingrese el argumento")

let Funciontipo = (tipo) => {

    if (tipo === "true" || tipo === "false") {
        return typeof(true)
    } else if(!isNaN(tipo)) {
        return typeof(1)
    }else{
        return typeof(tipo)
    }

}
    
alert("Su tipo de dato es: " + Funciontipo(tipo))