var limite = prompt("Ingrese el valor limite positivo que desee: ")
var suma = 0;
do{
    var numero = prompt("Ingrese el numero: ")
     suma = suma + parseInt(numero);
}while(limite >= suma)

alert("La suma de los numeros supero el limite inicial de: " + limite + "\n La suma de los numeros ingresados es: " + suma  )