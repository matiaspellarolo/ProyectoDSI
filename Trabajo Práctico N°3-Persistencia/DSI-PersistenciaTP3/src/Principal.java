import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal
{
	public static void main(String[] ar)
	{
		GestorCursantes gestorCursantes = new GestorCursantes();
		//Cursante cursante1 = new Cursante("Matías Pellarolo", 42048241, "matiaspellarolo@gmail.com", "3564330457");
		//gestorCursantes.cursantes.add(cursante1);
		gestorCursantes = cargarDatosCursantes();
		
		GestorDocentes gestorDocentes = new GestorDocentes();
		//Docente docente1 = new Docente("Pablo Pioli", 1, "25432120", "3564521149", "pablopioli@gmail.com", "Sarmiento 325", "Ingeniero en Sistemas");
		//gestorDocentes.docentes.add(docente1);
		//Docente docente2 = new Docente("Juan Pablo Ferreyra", 2, "29324841", "3564953314", "juanpablof@gmail.com", "Colón 738", "Ingeniero en Sistemas");
		//gestorDocentes.docentes.add(docente2);
		gestorDocentes = cargarDatosDocentes();
		
		GestorCursos gestorCursos = new GestorCursos();
		//Curso curso1 = new Curso("Excel", "para alumnos");
		//gestorCursos.cursos.add(curso1);
		//Curso curso2 = new Curso("PowerPoint", "para alumnos");
		//gestorCursos.cursos.add(curso2);
		gestorCursos = cargarDatosCursos();
		
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
				gestorCursos.agregarCurso(gestorDocentes);
				break;
			case 2:
				asignarRemoverDocente(gestorCursos, gestorDocentes);
				break;
			case 3:
				planificarCurso(gestorCursos, gestorDocentes);
				break;
			case 4:
				registrarSolicitud(gestorCursantes, gestorCursos);
				break;
			case 5:
				verificarCupoDeCurso(gestorCursos);
				break;
			case 6:
				confirmarCancelarCurso(gestorCursos);
				break;
			}
			System.out.println();
		}while(opcion != 7);
		
		guardarDatosCursantes(gestorCursantes);
		guardarDatosCursos(gestorCursos);
		guardarDatosDocentes(gestorDocentes);
	}
	public static GestorCursantes cargarDatosCursantes()
	{
		GestorCursantes gestorCursantesR = null;
		
		ObjectInputStream lectorDeObjetos;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("Cursantes.json"));
			gestorCursantesR = (GestorCursantes) lectorDeObjetos.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return gestorCursantesR;
	}
	public static void guardarDatosCursantes(GestorCursantes gestorCursantes)
	{
		try {
			ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("Cursantes.json"));
			escritorDeObjetos.writeObject(gestorCursantes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static GestorCursos cargarDatosCursos()
	{
		GestorCursos gestorCursosR = null;
		
		ObjectInputStream lectorDeObjetos;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("Cursos.json"));
			gestorCursosR = (GestorCursos) lectorDeObjetos.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return gestorCursosR;
	}
	public static void guardarDatosCursos(GestorCursos gestorCursos)
	{
		try {
			ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("Cursos.json"));
			escritorDeObjetos.writeObject(gestorCursos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static GestorDocentes cargarDatosDocentes()
	{
		GestorDocentes gestorDocentesR = null;
		
		ObjectInputStream lectorDeObjetos;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("Docentes.json"));
			gestorDocentesR = (GestorDocentes) lectorDeObjetos.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return gestorDocentesR;
	}
	public static void guardarDatosDocentes(GestorDocentes gestorDocentes)
	{
		try {
			ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("Docentes.json"));
			escritorDeObjetos.writeObject(gestorDocentes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static void asignarRemoverDocente(GestorCursos gestorCursos, GestorDocentes gestorDocentes)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("CURSOS:");
		gestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = gestorCursos.cursos.get(opcionCurso - 1);
		System.out.print("1- Asignar docente.\n2- Remover docente.\nOpción: ");
		int opcion = input.nextInt();
		if(opcion == 1)
		{
			Docente docente = gestorDocentes.retornarDocente();
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
	public static void planificarCurso(GestorCursos gestorCursos, GestorDocentes gestorDocentes)
	{
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Planificar curso:");
		gestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = gestorCursos.cursos.get(opcionCurso - 1); 
		System.out.println("CURSO: " + curso.getNombre());
		if(curso.cantidadDocentes() == 0)
		{
			Docente docente = gestorDocentes.retornarDocente();
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
	public static void registrarSolicitud(GestorCursantes gestorCursantes, GestorCursos gestorCursos)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		gestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = gestorCursos.cursos.get(opcionCurso - 1);
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
					dni = gestorCursantes.registrarCursante();	
				}
				int posCursante = gestorCursantes.buscarCursante(dni);
				Cursante cursante = gestorCursantes.cursantes.get(posCursante);
				curso.agregarCursante(cursante);
				System.out.println("La persona " + cursante.getNombre() + " fue añadida al curso \"" + curso.getNombre() + "\" exitosamente.");
			}
			else System.out.println("El curso ya no tiene cupos vacantes.");
		}
	}
	public static void verificarCupoDeCurso(GestorCursos gestorCursos)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		gestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = gestorCursos.cursos.get(opcionCurso - 1);
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
	public static void confirmarCancelarCurso(GestorCursos gestorCursos)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cursos:");
		gestorCursos.mostrarCursos();
		System.out.print("Opción: ");
		int opcionCurso = input.nextInt();
		Curso curso = gestorCursos.cursos.get(opcionCurso - 1);
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
