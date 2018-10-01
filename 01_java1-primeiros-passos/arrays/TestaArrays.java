class ArrayNumeros{
	
	void insereNumeros(int[] numeros){
		for (int i=0;i<numeros.length;i++){
			numeros[i]=i*numeros.length;
		}
	}
	
	void imprimeNumeros(int[] numeros){
		for (int i=0;i<numeros.length;i++){
			System.out.println("numero "+ i + ": "+ numeros[i]);
		}
	}
}

class TestaArrays{
	public static void main(String[] args){
		ArrayNumeros arrayNumeros=new ArrayNumeros();
		int[] numeros=new int[-1];
		
		//imprimir elementos da array antes e inserí-losarrayNumeros
		arrayNumeros.imprimeNumeros(numeros);
		//inserir
		arrayNumeros.insereNumeros(numeros);
		//imprimir
		arrayNumeros.imprimeNumeros(numeros);
	}
}