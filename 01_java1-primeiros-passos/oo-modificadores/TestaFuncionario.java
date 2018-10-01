class Funcionario{
	String nomeFuncionario;
	String departamento;
	double salario=0.0;
	Data dataEntrada=new Data();
	String rg;
	
	boolean descontaSalario(double valorDesconto){
		if(salario>valorDesconto){
			this.salario -=valorDesconto;
			return true;
		}else{
			return false;
		}
	}
	void recebeAumento(double valorAumento){
		this.salario +=valorAumento;
	}
	double calculaGanhoAnual(){
		return this.salario*12;
	}
	
	void mostraDadosFuncionario(){
		System.out.println("Nome : " + this.nomeFuncionario 
							+"\nDepartamento :"+ this.departamento
							+"\nSalario :"+ this.salario
							+"\nData de Entrada :"+this.dataEntrada.getFormatada()
							//+"\nData de Entrada :"+ this.dataEntrada.dia+"/"
							//+this.dataEntrada.mes+"/"+this.dataEntrada.ano
							+"\nRegisto Geral :"+ this.rg);
	
	}
}


class Data{
	int dia, mes, ano;
	void data(int dia, int mes, int ano){
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
		
	}
	
	String getFormatada(){
		return this.dia+"/"+this.mes+"/"+this.ano;
	}

}


class TestaFuncionario{
	public static void main (String [] args){
		Funcionario funcionario=new Funcionario();
		Funcionario funcionario2=new Funcionario();
		Funcionario funcionario3=new Funcionario();
		Funcionario funcionario4=funcionario;
		Data dataEntrada=new Data();
		
		funcionario.nomeFuncionario="Rachid Mavulule";
		funcionario.departamento="TICs";
		funcionario.salario=20000;
		funcionario.dataEntrada.data(12,12,2017);
		funcionario.rg="123456789B";
		
		funcionario2.nomeFuncionario="Rachid Mavulule";
		funcionario2.departamento="TICs";
		funcionario2.salario=20000;
		funcionario2.dataEntrada.data(12,12,2017);
		funcionario2.rg="123456789B";

		funcionario3.nomeFuncionario="Joao Cossa";
		funcionario3.departamento="RH";
		funcionario3.salario=10000;
		funcionario3.dataEntrada.data(10,11,2017);
		funcionario3.rg="987654321B";
		
		funcionario4.nomeFuncionario="Joao Cossa";
		funcionario4.departamento="RH";
		funcionario4.salario=10000;
		funcionario4.dataEntrada.data(10,11,2017);
		funcionario4.rg="987654321B";

		
		System.out.println("Salario actual: " + funcionario.salario);
		
		funcionario.recebeAumento(15000);
		System.out.println("Salario depois do aumento: " + funcionario.salario);
		System.out.println("Ganho anual: " + funcionario.calculaGanhoAnual());
		
		boolean conseguiDescontar=funcionario.descontaSalario(360);
		if (conseguiDescontar==true){
			System.out.println("Salario descontado. Salario depois do desconto : " + funcionario.salario);
		}else{
			System.out.println("Não foi possivel descontar. Desconto maior que salario actual");			
		}
	
		funcionario2.mostraDadosFuncionario();
		
		//comparar funcionarios
		if(funcionario==funcionario2){
			System.out.println("funcionario igual a funcionario2. Eles tem referencias direfentes e valores de atributos iguais.");						
		}else{
			//verdade
			System.out.println("funcionario diferente a funcionario2. Eles tem referencias direfentes e valores de atributos iguais.");									
		}
		
		if(funcionario==funcionario3){
			System.out.println("funcionario igual a funcionario3. Eles tem referencias direfentes e valores de atributos diferentes.");						
		}else{
			//verdade
			System.out.println("funcionario diferente a funcionario3. Eles tem referencias direfentes e valores de atributos diferentes.");									
		}
		
		if(funcionario==funcionario4){
			//verdade
			System.out.println("funcionario igual a funcionario4. Eles tem referencias iguais e valores de atributos diferentes.");						
		}else{
			System.out.println("funcionario diferente a funcionario4. Eles tem referencias iguais e valores de atributos diferentes.");									
		}

	}
}

