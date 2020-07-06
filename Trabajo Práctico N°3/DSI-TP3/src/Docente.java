public class Docente
{
	private String nombre;
	private int legajo;
	private String dni;
	private String telefono;
	private String email;
	private String direccion;
	private String titulo;
	
	public Docente(String nombre, int legajo, String dni, String telefono, String email, String direccion, String titulo)
	{
		this.nombre = nombre;
		this.legajo = legajo;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.titulo = titulo;
		GestorDocentes.docentes.add(this);
	}
	public int getLegajo() {return legajo;}
	public String getNombre() {return nombre;}
	public String toString() {return nombre;}
	
}
