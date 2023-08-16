var op = prompt("----Menu----- \n S. Suma \n R. Resta \n M. Multiplicacion \n D. Division ")

var n1 = prompt("Ingrese el primer numero de la operacion: ")
var n2 = prompt("Ingrese el segundo numero de la operacion: ")




if (op === "S" || op === "s") {
    var resultado = parseInt(n1) + parseInt(n2);
    alert("El resultado de la suma es: " + resultado)
} else if (op === "R" || op === "r"){
    var resultado = parseInt(n1) - parseInt(n2)
    alert("El resultado de la resta es: " + resultado)
}else if (op === "M" || op === "m"){
    var resultado = parseInt(n1) * parseInt(n2)
    alert("El resultado de la multiplicacion es: " + resultado)
}else if(op === "D" || op === "d"){
    if(n2 === "0" ){
        alert("No se puede dividir por 0. Error")
       
    }else{
        var resultado = parseInt(n1) / parseInt(n2)
        alert("El resultado de la division es: " + resultado)
    }
   
}else{
    alert("opcion incorrecta");
}