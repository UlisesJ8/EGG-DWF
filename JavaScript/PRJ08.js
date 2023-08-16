var promedio = 0, cont = 0;

do{
var num = prompt("Ingrese numeros(si ingresa 0 el programa se detiene): ")
if(cont == 0){
   var max = num
   var min = num
}

if(num > max){
    max = num
}

if(num < min && num != "0"){
    min = num
}

promedio = promedio + parseInt(num)

cont = cont + 1 

}while(num !== "0") 

promedio = promedio / (cont-1);

alert("El numero maximo ingresado es: " + max + "\n El numero minimo ingresado es: "+ min + "\n El promedio de todos los numeros ingresados es: " + promedio)