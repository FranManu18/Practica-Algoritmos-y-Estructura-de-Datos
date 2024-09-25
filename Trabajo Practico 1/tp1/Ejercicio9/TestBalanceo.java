package tp1.Ejercicio9;
import java.util.*;
public class TestBalanceo {
	
	private boolean coincide(char car1,char car2){
		 return (car1 == '(' && car2 == ')') || (car1 == '[' && car2 == ']') || (car1 == '{' && car2 == '}');
		
	}
	
	
	public boolean estaBalanceado(String cadena){
		if(cadena.equals("")){
			return true;
		}
		boolean termino=false;
		boolean balance=true;
		Stack<Character> pila=new Stack<Character>();
		for (int i = 0; i < cadena.length(); i++) {
            char car = cadena.charAt(i);          
            if (car == '(' || car == '[' || car == '{') {
                pila.push(car);
            } 
            else if (car == ')' || car == ']' || car == '}') {
                if (pila.isEmpty()) {
                    return false; // No hay nada para coincidir con un paréntesis de cierre
                }
                char aux = pila.pop();
                if (!coincide(aux, car)) {
                    return false; // Los paréntesis no coinciden
                }
            }
        }
		return pila.isEmpty();
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String cadena=scanner.next();
		TestBalanceo x=new TestBalanceo();
		if(x.estaBalanceado(cadena)){
			System.out.println("La cadena esta balanceada");
		}else{
			System.out.println("La cadena no esta balanceada");
		}

	}

}
