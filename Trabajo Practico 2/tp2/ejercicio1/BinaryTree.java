package tp2.ejercicio1;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	   if(this.isEmpty()){		   
		   return 0;
	   }else{
		   if(this.isLeaf()){
			   return 1;
		   }else{
			   int hojasIzquierda=(this.hasLeftChild())?this.leftChild.contarHojas():0;
			   int hojasDerecha=(this.hasRightChild())?this.rightChild.contarHojas():0;
			   return hojasIzquierda+hojasDerecha;
		   }
	   }
	   
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	if(this.isEmpty()){  		
    		return null;
    	}else{
    		BinaryTree<T>espejo=new BinaryTree<T>();
    		if(this.hasLeftChild()){
    			espejo.addRightChild(this.leftChild.espejo());
    		}
    		if(this.hasRightChild()){
    			espejo.addLeftChild(this.rightChild.espejo());
    		}
    		return espejo;
    	}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		recorridoNiveles(this,n,m);
   }
	private void recorridoNiveles(BinaryTree<T>arbol,int n,int m){
		if(arbol==null){
			return;
		}
		Queue<BinaryTree<T>>cola=new LinkedList();
		cola.add(arbol);
		int nivelActual=0;
		while(!cola.isEmpty() && nivelActual<=m){
			int cantNodos=cola.size();
			if(nivelActual>=n){
				for(int i=0;i<cantNodos;i++){
					BinaryTree<T>top=cola.poll();
					System.out.println(top.data+" ");
					if(top.hasLeftChild()){
						cola.add(leftChild);
					}
					if(top.hasRightChild()){
						cola.add(rightChild);
					}
				}
			}else{
				for(int i=0;i<cantNodos;i++){
					BinaryTree<T>top=cola.poll();
					if(top.hasLeftChild()){
						cola.add(leftChild);
					}
					if(top.hasRightChild()){
						cola.add(rightChild);
					}
				}
			}
			nivelActual++;			
			
		}
		
	}
}
