package tp1.Ejercicio7;
import java.util.*;

public class TestArayList {

	
	public void AccionesLista(){
		LinkedList<String>estudiantes=new LinkedList();
		
		estudiantes.add("Francisco");
		estudiantes.add("Juan");
		estudiantes.add("Pedro");
		
		LinkedList<String>estudiantesCopia=new LinkedList(estudiantes);
		
		for(String estudiante:estudiantes){
			System.out.println(estudiante);
		}
		System.out.println("--------lista copia-----------");
		for(String estudiante:estudiantesCopia){
			System.out.println(estudiante);
		}
		
		System.out.println("----------------------");
		
		estudiantes.set(0,"Roberto");
		for(String estudiante:estudiantes){
			System.out.println(estudiante);
		}
		System.out.println("--------lista copia-----------");
		for(String estudiante:estudiantesCopia){
			System.out.println(estudiante);
		}
		
		/*
		 * las formas de copiar una lista son:
		 * Copia Superficial usando el Constructor de Copia(como hice aca):Rápido y conveniente para copiar listas cuando solo se necesita una copia superficial
		 * Copia Superficial usando el Método addAll(copiaLista.addAll(listaOriginal)):Útil cuando se desea copiar elementos de una lista a otra existente.
		 * Copia Superficial usando el Método clone(ArrayList<String> copiaLista = (ArrayList<String>) listaOriginal.clone()): Especialmente adecuado para ArrayList, pero puede ser menos legible y comprensible debido a la necesidad de casting
		 * Copia Manual:Útil cuando se necesita garantizar que las listas sean completamente independientes. Requiere métodos de copia/clonación personalizados para cada objeto contenido en la lista
		 */
		
		//e)
		System.out.println("--------punto e--------------");
		Scanner scanner=new Scanner(System.in);
		String input=scanner.next();
		if(!estudiantes.contains(input)){
			estudiantes.add(input);
		}else{
			System.out.println("Ese estudiante ya esta en la lista");
		}
		
	}
	public boolean esCapicua(ArrayList<Integer>lista){
		if(lista==null){
			return false;
		}
		ArrayList<Integer>listaCopia=new ArrayList();
		for(int i=lista.size()-1;i>=0;i--){
			listaCopia.add(lista.get(i));
		}
		if(listaCopia.equals(lista)){
			return true;
		}
		return false;		
	}
	
	public void invertirArrayList(ArrayList<Integer>lista){
		if(lista.size()<=1){
			return;
		}
		
		int primerElemento=lista.remove(0);
		
		invertirArrayList(lista);
		
		lista.add(primerElemento);
	}
	
	public int sumarLinkedList(LinkedList<Integer>lista){
		if(lista==null){
			return 0;
		}
		return sumarLinkedListRecursivo(lista,0);
	}
	
	private int sumarLinkedListRecursivo(LinkedList<Integer>lista,int i){
		if(i>=lista.size()){
			return 0;
		}
		return lista.get(i)+sumarLinkedListRecursivo(lista,i+1);
	}
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
		if(lista1==null || lista2==null){
			return null;
		}
		ArrayList<Integer>combinacion=new ArrayList();
		int i=0;
		int j=0;
		while(i<lista1.size()&&j<lista2.size()){
			if(lista1.get(i)<=lista2.get(j)){
				combinacion.add(lista1.get(i));
				i++;
			}else{
				combinacion.add(lista2.get(j));
				j++;
			}
		}
		
		while(i<lista1.size()){
			combinacion.add(lista1.get(i));
			i++;
		}
		
		while(j<lista2.size()){
			combinacion.add(lista2.get(j));
			j++;
		}
		return combinacion;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer>numeros=new ArrayList<>();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Introduce una secuencia de números (ingresa 'fin' para terminar):");
		
		while(scanner.hasNext()){
			String input=scanner.next();
			if(input.equals("fin")){
				break;
			}else{
				int numero=Integer.parseInt(input);
				numeros.add(numero);
			}
		}
		
		System.out.println("----------------------");
		
		for(int numero:numeros){
			System.out.println(numero);
		}
		
		/*
		 * b) si lo hiciera con LinkedList,la implementacion hubiese sido la misma
		 * c)si,como un for,un while
		 */
		
		System.out.println("---------punto d-------------");
		TestArayList x=new TestArayList();
		x.AccionesLista();
		
		System.out.println("---------punto f-------------");
		ArrayList<Integer>lista=new ArrayList();
		lista.add(2);
		lista.add(5);
		lista.add(2);
		System.out.println(x.esCapicua(lista));
		
		System.out.println("---------punto h-------------");
		lista.clear();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		x.invertirArrayList(lista);
		for(int numero:lista){
			System.out.println(numero);
		}
		
		System.out.println("---------punto i-------------");
		LinkedList<Integer>lista2=new LinkedList();
		lista2.add(10);
		lista2.add(15);
		lista2.add(1);
		System.out.println(x.sumarLinkedList(lista2));
		
		System.out.println("---------punto j-------------");
		ArrayList<Integer>listaUno=new ArrayList();
		listaUno.add(1);
		listaUno.add(4);
		listaUno.add(8);
		listaUno.add(9);
		ArrayList<Integer>listaDos=new ArrayList();
		listaDos.add(2);
		listaDos.add(7);
		listaDos.add(11);
		
		ArrayList<Integer>combinacion=x.combinarOrdenado(listaUno, listaDos);
		for(int numero:combinacion){
			System.out.println(numero);
		}
	}

}
