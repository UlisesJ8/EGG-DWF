var valores = [true, 5, false, "hola", "adios", 2]
var string =[]
var boolean =[]
var number = []
var contS = 0, contN = 0, contB = 0

for (let i = 0; i < valores.length; i++) {
    
    if (isNaN(valores[i]) && valores[i] != "true" && valores[i] != "false" && typeof valores[i] !== "boolean") {
        string[contS] = valores[i] 
        contS++
    }else if (!isNaN(valores[i]) && valores[i] != "true" && valores[i] != "false" && typeof valores[i] !== "boolean") {
        number[contN] = valores[i] 
        contN++

    }else{
        boolean[contB] = valores[i] 
        contB++

    }


    
}

console.log(string)
console.log(boolean)
console.log(number)

var largo = ''

for (let j = 0; j < string.length; j++) {
    
    if (string[j].length > largo.length) {
        largo = string[j]
    }
    
}

alert("El texto mas largo del array es: " + largo)

var mensajeBool = "Los booleanos presentes en el array son : "

for (let m = 0; m < boolean.length; m++) {
    mensajeBool += boolean[m] + ", "
    
}

alert(mensajeBool)

var suma=0, resta=0, division=0, multi=1, pot=1

for (let n = 0; n < number.length; n++) {
    
    if (n === 0) {
        suma = number[n]
        resta = number[n]
        division = number[n]
        multi = number[n]
        pot = number[n]
    } else {
        suma += number[n]
        resta -= number[n]
        division = division / number[n]
        multi = multi * number[n]
        pot = Math.pow(pot, number[n])
    }
}

alert("Suma: " + suma + "\n Resta: " + resta + "\n Division: " + division + "\n Multiplicacion: " + multi + "\n Potencia: " + pot)