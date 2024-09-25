package tp1.Ejercicio8;

public class DoubleEndedQueue<T> extends Queue<T> {
	public void enqueueFirst(T dato){
		super.enqueue(dato);
		while(!super.isEmpty()){
			super.enqueue(super.dequeue());
		}
	}
}
