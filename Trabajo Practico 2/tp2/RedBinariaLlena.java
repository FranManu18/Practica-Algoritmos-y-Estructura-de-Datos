package tp2;
import tp2.ejercicio1.*;
public class RedBinariaLlena {
	
	public int mayorRetardo(BinaryTree<Integer>arbol){
		return calcularMaximo(arbol,0);
	}
	
	private int calcularMaximo(BinaryTree<Integer>arbol,int max){
		if(arbol==null){
			return max;
		}
		max+=arbol.getData();
		if(arbol.isLeaf()){
			return max;
		}
		int ladoIzquierdo=calcularMaximo(arbol.getLeftChild(),max);
		int ladoDerecho=calcularMaximo(arbol.getRightChild(),max);
		return Math.max(ladoIzquierdo, ladoDerecho);
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
		
		RedBinariaLlena x= new RedBinariaLlena();
		System.out.println(x.mayorRetardo(arbol));

	}

}
