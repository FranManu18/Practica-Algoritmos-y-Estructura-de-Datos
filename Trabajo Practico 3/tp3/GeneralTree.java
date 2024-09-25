package tp3;

import java.util.LinkedList;
import java.util.List;
import tp1.Ejercicio8.Queue;
public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 			
		return BuscarMayorAltura(this);
	}
	
	private int BuscarMayorAltura(GeneralTree<T>nodo) {
		if(nodo.isEmpty()) {
			return 0;
		}
		if(nodo.isLeaf()) {
			return 1;
		}else {
			int maxHeight=0;
			List<GeneralTree<T>>children=nodo.getChildren();
			for(GeneralTree<T>child:children) {
				int height=BuscarMayorAltura(child);
				maxHeight=Math.max(maxHeight, height);
			}
			return maxHeight+1;
		}
		
	}
	
	public int nivel(T dato){		
		return BuscarPorNiveles(this,dato);
	 }
	
	private int BuscarPorNiveles(GeneralTree<T>nodo,T dato) {
		Queue<GeneralTree<T>>cola=new Queue();
		GeneralTree<T>head=null;
		int nivelActual=0;
		cola.enqueue(head);
		while(!cola.isEmpty()&&head.getData()!=dato) {
			int CantNodos=cola.size();
			for(int i=0;i<CantNodos;i++) {
				head=cola.dequeue();
				List<GeneralTree<T>>children=head.getChildren();
				for(GeneralTree<T>child:children) {
					cola.enqueue(child);
				}
			}
			nivelActual++;
		}
		return nivelActual;
	}

	public int ancho(){	
		return MayorAncho(this);
	}
	
	private int MayorAncho(GeneralTree<T>nodo) {
		Queue<GeneralTree<T>>cola=new Queue();
		int maxAncho=0;
		while(!cola.isEmpty()) {
			int CantNodos=cola.size();
			for(int i=0;i<CantNodos;i++) {
				GeneralTree<T>frente=cola.dequeue();
				List<GeneralTree<T>>children=frente.getChildren();
				for(GeneralTree<T>child:children) {
					cola.enqueue(child);
				}
			}
			maxAncho=Math.max(maxAncho,CantNodos);
		}
		return maxAncho;
	}
	
	public boolean esAncestro(T a, T b) {
		GeneralTree<T>nodoA=BuscarNodo(this,a);
		GeneralTree<T>nodoB=BuscarNodo(this,b);
		if(nodoA==null || nodoB==null) {
			return false;
		}
		return BuscarAncestro(nodoA,nodoB);
	}
	
	private boolean BuscarAncestro(GeneralTree<T>nodoA,GeneralTree<T>nodoB) {
		if(nodoA==nodoB) {
			return true;
		}
		List<GeneralTree<T>>children=nodoA.getChildren();
		boolean resultado=false;
		for(int i=0; i<children.size() && resultado==false;i++) {
			resultado=BuscarAncestro(children.get(i),nodoB);
		}
		if(resultado) {
			return resultado;
		}
		return false;
	}
	
	private GeneralTree<T>BuscarNodo(GeneralTree<T>nodo,T a){
		if(nodo==null) {
			return null;
		}
		if(nodo.getData().equals(a)) {
			return nodo;
		}
		List<GeneralTree<T>>children=nodo.getChildren();
		GeneralTree<T>resultado=null;
		for(int i=0;i<children.size() && resultado==null; i++) {
			resultado=BuscarNodo(children.get(i),a);
		}
		if(resultado!=null) {
			return resultado;
		}
		return null;
	}
	
	
}