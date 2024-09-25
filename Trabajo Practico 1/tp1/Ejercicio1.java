package tp1;

public class Ejercicio1 {
	
	public static void unFor(int a,int b){
		for(int i=a;i<=b;i++){
			System.out.println(i);
		}
		System.out.println("Termino");
	}
	
	public static void unWhile(int a,int b){
		while(a<=b){
			System.out.println(a);
			a++;
		}
		System.out.println("Termino");
	}
	
	public static void sinEstructuras(int a,int b){
		if(a>b){
			return;
		}
		System.out.println(a);
		sinEstructuras(a+1,b);
	}
	
	public static void main(String[] args) {
		Ejercicio1 x=new Ejercicio1();
		
		x.sinEstructuras(1, 5);

	}

}
