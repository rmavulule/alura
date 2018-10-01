class VariaveisFluxos{
	public static void main(String[] args){
		int i=10;
		int x=2;
		System.out.println(i/0.0);
		i += x; // equivale a : i=i+x
		System.out.println("x: "+ x);
		System.out.println("i: "+ i);

		i -= x;// equivale a : i=i-x
		System.out.println("x: "+ x);
		System.out.println("i: "+ i);
		
	}
}