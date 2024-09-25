package tp3;
import java.util.List;
import java.util.LinkedList;
public class Caminos {
	private GeneralTree<Integer>arbol;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer>caminoActual=new LinkedList();
		List<Integer>caminoMaximo=new LinkedList();
		if(arbol.isEmpty() || arbol==null) {
			return caminoActual;
		}
		EncontrarCamino(this.arbol,caminoActual,caminoMaximo);
		return caminoMaximo;
	}
	
	private void EncontrarCamino(GeneralTree<Integer>nodo,List<Integer>caminoActual,List<Integer>caminoMaximo){
		caminoActual.add(nodo.getData());
		if(nodo.isLeaf()) {
			if(caminoActual.size()>caminoMaximo.size()) {
				caminoMaximo.clear();
				caminoMaximo.addAll(caminoActual);
			}
		}else {			
			List<GeneralTree<Integer>>children=nodo.getChildren();
			for(GeneralTree<Integer>child:children) {
				EncontrarCamino(child,caminoActual,caminoMaximo);
				caminoActual.remove(caminoActual.size()-1);
			}
		}
		
		
	}


	public static void main(String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(12);
        GeneralTree<Integer> n17 = new GeneralTree<>(17);
        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n15 = new GeneralTree<>(15);
        GeneralTree<Integer> n10 = new GeneralTree<>(10);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);
        GeneralTree<Integer> n1 = new GeneralTree<>(1);
        GeneralTree<Integer> n8 = new GeneralTree<>(8);
        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n16 = new GeneralTree<>(16);
        GeneralTree<Integer> n7 = new GeneralTree<>(7);
        GeneralTree<Integer> n18 = new GeneralTree<>(18);
        
        // Establecer relaciones padre-hijo
        List<GeneralTree<Integer>> children12 = new LinkedList<>();
        children12.add(n17);  // 17
        children12.add(n9);   // 9
        children12.add(n15);  // 15
        root.setChildren(children12);  // 12 es el padre de 17, 9 y 15
        
        List<GeneralTree<Integer>> children17 = new LinkedList<>();
        children17.add(n10);  // 10
        children17.add(n6);   // 6
        n17.setChildren(children17);  // 17 es el padre de 10 y 6
        
        List<GeneralTree<Integer>> children6 = new LinkedList<>();
        children6.add(n1);  // 1
        n6.setChildren(children6);  // 6 es el padre de 1
        
        List<GeneralTree<Integer>> children9 = new LinkedList<>();
        children9.add(n8);  // 8
        n9.setChildren(children9);  // 9 es el padre de 8
        
        List<GeneralTree<Integer>> children15 = new LinkedList<>();
        children15.add(n14);  // 14
        children15.add(n18);  // 18
        n15.setChildren(children15);  // 15 es el padre de 14 y 18
        
        List<GeneralTree<Integer>> children14 = new LinkedList<>();
        children14.add(n16);  // 16
        children14.add(n7);   // 7
        n14.setChildren(children14);  // 14 es el padre de 16 y 7
        
        Caminos x=new Caminos(root);
        List<Integer>camino=x.caminoAHojaMasLejana();
        for(Integer num:camino) {
        	System.out.println(num);
        }

	}

}
