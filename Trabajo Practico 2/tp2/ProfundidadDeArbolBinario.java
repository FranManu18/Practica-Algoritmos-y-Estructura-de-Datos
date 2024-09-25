package tp2;
import tp2.ejercicio1.*;
import java.util.*;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer>arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaELementosProfundidad(int p){
		Queue<BinaryTree<Integer>>cola=new LinkedList();
		cola.add(arbol);
		int suma=0;
		int nivelActual=0;
		while(!cola.isEmpty() && nivelActual<=p){
			int cantNodos=cola.size();
			if(nivelActual==p){
				for(int i=0;i<cantNodos;i++){
					BinaryTree<Integer>top=cola.poll();
					suma+=top.getData();
					if(top.hasLeftChild()){
						cola.add(top.getLeftChild());
					}
					if(top.hasRightChild()){
						cola.add(top.getRightChild());
					}
				}
			}else{
				for(int i=0;i<cantNodos;i++){
					BinaryTree<Integer>top=cola.poll();
					if(top.hasLeftChild()){
						cola.add(top.getLeftChild());
					}
					if(top.hasRightChild()){
						cola.add(top.getRightChild());
					}
				}
			}
			nivelActual++;
		}
		return suma;
	}

	public static void main(String[] args) {
		BinaryTree<Integer>arbol=new BinaryTree<Integer>(2);
		BinaryTree<Integer>leftChild=new BinaryTree<Integer>(5);
		BinaryTree<Integer>rightChild=new BinaryTree<Integer>(4);
		arbol.addLeftChild(leftChild);
		arbol.addRightChild(rightChild);
		BinaryTree<Integer>leftLeftChild=new BinaryTree<Integer>(10);
		BinaryTree<Integer>rightLeftChild=new BinaryTree<Integer>(6);
		leftChild.addLeftChild(leftLeftChild);
		leftChild.addRightChild(rightLeftChild);
		BinaryTree<Integer>rightRightChild=new BinaryTree<Integer>(12);
		BinaryTree<Integer>leftRightChild=new BinaryTree<Integer>(2);
		rightChild.addRightChild(rightRightChild);
		rightChild.addLeftChild(rightLeftChild);
		
		ProfundidadDeArbolBinario x=new ProfundidadDeArbolBinario(arbol);
		System.out.println(x.sumaELementosProfundidad(1));

	}

}
