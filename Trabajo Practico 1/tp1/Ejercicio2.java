package tp1;

import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio2 {
	
	public static void multiplosArray(int n){
		ArrayList multiplos=new ArrayList(n);
		for(int i=1;i<=n;i++){
			int base=n*i;
			multiplos.add(base);
		}
		for(int i=0;i<n;i++){
			System.out.println(multiplos.get(i));
		}
	}
	public static void main(String[] args) {
		Ejercicio2 x=new Ejercicio2();
		Scanner s=new Scanner(System.in);
		x.multiplosArray(s.nextInt());

	}

}
