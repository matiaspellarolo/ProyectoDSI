import java.util.ArrayList;
import java.util.Scanner;
public class GestorDocentes
{
	public static ArrayList<Docente> docentes = new ArrayList<Docente>();
	
	public static int buscarDocente(int legajoDocente)
	{
		int pos = -1;
		int i = 0;
		for(Docente docente: docentes)
		{
			if(legajoDocente == docente.getLegajo())
			{
				pos = i;
			}
			i++;
		}
		return pos;
	}
	public static Docente retornarDocente()
	{
		Scanner input = new Scanner(System.in);
		Docente docente = null;
		int posDocente;
		System.out.print("Legajo de docente: ");
		do {
		int legajoDocente = input.nextInt();
		posDocente = buscarDocente(legajoDocente);
		if(posDocente != -1)
		{
			docente = docentes.get(posDocente);
		}
		else
		{
			System.out.print("Legajo no existente. Vuelva a ingresar: ");
		}
		}while(posDocente == -1);
		return docente;
	}
}
