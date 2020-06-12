public class Usuario
{
	private String nombre;
	private String email;
	private String contraseña;
	//private String codigoRegistro;
	
	public Usuario(String nombre, String email, String Contraseña)
	{
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}
	public String getNombre()
	{
		return nombre;
	}
}
