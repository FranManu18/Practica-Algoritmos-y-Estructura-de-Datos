package tp1.Ejercicio7;
import java.util.*;
public class EjercicioSucesion {
	
	public List<Integer>calcularSucesion(int n){
		List<Integer>sucesion=new LinkedList();
		calcularSucesionRecursivo(n,sucesion);
		return sucesion;
	}
	
	private void calcularSucesionRecursivo(int n,List<Integer>sucesion){
		sucesion.add(n);
		if(n==1){
			return;
		}
		
		if(n%2==0){
			calcularSucesionRecursivo(n/2,sucesion);
		}else{
			calcularSucesionRecursivo(3*n+1,sucesion);
		}
	}
	public static void main(String[] args) {
		EjercicioSucesion x=new EjercicioSucesion();
		
		List<Integer>lista=x.calcularSucesion(6);
		for(int numero:lista){
			System.out.println(numero);
		}

	}

}
