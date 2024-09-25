package tp1;
import java.util.*;
public class Ejercicio3 {

	public static void main(String[] args) {
		ArrayList<Estudiante> estudiantes = new ArrayList<>();  // Usando ArrayList en lugar de un array fijo
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        Estudiante est1 = new Estudiante();
        est1.setNombre("Francisco");
        est1.setApellido("Penetta");
        est1.setComision(2);
        est1.setEmail("Franciscopenettta@gmail.com");
        est1.setDireccion("Diagonal 73");
        estudiantes.add(est1);

        Estudiante est2 = new Estudiante();
        est2.setNombre("Nicolas");
        est2.setApellido("Penetta");
        est2.setComision(1);
        est2.setEmail("Nicolaspenettta@gmail.com");
        est2.setDireccion("Diagonal 71");
        estudiantes.add(est1);

       
        Profesor prof1 = new Profesor();
        prof1.setNombre("Roberto");
        prof1.setApellido("Rodriguez");
        prof1.setEmail("RobertoRodriguez@gmail.com");
        prof1.setCatedra("Matematicas");
        prof1.setFacultad("Informatica");
        profesores.add(prof1);

        Profesor prof2 = new Profesor();
        prof2.setNombre("Julian");
        prof2.setApellido("Alvarez");
        prof2.setEmail("JulianAlvarez@gmail.com");
        prof2.setCatedra("CADP");
        prof2.setFacultad("Informatica");
        profesores.add(prof2);

        Profesor prof3 = new Profesor();
        prof3.setNombre("Pedro");
        prof3.setApellido("Aznar");
        prof3.setEmail("PedroAznar@gmail.com");
        prof3.setCatedra("Matematicas");
        prof3.setFacultad("Psicologia");
        profesores.add(prof3);


        for (Estudiante est:estudiantes) {
            System.out.println(est.tusDatos());
        }
        
        for(Profesor prof:profesores){
        	System.out.println(prof.tusDatos());
        }
	}

}
