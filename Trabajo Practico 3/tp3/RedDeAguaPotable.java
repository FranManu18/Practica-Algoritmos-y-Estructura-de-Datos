package tp3;
import java.util.List;
import java.util.LinkedList;
public class RedDeAguaPotable {
	private GeneralTree<Character>arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		if(this.arbol.isEmpty()) {
			return caudal;
		}
		return BuscarMinimo(this.arbol,caudal);
	}
	
	private double BuscarMinimo(GeneralTree<Character>nodo,double caudal) {
		if(nodo.isLeaf()) {
			return caudal;
		}
		List<GeneralTree<Character>>children=nodo.getChildren();
		double minCaudal=Double.MAX_VALUE;
		for(GeneralTree<Character> child:children) {
			double caudalHijo=BuscarMinimo(child,caudal/children.size());
			minCaudal=Math.min(minCaudal, caudalHijo);
		}
		return minCaudal;
		
	}
	public static void main(String[] args) {
		GeneralTree<Character> root = new GeneralTree<>('A');
        GeneralTree<Character> b = new GeneralTree<>('B');
        GeneralTree<Character> c = new GeneralTree<>('C');
        GeneralTree<Character> d = new GeneralTree<>('D');
        GeneralTree<Character> e = new GeneralTree<>('E');
        GeneralTree<Character> f = new GeneralTree<>('F');
        GeneralTree<Character> g = new GeneralTree<>('G');
        GeneralTree<Character> h = new GeneralTree<>('H');
        GeneralTree<Character> i = new GeneralTree<>('I');
        GeneralTree<Character> j = new GeneralTree<>('J');
        GeneralTree<Character> k = new GeneralTree<>('K');
        GeneralTree<Character> l = new GeneralTree<>('L');
        GeneralTree<Character> m = new GeneralTree<>('M');
        GeneralTree<Character> n = new GeneralTree<>('N');
        GeneralTree<Character> p = new GeneralTree<>('P');
        
        // Establecer relaciones padre-hijo
        List<GeneralTree<Character>> childrenA = new LinkedList<>();
        childrenA.add(b);  // B
        childrenA.add(c);  // C
        childrenA.add(d);  // D
        childrenA.add(e);  // E
        root.setChildren(childrenA);  // A es el padre de B, C, D y E
        
        List<GeneralTree<Character>> childrenC = new LinkedList<>();
        childrenC.add(f);  // F
        childrenC.add(g);  // G
        c.setChildren(childrenC);  // C es el padre de F y G
        
        List<GeneralTree<Character>> childrenD = new LinkedList<>();
        childrenD.add(h);  // H
        childrenD.add(i);  // I
        childrenD.add(j);  // J
        d.setChildren(childrenD);  // D es el padre de H, I y J
        
        List<GeneralTree<Character>> childrenJ = new LinkedList<>();
        childrenJ.add(m);  // M
        childrenJ.add(n);  // N
        j.setChildren(childrenJ);  // J es el padre de M y N
        
        List<GeneralTree<Character>> childrenE = new LinkedList<>();
        childrenE.add(k);  // K
        childrenE.add(p);  // P
        e.setChildren(childrenE);  // E es el padre de K y P
        
        // Establecer relación padre-hijo entre G y L
        List<GeneralTree<Character>> childrenG = new LinkedList<>();
        childrenG.add(l);  // L
        g.setChildren(childrenG);  // G es el padre de L
        
        RedDeAguaPotable x=new RedDeAguaPotable(root);
        
        System.out.println(x.minimoCaudal(1000));
	}

}
