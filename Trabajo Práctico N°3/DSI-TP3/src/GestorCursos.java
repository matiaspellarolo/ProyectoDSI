import java.util.Scanner;
import java.util.ArrayList;

public class GestorCursos 
{
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public static void mostrarCursos()
	{
		int i = 1;
		for(Curso curso: cursos)
		{
			System.out.println(i++ + "- " + curso.getNombre() + ".");
		}
	}
	public static void agregarCurso()
	{
		Scanner input = new Scanner(System.in);
		String nombre = "";
		String descripcion = "";
		System.out.println();
		System.out.println("Registro de nuevo curso:");
		System.out.print("- Nombre: ");
		nombre = input.nextLine();
		System.out.print("- Descripci�n: ");
		descripcion = input.nextLine();
		Curso curso = new Curso(nombre, descripcion);
		System.out.print("�El curso cuenta con docente?[S/N]: ");
		char opcionDocente = input.next().charAt(0);
		if(opcionDocente == 'S')
		{
			Docente docente = GestorDocentes.retornarDocente();
			curso.agregarDocente(docente);
		}
		System.out.println("Curso cargado exitosamente.");
	}

	public static int cantidadCursos()
	{	
		return cursos.size();
	}

}
