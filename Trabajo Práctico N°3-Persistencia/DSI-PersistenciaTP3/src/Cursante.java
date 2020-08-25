import java.io.Serializable;

public class Cursante implements Serializable
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
	}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getNombre() {return nombre;}
	public void setDni(int dni) {this.dni = dni;}
	public int getDni() {return dni;}
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public void setTelefono(String telefono) {this.telefono = telefono;}
}
