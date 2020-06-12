import java.util.Scanner;
public class Cliente
{
	private String nombre;
	private String apellido;
	private String empresa;
	private String domicilioObra;
	private String email;
	private String telefono;
	private String contrase�a;
	
	public Cliente(String nombre, String apellido, String empresa, String domicilioObra, String email, String telefono, String contrase�a)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.empresa = empresa;
		this.domicilioObra = domicilioObra;
		this.email = email;
		this.telefono = telefono;
		this.contrase�a = contrase�a;
		
		GestorClientes.clientes.add(this);
	}
	public Cliente()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nREGISTRAR CLIENTE:");
		System.out.print("- Nombre: ");
		nombre = input.next();
		System.out.print("- Apellido: ");
		apellido = input.next();
		System.out.print("- Empresa: ");
		empresa = input.next();
		System.out.print("- Domicilio de la obra: ");
		domicilioObra = input.next();
		System.out.print("- Email: ");
		email = input.next();
		System.out.print("- Tel�fono: ");
		telefono = input.next();
		System.out.print("- Contrase�a: ");
		contrase�a = input.next();
		System.out.println("USUARIO REGISTRADO.\n");
		
		GestorClientes.clientes.add(this);
	}
	public String getEmail()
	{
		return email;
	}
	public String getContrase�a()
	{
		return contrase�a;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getApellido()
	{
		return apellido;
	}
	
}
