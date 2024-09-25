package tp1;
import java.util.*;
public class Ejercicio5 {
	
	private double promedio;
	private int max;
	private int min;
	
	
	
	public Ejercicio5(double promedio, int max, int min) {
		super();
		this.promedio = promedio;
		this.max = max;
		this.min = min;
	}
	
	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	


	public ArrayList<Integer> devolverValores(ArrayList<Integer>arreglo){
		int suma=0;
		double promedio;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for (int valor:arreglo){
			suma+=valor;
			if(valor>max){
				max=valor;
			}
			if(valor<min){
				min=valor;
			}
		}
		promedio=(double)suma/arreglo.size();
		ArrayList devolucion=new ArrayList();
		devolucion.add(promedio);
		devolucion.add(max);
		devolucion.add(min);
		return devolucion;
	}
	
	public void valoresEnParametros(ArrayList<Integer>arreglo){
		int suma=0;
		for (int valor:arreglo){
			suma+=valor;
			if(valor>this.max){
				this.max=valor;
			}
			if(valor<this.min){
				this.min=valor;
			}
		}
		this.promedio=(double)suma/arreglo.size();
	}
	
	public void imprimirEnMetodo(ArrayList<Integer>arreglo){
		int suma=0;
		for (int valor:arreglo){
			suma+=valor;
			if(valor>this.max){
				this.max=valor;
			}
			if(valor<this.min){
				this.min=valor;
			}
		}
		this.promedio=(double)suma/arreglo.size();
		System.out.println(promedio);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void main(String[] args){
		Ejercicio5 x=new Ejercicio5(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
		ArrayList<Integer>entrada=new ArrayList();
		entrada.add(2);
		entrada.add(5);
		entrada.add(10);
		entrada.add(1);
		entrada.add(4);
		ArrayList salida=x.devolverValores(entrada);
		for(int i=0;i<salida.size();i++){
			System.out.println(salida.get(i));
		}
		
		System.out.println("----------------------------");
		
		x.valoresEnParametros(entrada);
		System.out.println(x.getPromedio());
		System.out.println(x.getMax());
		System.out.println(x.getMin());
		
		System.out.println("----------------------------");
		x.imprimirEnMetodo(entrada);
	}
}
