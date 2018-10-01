
class Empresa{
	private String nomeEmpresa;
	private String cnpj;
	private Funcionario[] funcionarios;
	
	public Empresa(){	
	}
	
	public Empresa(int tamanhoArrayFuncionarios){
		this.funcionarios=new Funcionario[tamanhoArrayFuncionarios];
	}
	
	public void setNomeEmpresa(String nomeEmpresa){
		this.nomeEmpresa=nomeEmpresa;
	}
	public void setCnpj(String cnpj){
		this.cnpj=cnpj;
	}
	public void setFuncionarios(Funcionario[] funcionarios){
		this.funcionarios=funcionarios;
	}
		
	public void setFuncionario(int i, Funcionario f){
		this.funcionarios[i]=f;
	}
	
	public String getNomeEmpresa(){
		return this.nomeEmpresa;
	}
	public String getCnpj(){
		return this.cnpj;
	}
	public Funcionario[] getFuncionarios(){
		return this.funcionarios;
	}

	public Funcionario getFuncionario(int i){
		return this.funcionarios[i];
	}

	
	/**
	*Adicionar funcionário numa posicao qualquer
	*/
	boolean adicionaFuncionarioAux(Funcionario[] funcionarios,Funcionario funcionario){
		for(int i=0; i<funcionarios.length;i++){
			Funcionario f=getFuncionario(i);
			if(f==null){
				setFuncionario(i,funcionario);
				return true;
			}
		}
		return false;
	}
	
	/**
	*Adicionar funcionário na posicao correspondente ao pi
	*/
	boolean adicionaFuncionario(Funcionario[] funcionarios,Funcionario funcionario){
		if(funcionarios.length>funcionario.getPi()) {
			if(funcionarios[funcionario.getPi()]==null){
				setFuncionario(funcionario.getPi(),funcionario);
				return true;
			}else if(getFuncionario(funcionario.getPi()).getPi()==funcionario.getPi()){
				return false;
			}else{
				return adicionaFuncionarioAux(funcionarios,funcionario);
			}
		}else{
			return adicionaFuncionarioAux(funcionarios,funcionario);
		}
	}
	
	void listaFuncionarios(Funcionario[] funcionarios){
		for(int i=0; i<funcionarios.length;i++){
			if(getFuncionario(i)==null) continue;
			System.out.println("Salario do funcionario na posicao " + i + ": " + getFuncionario(i).getSalario()
							   +"\nData de Entrada: "+getFuncionario(i).getDataEntrada().getFormatada());
		}
	
	}

	boolean contem(Funcionario funcionario){
		for(Funcionario f : getFuncionarios()){
			if(f==funcionario){
				return true;
			}
		}
		return false;
	}

}

class Funcionario{
	private int pi;
	private String nomeFuncionario;
	private String departamento;
	private double salario=0.0;
	private Data dataEntrada=new Data();
	private String rg;
	private static int identificar;
	
	public Funcionario(){
		Funcionario.identificar +=1;
	}
	
	public Funcionario(String nomeFuncionario){
		this.nomeFuncionario=nomeFuncionario;
	}
	
	public Funcionario(String departamento,double salario,Data dataEntrada,String rg){
		this(null,departamento,salario,dataEntrada,rg);
	}

	public Funcionario(String nomeFuncionario,String departamento,double salario,Data dataEntrada,String rg){
		this.nomeFuncionario=nomeFuncionario;
		this.departamento=departamento;
		this.salario=salario;
		this.dataEntrada=dataEntrada;
		this.rg=rg;
	}

	public void setPi(int pi){
		this.pi=pi;
	}
	public void setNomeFuncionario(String nomeFuncionario){
		this.nomeFuncionario=nomeFuncionario;
	}
	public void setDepartamento(String departamento){
		this.departamento=departamento;
	}
	public void setSalario(double salario){
		this.salario=salario;
	}
	public void setRg(String rg){
		this.rg=rg;
	}

