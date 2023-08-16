var arregloA = []
var arregloB = []

for (let i = 0; i < 50; i++) {
    arregloA[i] = Math.floor(Math.random() * 100)

}
alert("Arreglo A: " + arregloA)

function compare(a, b) {
if (a < b) return -1
if (a == b) return 1
if (a > b) return 1

}

arregloA = arregloA.sort(compare)

for (let j = 0; j < 20; j++){

    if (j < 10) {
        arregloB[j] = arregloA[j]
    }else{
        arregloB[j] = 0.5
    }

    


}

alert("Arreglo A: " + arregloA + "\n Arreglo B: " + arregloB)