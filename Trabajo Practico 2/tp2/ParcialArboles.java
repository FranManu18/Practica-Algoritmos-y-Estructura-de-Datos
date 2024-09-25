package tp2;
import java.util.*;
import tp2.ejercicio1.*;
public class ParcialArboles {
	private BinaryTree<Integer>arbol;
	
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public boolean isLeftTree(int num){
		BinaryTree<Integer>arbolBuscado=buscarNum(arbol,num);
		if(arbolBuscado==null){
			return false;
		}	
		int cantIzquierda=ramasRecursivo(arbolBuscado.getLeftChild());				
		int cantDerecha=ramasRecursivo(arbolBuscado.getRightChild());	
		return cantIzquierda>cantDerecha;
	}
	
	private BinaryTree<Integer>buscarNum(BinaryTree<Integer>nodo,int num){
		if(nodo==null){
			return null;
		}
		if(nodo.getData().equals(num)){
			return nodo;
		}
		BinaryTree<Integer>izquierdo=buscarNum(nodo.getLeftChild(),num);
		if(izquierdo!=null){
			return izquierdo;
		}
		BinaryTree<Integer>derecho=buscarNum(nodo.getRightChild(),num);
		return derecho;
		
	}
	private int ramasRecursivo(BinaryTree<Integer>nodo){
		if(nodo==null){
			return -1;
		}
		int count=0;
		if(nodo.hasLeftChild() && !nodo.hasRightChild()||(!nodo.hasLeftChild() && nodo.hasRightChild())){
			count++;
		}
		count+=ramasRecursivo(nodo.getLeftChild());
		count+=ramasRecursivo(nodo.getRightChild());
		return count;

	}
	
	//----------------------------------------
	
	public boolean esPrefijo(BinaryTree<Integer>arbol1,BinaryTree<Integer>arbol2) {
		if (arbol1 == null && arbol2 == null) {
	        return true;
	    }

	    if (arbol1 == null || arbol2 == null) {
	        return false;
	    }
		return esPrefijoRecursivo(arbol1,arbol2);
	}
	
	private boolean esPrefijoRecursivo(BinaryTree<Integer>arbol1,BinaryTree<Integer>arbol2) {
		if(arbol1.getData()!=arbol2.getData()) {
			return false;
		}
		if(arbol1.hasRightChild()) {
			if(!esPrefijoRecursivo(arbol1.getRightChild(),arbol2.getRightChild())) {
				return false;
			}
		}
		if(arbol1.hasLeftChild()) {
			if(!esPrefijoRecursivo(arbol1.getLeftChild(),arbol2.getLeftChild())) {
				return false;
			}
		}
		return true;
	}
	
	//----------------------------------------
	
	public BinaryTree<DobleValor> sumAndDif(BinaryTree<Integer>arbol){
		BinaryTree<DobleValor>nuevoArbol=new BinaryTree<DobleValor>();
		if(arbol!=null || !arbol.isEmpty()) {
			llenarArbol(arbol,nuevoArbol,0,0);
		}
		return nuevoArbol;
	}
	
