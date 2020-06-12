import java.util.ArrayList;
import java.util.Scanner;
public class GestorClientes
{
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	Scanner input = new Scanner(System.in);
	
	public static boolean verificarCliente(String email, String contraseña)
	{
		boolean usuarioExistente = false; 
		boolean usuarioValido = false; 
		for(Cliente cliente: clientes)
		{
			if(cliente.getEmail().compareTo(email) == 0)
			{
				if(cliente.getContraseña().compareTo(contraseña) == 0)
				{
					System.out.println("Usuario válido.");
					usuarioValido = true;
				}
				else
				{
					System.out.print("Contraseña incorrecta. ");
					usuarioValido = false;
				}
				usuarioExistente = true;
			}
		}
		if(usuarioExistente == false)
		{
			System.out.print("Usuario no válido. ");
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
