const PI = Math.PI
function muestra(event){
    event.preventDefault()
    var text = document.getElementById("exampleInputEmail1")
    var num = parseFloat(text.value)
    var radio = num / 2
    var Radio = document.getElementById("Radio")
    return Radio.textContent = "Radio: " + radio

}

document.getElementById("Calcular").addEventListener("click", muestra) = muestra;