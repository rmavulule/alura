class Lacos{
	public static void main(String[] args){
		
		int x=13;
		while(x!=1){
			if(x%2==0){ //par
				x = x/2;
			} else{//impar
				x = 3*x+1;
			}
			System.out.print(x +"> ");
		}	
	}
}