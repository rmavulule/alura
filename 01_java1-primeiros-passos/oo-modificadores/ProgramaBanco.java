
class Conta{
	int numero;
    String dono;
    double saldo;
    double limite;
	
	boolean saca(double qtySaca){
		//verificar se não estrapolou o limite
		if (this.saldo-qtySaca>=100){
			double novoSaldo=this.saldo-qtySaca;
			this.saldo=novoSaldo;
			
			return true;
		}
		return false;
	}
	
	
	void deposita(double qtyDeposita){
		this.saldo +=qtyDeposita;
	}

	boolean transfere(Conta destino, double qtyTransfere){
		boolean saldoDesponivel=this.saca(qtyTransfere);
		if(saldoDesponivel==true){
			destino.deposita(qtyTransfere);
			return true;
		}
		return false;
	}

}

class ProgramaBanco{
	public static void main(String [] args){
		//Cria objecto conta
		Conta minhaConta=new Conta();
		Conta outraConta=new Conta();
		
		//Altera atributos do objecto conta
		minhaConta.numero=123;
		minhaConta.dono="Rachid Mavulule";
		minhaConta.saldo=900;
		minhaConta.limite=50;
		
		outraConta.saldo=30;
		
		System.out.println("Saldo antes do saque: "+minhaConta.saldo);
		
		//levanta dinheiro 
		boolean conseguiuSacar=true;
		conseguiuSacar = minhaConta.saca(200);
		if (conseguiuSacar==false){
			System.out.println("Saldo Indisponivel");		
		}
		
		System.out.println("Saldo depois do saque: "+minhaConta.saldo);
		
		//deposita 
		minhaConta.deposita(500);
		
		System.out.println("Saldo antes da transferencia: "+minhaConta.saldo);
		System.out.println("Saldo antes da transferencia: "+outraConta.saldo);

		//transfere
		boolean conseguiuTransferir=true;
		conseguiuTransferir=minhaConta.transfere(outraConta,120);
		if (conseguiuTransferir==false){
			System.out.println("Saldo Indisponivel para transferir");		
		}

		System.out.println("Saldo depois da transferencia: "+minhaConta.saldo);
		System.out.println("Saldo depois da transferencia: "+outraConta.saldo);
		
		// teste de referencias
		Conta c1=new Conta();
		Conta c3=new Conta();
		c1.saldo=100;
		c3.saldo=100;
		Conta c2=c1;
		
		if(c1==c2){
			System.out.println("iguais c1 e c2 - referencias iguais");	
		}else{
			System.out.println("diferentes c1 e c2");				
		}
		
		if(c1==c3){
			System.out.println("iguais c1 e c3");	
		}else{
			System.out.println("diferentes c1 e c3 - apesar de valores dos atributos iguais, tem referencias direfentes");				
		}
		

	}
}