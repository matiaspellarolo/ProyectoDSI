import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorCursos implements Serializable
{
	public ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public void mostrarCursos()
	{
		int i = 1;
		for(Curso curso: cursos)
		{
			System.out.println(i++ + "- " + curso.getNombre() + ".");
		}
	}
	public void agregarCurso(GestorDocentes gestorDocentes)
	{
		Scanner input = new Scanner(System.in);
		String nombre = "";
		String descripcion = "";
		System.out.println();
		System.out.println("Registro de nuevo curso:");
		System.out.print("- Nombre: ");
		nombre = input.nextLine();
		System.out.print("- Descripción: ");
		descripcion = input.nextLine();
		Curso curso = new Curso(nombre, descripcion);
		System.out.print("¿El curso cuenta con docente?[S/N]: ");
		char opcionDocente = input.next().charAt(0);
		if(opcionDocente == 'S')
		{
			Docente docente = gestorDocentes.retornarDocente();
			curso.agregarDocente(docente);
		}
		cursos.add(curso);
		System.out.println("Curso cargado exitosamente.");
	}
	public int cantidadCursos()
	{	
		return cursos.size();
	}

}
