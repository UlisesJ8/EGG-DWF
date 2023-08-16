const Pi = Math.PI;

var circunferencia = prompt("Ingrese el valor de una circunferencia", 1);

let area = Pi * Math.pow((circunferencia/2),2) ;
let perimetro = 2 * Pi * (circunferencia/2);

alert("El area de esa cicunferencia es : " + area + " , El perimetro de esa circunferencia es :" + perimetro);