	public void setDataEntrada(Data dataEntrada){
		this.dataEntrada=dataEntrada;
	}
	
	
	public static int getIdentificador(){
		return Funcionario.identificar;
	}

	public int getPi(){
		return this.pi;
	}
	public String getNomeFuncionario(){
		return this.nomeFuncionario;
	}
	public String getDepartamento(){
		return this.departamento;
	}
	public double getSalario(){
		return this.salario;
	}
	public String getRg(){
		return this.rg;
	}

	public double getGanhoAnual(){
		return this.salario*12;
	}
	
	public Data getDataEntrada(){
		return this.dataEntrada;
	}
	
	public boolean descontaSalario(double valorDesconto){
		if(salario>valorDesconto){
			setSalario(getSalario()-valorDesconto);
			return true;
		}else{
			return false;
		}
	}
	public void recebeAumento(double valorAumento){
		setSalario(getSalario()+valorAumento);
	}
	public void mostraDadosFuncionario(){
		System.out.println("Nome : " + getNomeFuncionario()
							+"\nDepartamento :"+ getDepartamento()
							+"\nSalario :"+ getSalario()
							+"\nData de Entrada :"+getDataEntrada().getFormatada()
							+"\nRegisto Geral :"+ getRg());
	
	}
}


class Data{
	int dia, mes, ano;
	public Data(){
	}
	
	public Data(int dia, int mes, int ano){
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
		
		if (! isDataViavel(dia, mes, ano)) {
            System.out.println("A data " + getFormatada() + " não existe!");
        }

	}
	
	private boolean isDataViavel(int dia, int mes, int ano) {
        if (dia <= 0 || mes <= 0) {
            return false;
        }

        int ultimoDiaDoMes = 31; // por padrao são 31 dias
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {
            ultimoDiaDoMes = 30;
        } else if (mes == 2) {
            ultimoDiaDoMes = 28;
            if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
                ultimoDiaDoMes = 29;
            }
        }
        if (dia > ultimoDiaDoMes) {
            return false;
        }

        return true;
    }

	
/*	public void setData(int dia, int mes, int ano){
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
		
	}
*/	
	public String getFormatada(){
		if (! isDataViavel(dia, mes, ano)) {
            return "A data " + this.dia+"/"+this.mes+"/"+this.ano + " não existe!";
        }

		return this.dia+"/"+this.mes+"/"+this.ano;
	}

}


class TestaFuncionario{
	public static void main (String [] args){
		
		Data dataEntrada=new Data(30,02,2017);
		Funcionario funcionarioProcurado;
		Empresa empresa=new Empresa(10);
		
		//empresa.setFuncionarios(new Funcionario[10]);
		
		
		for(int i=0;i<empresa.getFuncionarios().length;i++){
			
			Funcionario funcionario=new Funcionario();
			//dataEntrada.setData(12,12,2017);
			funcionario.setPi(i+1);
			funcionario.setNomeFuncionario("Funcionario "+1);
			funcionario.setDepartamento("TICs");
			funcionario.setSalario(1000+i*100);
			funcionario.setDataEntrada(dataEntrada);
			funcionario.setRg("123456789B"+i);

			if(empresa.adicionaFuncionario(empresa.getFuncionarios(),funcionario)==true){
				System.out.println("Adicionado "+funcionario.getPi() + " identificador: "+ funcionario.getIdentificador());
			}else{
				System.out.println("Ja Existe Funcionario "+funcionario.getPi());
			}

		}
		
		empresa.listaFuncionarios(empresa.getFuncionarios());
		funcionarioProcurado=empresa.getFuncionario(2);// funcionarios[2];
	
		if (empresa.contem(funcionarioProcurado)==true){
			System.out.println("Funcionario encontrado :"+funcionarioProcurado.getPi());
		}else{
			System.out.println("Funcionario nao encontrado :"+funcionarioProcurado.getPi());		
		}
		
	}
}

