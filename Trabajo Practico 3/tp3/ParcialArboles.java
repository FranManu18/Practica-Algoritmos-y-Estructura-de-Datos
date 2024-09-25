package tp3;
import java.util.List;
import java.util.LinkedList;
import tp1.Ejercicio8.Queue;
public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		return ProbarSeleccion(arbol);
	}
	
	private static boolean ProbarSeleccion(GeneralTree<Integer>arbol) {
		if(arbol==null) {
			return true;
		}
		if(arbol.isLeaf()) {
			return true;
		}
		List<GeneralTree<Integer>>children=arbol.getChildren();
		if(children.isEmpty()) {
			return true;
		}
		int minimo=Integer.MAX_VALUE;
		boolean termina=false;
		for(int i=0;i<children.size() && !termina;i++) {
			if(!ProbarSeleccion(children.get(i))) {
				termina=true;
			};
			minimo=Math.min(minimo, children.get(i).getData());
		}
		if(termina) {
			return false;
		}
		return arbol.getData().equals(minimo);
		
	}
	

	
	//-------------------------------------------
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer>caminoActual=new LinkedList();
		List<Integer>caminoMaximo=new LinkedList();
		if(arbol==null || arbol.isEmpty()) {
			return caminoMaximo;
		}
		int[] max= {Integer.MIN_VALUE};//En Java, los parámetros primitivos (como int) se pasan por valor, lo que significa que cualquier modificación realizada sobre ellos dentro de un método no se refleja fuera del mismo. Sin embargo, al usar un array, aunque sea de un solo elemento, estás pasando una referencia al array, lo que permite que se modifique su contenido dentro del método recursivo
		CaminoFiltrado(arbol,caminoMaximo,caminoActual,0,0,max);
		return caminoMaximo;
	}
	
	private static void CaminoFiltrado(GeneralTree<Integer>arbol,List<Integer>caminoMaximo,List<Integer>caminoActual,int nivel,int suma,int[] max) {
		suma+=arbol.getData()*nivel;
		if(arbol.getData().equals(1)) {
			caminoActual.add(arbol.getData());
		}
		if(arbol.isLeaf()) {
			if(suma>max[0]) {
				caminoMaximo.clear();
				caminoMaximo.addAll(caminoActual);
				max[0]=suma;
			}
		}else {
			List<GeneralTree<Integer>>children=arbol.getChildren();
			for(GeneralTree<Integer>child:children) {
				CaminoFiltrado(child,caminoMaximo,caminoActual,nivel+1,suma,max);
				if(!caminoActual.isEmpty()) {				
					caminoActual.remove(caminoActual.size()-1);
				}
			}
		}
	}
	

	
	//--------------------------
	
	
	/*public static boolean resolver2(GeneralTree<Integer> arbol) {
		if(arbol.isEmpty()||arbol==null) {
			return true;
		}
		
		Queue<GeneralTree<Integer>>cola=new Queue();
		int cantNodosPasados=0;
		boolean termino=true;
		cola.enqueue(arbol);
		while(!cola.isEmpty()&& termino) {
			int cantNodos=cola.size();
			if(cantNodos>cantNodosPasados) {				
				for(int i=0;i<cantNodos;i++) {
					GeneralTree<Integer>frente=cola.dequeue();
					List<GeneralTree<Integer>>children=frente.getChildren();
					for(GeneralTree<Integer>child:children) {
						cola.enqueue(child);
					}
				}
				cantNodosPasados=cantNodos;		
			}else {
				termino=false;
			}
		}
		
		return termino;
	}*/
	
	public static boolean resolver2(GeneralTree<Integer> arbol) {
		if(arbol.isEmpty()||arbol==null) {
			return false;
		}
		Queue<GeneralTree<Integer>>cola=new Queue();
		int cantNodosAnterior=0;
		cola.enqueue(arbol);
		boolean termino=true;
		while(!cola.isEmpty()&&termino) {
			int cantNodos=cola.size();
			System.out.println(cantNodos+" "+cantNodosAnterior);
			if(cantNodos==cantNodosAnterior+1) {
				for(int i=0;i<cantNodos;i++) {
					GeneralTree<Integer>frente=cola.dequeue();
					List<GeneralTree<Integer>>children=frente.getChildren();
					for(GeneralTree<Integer>child:children) {
						cola.enqueue(child);
					}
				}
				cantNodosAnterior=cantNodos;
			}else {
				termino=false;;
			}
		}
		return termino;
	}

	
	
	public static void main(String[] args) {
		// Crear los nodos del árbol
		GeneralTree<Integer> root = new GeneralTree<>(12);

		// Nivel 2
		GeneralTree<Integer> node12a = new GeneralTree<>(12);
		GeneralTree<Integer> node25a = new GeneralTree<>(25);

		// Nivel 3
		GeneralTree<Integer> node35a = new GeneralTree<>(35);
		GeneralTree<Integer> node12b = new GeneralTree<>(12);
		GeneralTree<Integer> node25b = new GeneralTree<>(25);
		GeneralTree<Integer> node33 = new GeneralTree<>(33);

		// Nivel 4
		GeneralTree<Integer> node35b = new GeneralTree<>(35);
		GeneralTree<Integer> node14 = new GeneralTree<>(14);
		GeneralTree<Integer> node12c = new GeneralTree<>(12);

		// Nivel 5
		GeneralTree<Integer> node35c = new GeneralTree<>(35);
		GeneralTree<Integer> node35d = new GeneralTree<>(35);
		GeneralTree<Integer> node83 = new GeneralTree<>(83);
		GeneralTree<Integer> node90 = new GeneralTree<>(90);
		GeneralTree<Integer> node33b = new GeneralTree<>(33);

		// Definir las conexiones
		root.addChild(node12a);
		root.addChild(node25a);

		node12a.addChild(node35a);
		node12a.addChild(node12b);

		node25a.addChild(node25b);

		node12b.addChild(node14);
		node12b.addChild(node12c);
		node12b.addChild(node33);

		node35a.addChild(node35c);

		node33.addChild(node35d);
		node33.addChild(node83);
		node33.addChild(node90);
		node33.addChild(node33b);
		
		ParcialArboles x=new ParcialArboles();
		System.out.println(x.esDeSeleccion(root));
		
		//----------------------------------------
		
		GeneralTree<Integer> root2 = new GeneralTree<>(1);

		GeneralTree<Integer> left = new GeneralTree<>(0);
		GeneralTree<Integer> right = new GeneralTree<>(1);
		GeneralTree<Integer> rightRight = new GeneralTree<>(1);

		root2.addChild(left);
		root2.addChild(right);
		root2.addChild(rightRight);

		// Left subtree
		GeneralTree<Integer> leftLeft = new GeneralTree<>(1);
		GeneralTree<Integer> leftRight = new GeneralTree<>(1);

		left.addChild(leftLeft);
		left.addChild(leftRight);

		GeneralTree<Integer> leftLeftLeft = new GeneralTree<>(1);
		GeneralTree<Integer> leftRightRight = new GeneralTree<>(1);

		leftLeft.addChild(leftLeftLeft);
		leftRight.addChild(leftRightRight);

		// Right subtree
		GeneralTree<Integer> rightLeft = new GeneralTree<>(1);
		GeneralTree<Integer> rightRightLeft = new GeneralTree<>(0);
		GeneralTree<Integer> rightRightRight = new GeneralTree<>(0);

		right.addChild(rightLeft);
		right.addChild(rightRightLeft);
		right.addChild(rightRightRight);

		GeneralTree<Integer> rightRightRightLeft = new GeneralTree<>(1);
		rightRightRight.addChild(rightRightRightLeft);

		// Additional children for deeper levels
		rightRight.addChild(new GeneralTree<>(0));
		rightRight.addChild(new GeneralTree<>(0));
        
        List<Integer>lista=x.resolver(root2);
        for(Integer num:lista) {
        	System.out.println(num);
        }
        
        //-----------------------------------
        
        GeneralTree<Integer> root3 = new GeneralTree<>(1);

        // Nivel 2
        GeneralTree<Integer> B1 = new GeneralTree<>(1);
        GeneralTree<Integer> B2 = new GeneralTree<>(1);
        root3.addChild(B1);
        root3.addChild(B2);

        // Nivel 3
        GeneralTree<Integer> C1 = new GeneralTree<>(1);
        GeneralTree<Integer> C2 = new GeneralTree<>(1);
        GeneralTree<Integer> C3 = new GeneralTree<>(1);
        B1.addChild(C1);
        B1.addChild(C2);
        B2.addChild(C3);

        // Nivel 4
        GeneralTree<Integer> D1 = new GeneralTree<>(1);
        GeneralTree<Integer> D2 = new GeneralTree<>(1);
        GeneralTree<Integer> D3 = new GeneralTree<>(1);
        GeneralTree<Integer> D4 = new GeneralTree<>(1);
        C1.addChild(D1);
        C2.addChild(D2);
        C3.addChild(D3);
        C3.addChild(D4);
        
        System.out.println(x.resolver2(root3));
	}
}
