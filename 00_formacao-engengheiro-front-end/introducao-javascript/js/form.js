var botaoAdiciona=document.querySelector("#adicionar-paciente");

botaoAdiciona.addEventListener("click",funcAdicionaPaciente);

function funcAdicionaPaciente(event){
	event.preventDefault();
	var form=document.querySelector("#form-adiciona");

	//obter dados do formulario e montar paciente
	var paciente=obtemDadosDoPaciente(form);

	//criar td e tr do paciente
	var pacienteTr=montaTr(paciente);
	//adiciona tr na tabela
	var tBody = document.querySelector("#tabela-pacientes");
	tBody.appendChild(pacienteTr);

	form.reset();
}

function obtemDadosDoPaciente(form){
	var paciente = {
		nome: form.nome.value,
		peso: form.peso.value,
		altura: form.altura.value,
		gordura: form.gordura.value,
		imc: calculaImc(form.peso.value,form.altura.value)
	}

	return paciente;
}

function montaTr(paciente){
	/*var nomeTd=document.createElement('td');
	var pesoTd=document.createElement('td');
	var alturaTd=document.createElement('td');
	var gorduraTd=document.createElement('td');
	var imcTd=document.createElement('td');

	nomeTd.textContent=paciente.nome;
	pesoTd.textContent=paciente.peso;
	alturaTd.textContent=paciente.altura;
	gorduraTd.textContent=paciente.gordura;
	imcTd.textContent=paciente.imc;*/

	var pacienteTr=document.createElement('tr');
	pacienteTr.classList.add("paciente");

	pacienteTr.appendChild(montaTd(paciente.nome,"info-nome"));
	pacienteTr.appendChild(montaTd(paciente.peso,"info-peso"));
	pacienteTr.appendChild(montaTd(paciente.altura,"info-altura"));
	pacienteTr.appendChild(montaTd(paciente.gordura,"info-gordura"));
	pacienteTr.appendChild(montaTd(paciente.imc,"info-imc"));

	return pacienteTr;

}

function montaTd(dado,classe){
	var td=document.createElement('td');
	td.textContent=dado;
	td.classList.add(classe);
	return td;
}