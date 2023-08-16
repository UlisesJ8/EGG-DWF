
var matriz3 = []

for (let i = 0; i < 5; i++) {
    matriz3[i] = (i+1) * 3
    
}

alert("Matriz: " + matriz3)

matriz3.shift()
var multi
while(matriz3.length < 5){
    multi = (matriz3.length+2) * 3
    matriz3[matriz3.length-1] = (matriz3.length+1) * 3
    matriz3.push(multi)
}


alert("Matriz: " + matriz3)