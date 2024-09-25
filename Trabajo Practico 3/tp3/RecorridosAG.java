package tp3;
import java.util.List;
import java.util.LinkedList;
import tp1.Ejercicio8.Queue;
public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer>lista=new LinkedList();
		return ImparesRecursivo(a,n,lista);		
	}
	
	private List<Integer> ImparesRecursivo(GeneralTree <Integer> a,Integer n,List<Integer>lista) {
		if(a.isEmpty()) {
			return lista;
		}
		if(a.getData()%2!=0 && a.getData()>n) {
			lista.add(a.getData());
		}
		List<GeneralTree<Integer>>children=a.getChildren();
		for(GeneralTree<Integer> child:children) {
			ImparesRecursivo(child,n,lista);
		}
		return lista;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer>lista=new LinkedList();
		return ImparesRecursivoInOrden(a,n,lista);	
	}
	
	private GeneralTree<Integer> MasIzquierdo(List<GeneralTree<Integer>>children) {
		return children.get(0);
	}
	
	private List<Integer>ImparesRecursivoInOrden(GeneralTree <Integer> a,Integer n,List<Integer>lista){
		if(a.isEmpty()) {
			return lista;
		}
		List<GeneralTree<Integer>>children=a.getChildren();
		if(!children.isEmpty()) {		
			ImparesRecursivoInOrden(MasIzquierdo(children),n,lista);
		}
		if(a.getData()%2!=0 && a.getData()>n) {
			lista.add(a.getData());
		}
		for(int i=1;i<children.size();i++) {
			ImparesRecursivoInOrden(children.get(i),n,lista);
		}
		return lista;
	}
	
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer>lista=new LinkedList();
		return ImparesRecursivoPostOrden(a,n,lista);	
	}
	
	private List<Integer>ImparesRecursivoPostOrden(GeneralTree <Integer> a,Integer n,List<Integer>lista){
		if(a.isEmpty()) {
			return lista;
		}
		List<GeneralTree<Integer>>children=a.getChildren();
		for(GeneralTree<Integer>child:children) {
			ImparesRecursivoPostOrden(child,n,lista);
		}
		if(a.getData()%2!=0 && a.getData()>n) {
			lista.add(a.getData());
		}
		return lista;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer>lista=new LinkedList();
		if(a.isEmpty()) {
			return lista;
		}
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(a);
		while(!cola.isEmpty()) {
			int CantNodos=cola.size();
			for(int i=0;i<CantNodos;i++) {				
				GeneralTree<Integer>nodo=cola.dequeue();
				if(nodo.getData()%2!=0 && nodo.getData()>n) {
					lista.add(nodo.getData());
				}
				List<GeneralTree<Integer>>children=nodo.getChildren();
				for(GeneralTree<Integer>child:children) {
					cola.enqueue(child);
				}
			}
		}
		return lista;
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(10);
        GeneralTree<Integer> child1 = new GeneralTree<>(3);
        GeneralTree<Integer> child2 = new GeneralTree<>(15);
        GeneralTree<Integer> child3 = new GeneralTree<>(7);
        GeneralTree<Integer> child4 = new GeneralTree<>(8);
        GeneralTree<Integer> child5 = new GeneralTree<>(20);
        GeneralTree<Integer> child6 = new GeneralTree<>(5);

        // Agregar hijos a los nodos
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        child1.addChild(child4);
        child2.addChild(child5);
        child3.addChild(child6);
        
        RecorridosAG recorridos=new RecorridosAG();
        List<Integer>imparesMayoresQueN=recorridos.numerosImparesMayoresQuePreOrden(root, 6);       
        System.out.println("Pre Orden: ");
        for(Integer num:imparesMayoresQueN) {
        	System.out.println(num);
        }
        
        //----------------
        imparesMayoresQueN=recorridos.numerosImparesMayoresQueInOrden(root, 6);      
        System.out.println("In Orden: ");
        for(Integer num:imparesMayoresQueN) {
        	System.out.println(num);
        }
        
        //----------------
        imparesMayoresQueN=recorridos.numerosImparesMayoresQuePostOrden(root, 6);      
        System.out.println("Post Orden: ");
        for(Integer num:imparesMayoresQueN) {
        	System.out.println(num);
        }
        
      //----------------
        imparesMayoresQueN=recorridos.numerosImparesMayoresQuePorNiveles(root, 6);      
        System.out.println("Por Niveles: ");
        for(Integer num:imparesMayoresQueN) {
        	System.out.println(num);
        }
        
        System.out.println(root.esAncestro(3, 8));
	}

}