	private void llenarArbol(BinaryTree<Integer>arbol,BinaryTree<DobleValor>nuevoArbol,int valorPadre,int suma) {
		DobleValor datos=new DobleValor(suma+arbol.getData(),arbol.getData()-valorPadre);
		nuevoArbol.setData(datos);
		
		if(arbol.hasLeftChild()) {
			BinaryTree<DobleValor>hijoIzquierdo=new BinaryTree<DobleValor>();
			nuevoArbol.addLeftChild(hijoIzquierdo);
			llenarArbol(arbol.getLeftChild(),nuevoArbol.getLeftChild(),arbol.getData(),suma+arbol.getData());
		}
		if(arbol.hasRightChild()) {
			BinaryTree<DobleValor>hijoDerecho=new BinaryTree<DobleValor>();
			nuevoArbol.addRightChild(hijoDerecho);
			llenarArbol(arbol.getRightChild(),nuevoArbol.getRightChild(),arbol.getData(),suma+arbol.getData());
		}
	}

	
	public static void printTree(BinaryTree<DobleValor> node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.getRightChild(), level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + node.getData().getSuma()+"|"+node.getData().getDiferencia());
        } else {
            System.out.println(node.getData().getSuma()+"|"+node.getData().getDiferencia());
        }

        printTree(node.getLeftChild(), level + 1);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<>(2);

        // Crear los nodos del árbol
        /*BinaryTree<Integer> node7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodeMinus5 = new BinaryTree<>(-5);
        BinaryTree<Integer> node23 = new BinaryTree<>(23);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        BinaryTree<Integer> node19 = new BinaryTree<>(19);
        BinaryTree<Integer> nodeMinus3 = new BinaryTree<>(-3);
        BinaryTree<Integer> node55 = new BinaryTree<>(55);
        BinaryTree<Integer> node11 = new BinaryTree<>(11);
        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        BinaryTree<Integer> node18 = new BinaryTree<>(18);

        // Construir el árbol
        root.addLeftChild(node7);
        root.addRightChild(nodeMinus5);

        node7.addLeftChild(node23);
        node7.addRightChild(node6);

        nodeMinus5.addRightChild(node19);

        node23.addLeftChild(nodeMinus3);

        node6.addLeftChild(node55);
        node6.addRightChild(node11);

        node19.addLeftChild(node4);

        node4.addRightChild(node18);*/
        
        ParcialArboles x=new ParcialArboles(root);
        
        //System.out.println(x.isLeftTree(7));
        
        //----------------------------------------
        
     // Crear los nodos del arbol 1
        BinaryTree<Integer> root1 = new BinaryTree<>(65);
        BinaryTree<Integer> node37 = new BinaryTree<>(37);
        BinaryTree<Integer> node81 = new BinaryTree<>(81);
        BinaryTree<Integer> node47 = new BinaryTree<>(47);
        BinaryTree<Integer> node93 = new BinaryTree<>(93);

        // Construir el arbol 1
        root1.addLeftChild(node37);
        root1.addRightChild(node81);
        node37.addRightChild(node47);
        node81.addRightChild(node93);
        
        BinaryTree<Integer> root2 = new BinaryTree<>(65);
        BinaryTree<Integer> node37A2 = new BinaryTree<>(37);
        BinaryTree<Integer> node81A2 = new BinaryTree<>(81);
        BinaryTree<Integer> node22 = new BinaryTree<>(22);
        BinaryTree<Integer> node47A2 = new BinaryTree<>(47);
        BinaryTree<Integer> node76 = new BinaryTree<>(76);
        BinaryTree<Integer> node93A2 = new BinaryTree<>(93);
        BinaryTree<Integer> node11A2 = new BinaryTree<>(11);
        BinaryTree<Integer> node29 = new BinaryTree<>(29);
        BinaryTree<Integer> node85 = new BinaryTree<>(85);
        BinaryTree<Integer> node94 = new BinaryTree<>(94);

        // Construir el arbol 2 correctamente
        root2.addLeftChild(node37A2);
        root2.addRightChild(node81A2);
        node37A2.addLeftChild(node22); // Cambiar node37 a node37A2
        node37A2.addRightChild(node47A2);
        node22.addLeftChild(node11A2);
        node22.addRightChild(node29);
        node81A2.addLeftChild(node76); // Cambiar node81 a node81A2
        node81A2.addRightChild(node93A2);
        node93A2.addLeftChild(node85); // Cambiar node93 a node93A2
        node93A2.addRightChild(node94);
        
        System.out.println(x.esPrefijo(root1,root2));
        
        //---------------------------------------
        System.out.println("-------------------------------------");
        
     // Crear los nodos del árbol
        BinaryTree<Integer> root3 = new BinaryTree<>(20);
        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node30 = new BinaryTree<>(30);
        BinaryTree<Integer> nodeMinus5A3 = new BinaryTree<>(-5);
        BinaryTree<Integer> node10 = new BinaryTree<>(10);
        BinaryTree<Integer> node50 = new BinaryTree<>(50);
        BinaryTree<Integer> nodeMinus9 = new BinaryTree<>(-9);
        BinaryTree<Integer> node1 = new BinaryTree<>(1);
        BinaryTree<Integer> node4A3 = new BinaryTree<>(4);
        BinaryTree<Integer> node6A3 = new BinaryTree<>(6);

        // Construir el árbol de acuerdo a la imagen
        root3.addLeftChild(node5);
        root3.addRightChild(node30);
        node5.addLeftChild(nodeMinus5A3);
        node5.addRightChild(node10);
        node10.addLeftChild(node1);
        node30.addLeftChild(node50);
        node30.addRightChild(nodeMinus9);
        node50.addLeftChild(node4A3);
        node4A3.addRightChild(node6A3);
        
        BinaryTree<DobleValor>nuevoArbol=x.sumAndDif(root3);
        x.printTree(nuevoArbol, 0);
	}
	

}
