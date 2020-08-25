import java.util.Calendar;
import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable
{
	private String nombre;
	private String descripcion;
	private ArrayList<Docente> docentes;
	private String fechas;
	private String horario;
	private String aula;
	private int cupoMinimo, cupoMaximo;
	private Calendar fechaLimiteInscripcion;
	private boolean cursoPlanificado;
	private boolean cursoConfirmado;
	private ArrayList<Cursante> cursantes;
	
	public Curso(String nombre, String descripcion)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		docentes = new ArrayList<Docente>();
		fechas = "";
		horario = "";
		aula = "";
		cupoMinimo = 0;
		cupoMaximo = 0;
		cursoPlanificado = false;
		cursoConfirmado = false;
		cursantes = new ArrayList<Cursante>();
	}
	public boolean verificarCapacidad()
	{
		if(cursantes.size() == cupoMaximo) return false;
		else return true;
	}
	public boolean verificarCupo()
	{
		if(cursantes.size() >= cupoMinimo) return true;
		else return false;
	}
	public void agregarDocente(Docente docente)
	{
		docentes.add(docente);
		System.out.println(docente.getNombre() + " fue asignado con éxito al curso " + nombre + ".");
	}
	public void removerDocente(int pos)
	{
		Docente docente = docentes.get(pos);
		docentes.remove(pos);
		System.out.println(docente.getNombre() + " fue removido con éxito del curso " + nombre + ".");
	}
	public void mostrarDocentes()
	{
		int i = 1;
		for(Docente docente: docentes)
		{
			System.out.println(i++ + "- " + docente.getNombre() + ".");
		}
	}
	public int cantidadDocentes()
	{
		return docentes.size();
	}
	public void agregarCursante(Cursante cursante)
	{
		cursantes.add(cursante);
	}
	public void confirmarCancelarCurso(boolean cursoConformado)
	{
		this.cursoConfirmado = cursoConfirmado;
		if(!cursoConfirmado) cursoPlanificado = false;
	}
	public void serNombre(String nombre) {this.nombre = nombre;}
	public String getNombre(){return nombre;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public String getDescripcion(){return descripcion;}
	public void setDocentes(ArrayList<Docente> docentes) {this.docentes = docentes;}
	public ArrayList<Docente> getDocentes(){return docentes;}
	public void setFechas(String fechas) {this.fechas = fechas;}
	public String getFechas() {return fechas;}
	public void setHorario(String horario) {this.horario = horario;}
	public String getHorario() {return horario;}
	public void setAula(String aula) {this.aula = aula;}
	public String getAula(){return aula;}
	public void setCupoMinimo(int cupoMinimo) {this.cupoMinimo = cupoMinimo;}
	public int getCupoMinimo(){return cupoMinimo;}
	public void setCupoMaximo(int cupoMaximo) {this.cupoMaximo = cupoMaximo;}
	public int getCupoMaximo(){return cupoMaximo;}
	public void setFechaLimiteInscripcion(Calendar fechaLimiteInscripcion) {this.fechaLimiteInscripcion = fechaLimiteInscripcion;}
	public Calendar getFechaLimiteInscripcion() {return fechaLimiteInscripcion;}
	public void setCursoPlanificado(boolean cursoPlanificado) {this.cursoPlanificado = cursoPlanificado;}
	public boolean getCursoPlanificado() {return cursoPlanificado;}
	public void setCursoConfirmado(boolean cursoConfirmado) {this.cursoConfirmado= cursoConfirmado;}
	public boolean getCursoConfirmado() {return cursoConfirmado;}
	public void setCursantes(ArrayList<Cursante> cursantes) {this.cursantes = cursantes;}
	public ArrayList<Cursante> getCursantes(){return cursantes;}	
}
