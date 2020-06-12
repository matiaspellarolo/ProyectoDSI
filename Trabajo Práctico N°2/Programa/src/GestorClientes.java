import java.util.ArrayList;
import java.util.Scanner;
public class GestorClientes
{
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	Scanner input = new Scanner(System.in);
	
	public static boolean verificarCliente(String email, String contrase�a)
	{
		boolean usuarioExistente = false; 
		boolean usuarioValido = false; 
		for(Cliente cliente: clientes)
		{
			if(cliente.getEmail().compareTo(email) == 0)
			{
				if(cliente.getContrase�a().compareTo(contrase�a) == 0)
				{
					System.out.println("Usuario v�lido.");
					usuarioValido = true;
				}
				else
				{
					System.out.print("Contrase�a incorrecta. ");
					usuarioValido = false;
				}
				usuarioExistente = true;
			}
		}
		if(usuarioExistente == false)
		{
			System.out.print("Usuario no v�lido. ");
			usuarioValido = false;
		}
		return usuarioValido;
	}
	public static void mostrarClientes()
	{
		System.out.println("LISTADO DE CLIENTES:");
		for(Cliente cliente: clientes)
		{
			System.out.println("- " + cliente.getApellido() + ", " + cliente.getNombre() + ".");
		}
	}
}
