let Arr1 = []
let Arr2 = []

for(let i = 0; i < 5; i++){
    Arr1[i] = Math.floor(Math.random() * 100),
    Arr2[i] = Math.floor(Math.random() * 100)
}

let vector1 = "Vector 1 : "  

for(let j = 0; j < 5; j++){        
        vector1 += Arr1[j] + ", "
    }  

let vector2 = "\n Vector 2: " 

for(let k = 0; k < 5; k++){        
       vector2 += Arr2[k] + ", "
    }

let vectores = vector1 + vector2

    alert("Los vectores son: \n" + vectores)

