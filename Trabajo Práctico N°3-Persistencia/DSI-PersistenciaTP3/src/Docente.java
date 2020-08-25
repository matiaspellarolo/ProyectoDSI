import java.io.Serializable;

public class Docente implements Serializable
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
	}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getNombre() {return nombre;}
	public void setLegajo(int legajo) {this.legajo = legajo;}
	public int getLegajo() {return legajo;}
	public void setDni(String dni) {this.dni = dni;}
	public String getDni() {return dni;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
	public String getTelefono() {return telefono;}
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	public String getDireccion() {return direccion;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public String getTitulo() {return titulo;}
	
	public String toString() {return nombre;}
	
}
