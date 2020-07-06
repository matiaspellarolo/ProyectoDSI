public class Cursante
{
	private String nombre;
	private int dni;
	private String email;
	private String telefono;
	
	public Cursante(String nombre, int dni, String email, String telefono)
	{
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		GestorCursantes.cursantes.add(this);
	}
	public int getDni() {return dni;}
	public String getNombre() {return nombre;}
}
