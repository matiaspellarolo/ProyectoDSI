public class Usuario
{
	private String nombre;
	private String email;
	private String contrase�a;
	//private String codigoRegistro;
	
	public Usuario(String nombre, String email, String Contrase�a)
	{
		this.nombre = nombre;
		this.email = email;
		this.contrase�a = contrase�a;
	}
	public String getNombre()
	{
		return nombre;
	}
}
