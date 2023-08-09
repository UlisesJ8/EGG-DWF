
// var edad = prompt("Que edad tenes??", 29);

// console.log("Hola estoy en la cosola");

// alert("Hola tu edad es: " + edad);


var persona = {
    apellido:"Fiorde",
    nombre:"Agustin",
    nacimiento : new Date("01-02-1996"),
    dni: 1235343,
    mascotas: [{
        apodo:"chiquito",
        numeroIden : 123456,
        nacimiento : new Date("01-02-2006"),
       }, {
        apodo:"pepe",
        numeroIden : 1245,
        nacimiento : new Date("11-09-2000"),
       }, {
        apodo:"Malva",
        numeroIden : 4576,
        nacimiento : new Date("10-11-2005"),
       }]
};


// var mascota = {
//  apodo:"chiquito",
//  numeroIden : 123456,
//  nacimiento : new Date("01-02-2006"),
// };

class Mascota{
    apodo;
    numeroIdentificatorio;

}

var m = new Mascota();
m.apodo= "Filomena";
m.numeroIdentificatorio = 3456

console.log(m);
console.log(m.apodo);
// console.log(persona.apellido);
// console.log(persona.nacimiento);
// console.log(persona.mascotas[0].apodo);
