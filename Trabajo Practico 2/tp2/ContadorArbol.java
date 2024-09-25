package tp2;
import java.util.*;
import tp2.ejercicio1.*;
public class ContadorArbol {
	private BinaryTree<Integer>arbol;
	
	public ContadorArbol(BinaryTree<Integer>arbol) {
		this.arbol=arbol;
	}

	public LinkedList<Integer> numeroParesInOrden(){
		if(this.arbol==null){
			return null;
		}
		LinkedList<Integer>lista=new LinkedList();
		recorridoInOrden(this.arbol,lista);
		return lista;
	}
	
	private void recorridoInOrden(BinaryTree<Integer>arbol,LinkedList<Integer>lista){
		if(arbol.hasLeftChild()){
			recorridoInOrden(arbol.getLeftChild(),lista);
		}
		if(arbol.getData()%2==0){
			lista.add(arbol.getData());
		}
		if(arbol.hasRightChild()){
			recorridoInOrden(arbol.getRightChild(),lista);
		}
	}
	
	public LinkedList<Integer> numeroParesPostOrden(){
		if(this.arbol==null){
			return null;
		}
		LinkedList<Integer>lista=new LinkedList();
		recorridoPostOrden(this.arbol,lista);
		return lista;
	}
	
	private void recorridoPostOrden(BinaryTree<Integer>arbol,LinkedList<Integer>lista){
		if(arbol.hasLeftChild()){
			recorridoPostOrden(arbol.getLeftChild(),lista);
		}
		if(arbol.hasRightChild()){
			recorridoPostOrden(arbol.getRightChild(),lista);
		}
		if(arbol.getData()%2==0){
			lista.add(arbol.getData());
		}
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
		BinaryTree<Integer>rightRightChild=new BinaryTree<Integer>(11);
		rightChild.addRightChild(rightRightChild);
		
		ContadorArbol x=new ContadorArbol(arbol);
		LinkedList<Integer>lista=x.numeroParesInOrden();
		for(int num:lista){
			System.out.println(num);
		}
		System.out.println("---------------------------------");
		lista=x.numeroParesPostOrden();
		for(int num:lista){
			System.out.println(num);
		}
	}

}
