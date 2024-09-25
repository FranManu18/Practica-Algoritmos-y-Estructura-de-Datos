package tp1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	List<T> data;
	public Queue() {
		this.data=new ArrayList<T>();
	}
	public void enqueue(T dato){
		data.add(dato);
	}
	public T dequeue(){
		return data.remove(0);
	}
	public T head(){
		return data.get(0);
	}
	
	public int size() {
		return data.size();
	}

	
	public boolean isEmpty() {
		return data.isEmpty();
	}

	
	public String toString() {
		String str="[ ";
		for(T d:data){
			str= str + d + ", ";
		}
		str=str.substring(0,str.length()-2)+"]";
		return str;
	}
}
