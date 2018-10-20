var buscaPaciente=document.querySelector("#busca-paciente");
buscaPaciente.addEventListener("click", function(event){
	//event.preventDefault();

	var erro=document.querySelector("#erro-carega-paciente");
	var xhr=new XMLHttpRequest();
	xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");
		xhr.addEventListener("load", function(){
			if(xhr.status==200){
				var resposta=xhr.responseText;

				var pacientes=JSON.parse(resposta);

				pacientes.forEach(function(paciente){
					adicionaPacienteNaTabela(paciente);
				});
				erro.classList.add("invisivel");
			}else{
				erro.classList.remove("invisivel");
			}
		});
	xhr.send();
})