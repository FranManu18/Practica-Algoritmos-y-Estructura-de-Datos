package tp2;
import java.util.*;
import tp2.ejercicio1.*;
public class Transformacion {
	private BinaryTree<Integer>arbol;
	
	public Transformacion(BinaryTree<Integer>arbol) {
		this.arbol=arbol;
	}
	
	public BinaryTree<Integer>suma(){
		sumaRecursivo(this.arbol);
		return this.arbol;
	}
	
	private int sumaRecursivo(BinaryTree<Integer>arbol){
		if(arbol==null){
			return 0;
		}
		int sumaIzquierda=sumaRecursivo(arbol.getLeftChild());
		int sumaDerecha=sumaRecursivo(arbol.getRightChild());
		int sumaAEntregar=sumaDerecha+sumaIzquierda+arbol.getData();
		arbol.setData(sumaDerecha+sumaIzquierda);
		return sumaAEntregar;
	}
	
	public static void preOrderTraversal(BinaryTree<Integer> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());
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
		rightChild.addLeftChild(leftRightChild);
		
		Transformacion x=new Transformacion(arbol);
		BinaryTree<Integer>transformado=x.suma();
		x.preOrderTraversal(transformado);
		
		

	}

}
