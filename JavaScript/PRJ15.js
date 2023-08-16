const PI = Math.PI

Circulo = {
    radio:0,
   

    cargarDatos: function(){
        this.radio = parseFloat(prompt("Ingrese el radio del circulo"))
    },    


    perimetro: function (){
       return 2 * PI * this.radio
    },


    area: function() {
        return PI * Math.pow(this.radio, 2)

    },
    
    mostrarDatos: function() {
        const per = this.perimetro()
        const ar = this.area()
        alert("El area del circulo es : " + ar + "\n El perimetro del circulo es: " + per)

    }

}

Circulo.cargarDatos()
Circulo.mostrarDatos()