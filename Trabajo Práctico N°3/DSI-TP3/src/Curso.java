import java.util.Calendar;
import java.util.ArrayList;
public class Curso
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
		GestorCursos.cursos.add(this);
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
	public String getNombre(){return nombre;}
	public String getDescripcion(){return descripcion;}
	public String getFechas() {return fechas;}
	public String getHorario() {return horario;}
	public String getAula(){return aula;}
	public int getCupoMinimo(){return cupoMinimo;}
	public int getCupoMaximo(){return cupoMaximo;}
	public String getFechaLimiteInscripcion() {return ("Fecha: " + fechaLimiteInscripcion.get(Calendar.DATE) + "/" + (fechaLimiteInscripcion.get(Calendar.MONTH) + 1) + "/" + fechaLimiteInscripcion.get(Calendar.YEAR));}
	public boolean getCursoPlanificado() {return cursoPlanificado;}
	public void setFechas(String fechas) {this.fechas = fechas;}
	public void setHorario(String horario) {this.horario = horario;}
	public void setAula(String aula) {this.aula = aula;}
	public void setCupoMinimo(int cupoMinimo) {this.cupoMinimo = cupoMinimo;}
	public void setCupoMaximo(int cupoMaximo) {this.cupoMaximo = cupoMaximo;}
	public void setFechaLimiteInscripcion(Calendar fechaLimiteInscripcion) {this.fechaLimiteInscripcion = fechaLimiteInscripcion;}
	public void setCursoPlanificado(boolean cursoPlanificado) {this.cursoPlanificado = cursoPlanificado;}
}
