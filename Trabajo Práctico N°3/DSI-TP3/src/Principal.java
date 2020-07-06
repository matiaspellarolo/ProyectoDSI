import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Principal
{
	public static void main(String[] ar)
	{
		Cursante cursante1 = new Cursante("Matías Pellarolo", 42048241, "matiaspellarolo@gmail.com", "3564330457");
		Docente docente1 = new Docente("Pablo Pioli", 1, "25432120", "3564521149", "pablopioli@gmail.com", "Sarmiento 325", "Ingeniero en Sistemas");
		Docente docente2 = new Docente("Juan Pablo Ferreyra", 2, "29324841", "3564953314", "juanpablof@gmail.com", "Colón 738", "Ingeniero en Sistemas");
		Curso curso1 = new Curso("Excel", "para alumnos");
		Curso curso2 = new Curso("PowerPoint", "para alumnos");
		Scanner input = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\tMENÚ:");
			System.out.println("1- Cargar nuevo curso.");
			System.out.println("2- Asignar/remover docente de curso.");
			System.out.println("3- Planificar dictado de curso.");
			System.out.println("4- Registrar inscripción.");
			System.out.println("5- Verificar cupo de inscriptos a curso.");
			System.out.println("6- Conformar/cancelar cursos.");
			System.out.println("7- Salir.");
			System.out.print("Opción: ");
			opcion = input.nextInt();
			switch(opcion)
			{
			case 1:
				GestorCursos.agregarCurso();
				break;
			case 2:
				asignarRemoverDocente();
				break;
			case 3:
				planificarCurso();
				break;
			case 4:
				registrarSolicitud();
				break;
			case 5:
				verificarCupoDeCurso();
				break;
			case 6:
				confirmarCancelarCurso();
				break;
			}
			System.out.println();
		}while(opcion != 7);
	}
	public static void asignarRemoverDocente()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("CURSOS:");
		GestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = GestorCursos.cursos.get(opcionCurso - 1);
		System.out.print("1- Asignar docente.\n2- Remover docente.\nOpción: ");
		int opcion = input.nextInt();
		if(opcion == 1)
		{
			Docente docente = GestorDocentes.retornarDocente();
			curso.agregarDocente(docente);
		}
		else
		{
			curso.mostrarDocentes();
			System.out.print("Número de docente: ");
			int opcionDocente = input.nextInt();
			curso.removerDocente(opcionDocente - 1);
		}
	}
	public static void planificarCurso()
	{
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Planificar curso:");
		GestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = GestorCursos.cursos.get(opcionCurso - 1); 
		System.out.println("CURSO: " + curso.getNombre());
		if(curso.cantidadDocentes() == 0)
		{
			Docente docente = GestorDocentes.retornarDocente();
			curso.agregarDocente(docente);
		}
		else
		{
			System.out.println("- Docente/s: ");
			curso.mostrarDocentes();
		}
		System.out.print("- Fechas de dictado: ");
		input.nextLine();
		String fechas = input.nextLine();
		curso.setFechas(fechas);
		System.out.print("- Horario de dictado: ");
		String horario = input.nextLine();
		curso.setHorario(horario);
		System.out.print("- Aula: ");
		String aula = input.nextLine();
		curso.setAula(aula);
		System.out.print("- Cupo mínimo: ");
		int cupoMinimo = input.nextInt();
		curso.setCupoMinimo(cupoMinimo);
		System.out.print("- Cupo máximo: ");
		int cupoMaximo = input.nextInt();
		curso.setCupoMaximo(cupoMaximo);
		Calendar fechaLimiteInscripcion = ingresarFecha();
		curso.setFechaLimiteInscripcion(fechaLimiteInscripcion);
		curso.setCursoPlanificado(true);
	}
	public static Calendar ingresarFecha()
	{
		Scanner input = new Scanner(System.in);
		Calendar fecha = new GregorianCalendar();
		String fechaS;
		int control;
		do {
			System.out.print("Ingresar fecha límite de inscripción [dd/mm/aaaa]: ");
			fechaS = input.next();
			if(fechaS.length() == 10)
				{
				control = 1;
				}
			else
				{
				System.out.println("Ingrese correctamente la fecha.");
				control = 0;
				}
		} while(control != 1);

		int dia = Integer.parseInt(fechaS.substring(0, 2));
		int mes = Integer.parseInt(fechaS.substring(3, 5)) - 1;
		int año = Integer.parseInt(fechaS.substring(6, 10));
		
		fecha.set(Calendar.DATE, dia);
		fecha.set(Calendar.MONTH, mes);
		fecha.set(Calendar.YEAR, año);
		
		return fecha;
	}
	public static void registrarSolicitud()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		GestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = GestorCursos.cursos.get(opcionCurso - 1);
		if(curso.getCursoPlanificado() == false)
		{
			System.out.println("El curso todavía no fue planificado.");
		}
		else 
		{
			if(curso.verificarCapacidad())
			{
				System.out.print("¿La persona está registrada?[S/N]: ");
				char opcionPersonaRegistrada = input.next().charAt(0);
				int dni;
				if(opcionPersonaRegistrada == 'S')
				{
					System.out.print("DNI de la persona: ");
					dni = input.nextInt();		
				}
				else
				{
					dni = GestorCursantes.registrarCursante();	
				}
				int posCursante = GestorCursantes.buscarCursante(dni);
				Cursante cursante = GestorCursantes.cursantes.get(posCursante);
				curso.agregarCursante(cursante);
				System.out.println("La persona " + cursante.getNombre() + " fue añadida al curso \"" + curso.getNombre() + "\" exitosamente.");
			}
			else System.out.println("El curso ya no tiene cupos vacantes.");
		}
	}
	public static void verificarCupoDeCurso()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		GestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = GestorCursos.cursos.get(opcionCurso - 1);
		if(curso.getCursoPlanificado() == false)
		{
			System.out.println("El curso todavía no fue planificado.");
		}
		else 
		{
			if(curso.verificarCupo()) System.out.println("El curso ya alcanzó el cupo mínimo.");
			else System.out.println("El curso todavía no alcanzó el cupo mínimo.");
		}
	}
	public static void confirmarCancelarCurso()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		GestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = GestorCursos.cursos.get(opcionCurso - 1);
		if(curso.getCursoPlanificado() == false)
		{
			System.out.println("El curso todavía no fue planificado.");
		}
		else 
		{
			System.out.println("1- Confirmar curso.");
			System.out.println("2- Cancelar curso.");
			System.out.print("Opción: ");
			int opcionConfirmarCancelar = input.nextInt();
			boolean opcion;
			if(opcionConfirmarCancelar == 1) 
				{
					opcion = true;
					System.out.println("El curso " + curso.getNombre() + " fue confirmado con éxito.");
				}
			else 
				{
					opcion = false;
					System.out.println("El curso " + curso.getNombre() + " fue cancelado con éxito.");
				}
			curso.confirmarCancelarCurso(opcion);
		}
	}
}
