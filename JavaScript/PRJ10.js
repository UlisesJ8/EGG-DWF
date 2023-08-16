var frase = prompt("Ingrese una frase: ")

let fraseInvertida = (frase) => frase.split('').reverse().join('')

alert("Su frase invertida es: " + fraseInvertida(frase))