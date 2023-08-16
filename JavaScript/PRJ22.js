

function muestra2(){
    var text = document.getElementById("exampleInputEmail1")

    var agg = document.getElementById("Agregar-txt")
    
    return agg.textContent = text.value

}

document.getElementById("pinchar").onclick = muestra2;


