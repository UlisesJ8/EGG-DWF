var array = []
var cont = 0;
    do{
    var num = prompt("Ingrese numeros(si ingresa 0 el programa se detiene): ")
    if(num !== "0"){
        array[cont] = num
        cont = cont + 1 
    }

    }while(num !== "0") 

    var array2 = []
    for(let i = 0; i < cont-2; i++){
        array2 [i] = array[i] 

    }

    var Mensaje = "El array cargado: "

    for(let j = 0; j < cont ; j++){
            Mensaje += array[j] + ", "
    }

    Mensaje = Mensaje + "\n El Array con dos datos menos: "

    for(let k = 0;k < array2.length ; k++){
        Mensaje += array2[k] + ", "
    }

alert(Mensaje)
