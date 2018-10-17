console.log("oi mundo");
var titulo=document.querySelector(".titulo");
console.log(titulo);
console.log(titulo.textContent);
titulo.textContent="Aparecida Nutricista";

var paciente=document.querySelector("#primeiro-paciente");
var peso=paciente.querySelector(".info-peso").textContent;
var altura=paciente.querySelector(".info-altura").textContent;
var imc= peso / (altura * altura);
paciente.querySelector(".info-imc").textContent=imc;
console.log(peso + " - " + altura + " - " + imc);