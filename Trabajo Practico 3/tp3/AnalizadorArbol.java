package tp3;
import tp1.Ejercicio8.Queue;
import java.util.List;
import java.util.LinkedList;
public class AnalizadorArbol {
	
	public double devolverMayorPromedio(GeneralTree<AreaEmpresa>arbol) {
		if(arbol.isEmpty()) {
			return 0;
		}
		double maxPromedio=0;
		Queue<GeneralTree<AreaEmpresa>>cola=new Queue();
		cola.enqueue(arbol);
		while(!cola.isEmpty()) {
			int CantNodos=cola.size();
			int suma=0;
			for(int i=0;i<CantNodos;i++) {
				GeneralTree<AreaEmpresa>frente=cola.dequeue();
				suma+=frente.getData().getTime();
				List<GeneralTree<AreaEmpresa>>children=frente.getChildren();
				for(GeneralTree<AreaEmpresa>child:children) {
					cola.enqueue(child);
				}
			}
			double promedioActual=suma/CantNodos;
			maxPromedio=Math.max(maxPromedio, promedioActual);		
		}
		return maxPromedio;
	}
	public static void main(String[] args) {
		AreaEmpresa rootArea = new AreaEmpresa("Headquarters", 100);
        AreaEmpresa subArea1 = new AreaEmpresa("Marketing", 80);
        AreaEmpresa subArea2 = new AreaEmpresa("Development", 120);
        AreaEmpresa subArea3 = new AreaEmpresa("Sales", 90);
        AreaEmpresa subArea4 = new AreaEmpresa("HR", 110);
        AreaEmpresa subArea5 = new AreaEmpresa("Support", 95);

        // Crear los subárboles
        GeneralTree<AreaEmpresa> root = new GeneralTree<>(rootArea);
        GeneralTree<AreaEmpresa> child1 = new GeneralTree<>(subArea1);
        GeneralTree<AreaEmpresa> child2 = new GeneralTree<>(subArea2);
        GeneralTree<AreaEmpresa> child3 = new GeneralTree<>(subArea3);
        GeneralTree<AreaEmpresa> child4 = new GeneralTree<>(subArea4);
        GeneralTree<AreaEmpresa> child5 = new GeneralTree<>(subArea5);

        // Establecer relaciones padre-hijo
        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<>();
        children1.add(child1);
        children1.add(child2);
        root.setChildren(children1);

        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<>();
        children2.add(child3);
        children2.add(child4);
        children2.add(child5);
        child2.setChildren(children2);
        
        AnalizadorArbol x=new AnalizadorArbol();
        System.out.println(x.devolverMayorPromedio(root));
	}

}
