class BalancoTrimestral{
	public static void main(String[] args){
		
		int gastosJaneiro=15000;
		int gastosFevereiro=23000;
		int gastosMarco=17000;
		
		//calculando e imprimindo a soma
		int gastosTrimestre =gastosJaneiro+gastosFevereiro+gastosMarco;
		
		System.out.println("Gastos Trimestrais: "+gastosTrimestre);
		
		//calculando e imprimindo a media
		int mediaMensal=gastosTrimestre/3;
		
		System.out.println("Valor da média mensal = " + mediaMensal);
		
		}
	}
}