import java.util.ArrayList;
import java.util.Scanner;
public class GestorCursantes 
{
	public static ArrayList<Cursante> cursantes = new ArrayList<Cursante>();
	
	public static int buscarCursante(int dni)
	{
		int pos = -1;
		int i = 0;
		for(Cursante cursante: cursantes)
		{
			if(dni == cursante.getDni())
			{
				pos = i;
			}
			i++;
		}
		return pos;
	}
	public static int registrarCursante()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nombre = input.nextLine();
		System.out.print("DNI: ");
		int dni = input.nextInt();
		System.out.print("Email: ");
		input.nextLine();
		String email = input.nextLine();
		System.out.print("Telefono: ");
		String telefono = input.nextLine();
		Cursante cursante = new Cursante (nombre, dni, email, telefono);
		return dni;
	}
}
