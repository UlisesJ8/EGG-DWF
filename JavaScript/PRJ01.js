


var tiempo = prompt("Como estara el dia hoy? \n 1. Soleado \n 2. Nublado \n 3. Lluvioso  \n 4. Nevado  \n 5. Ventoso \n 6. Despejado", 1)
switch(tiempo){
    case "1":
        tiempo = "Soleado"
        break;
        case "2":
            tiempo = "Nublado"
            break;
            case "3":
                tiempo = "Lluvioso"
                break;
                case "4":
                    tiempo = "Nevado"
                    break;
                    case "5":
                        tiempo = "Ventoso"
                        break;
                        case "6":
                            tiempo = "Despejado"
                            break;
                         default:
                            alert("Ingreso una opcion incorrecta.")
                            break;

}


console.log("El dia de hoy esta " + tiempo)
alert("El dia de hoy esta " + tiempo)

