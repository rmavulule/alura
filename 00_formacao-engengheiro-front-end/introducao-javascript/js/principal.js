console.log("oi mundo");
var titulo=document.querySelector(".titulo");
console.log(titulo);
console.log(titulo.textContent);
titulo.textContent="Aparecida Nutricista";

var pacientes=document.querySelectorAll(".paciente");
for (var i = 0; i<pacientes.length; i++) {
	var paciente=pacientes[i];
	var peso=paciente.querySelector(".info-peso").textContent;
	var altura=paciente.querySelector(".info-altura").textContent;

	var tdPesoInvalido=false;
	var tdAlturaInvalida=false;

	if (peso<0||peso>1000) {
		tdPesoInvalido=true;
		paciente.querySelector(".info-imc").textContent="Peso invalido";
		paciente.classList.add("paciente-invalido");
	}
	if(altura<0||altura>3){
		tdAlturaInvalida=true;
		paciente.querySelector(".info-imc").textContent="Altura invalida";
		paciente.classList.add("paciente-invalido");
	}
	if (!tdAlturaInvalida && !tdPesoInvalido) {
		var imc= peso / (altura * altura);
		paciente.querySelector(".info-imc").textContent=imc.toFixed(2);
	}
}