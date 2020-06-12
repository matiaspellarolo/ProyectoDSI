import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Presupuesto
{
	private Cliente cliente;
	private Material material;
	private double precio;
	private float metrosCuadrados;
	private Espesor espesor;
	private Calendar fechaValidez;
	
	public Presupuesto(Cliente cliente, Material material, double precio, float metrosCuadrados, Espesor espesor)
	{
		this.cliente = cliente;
		this.material = material;
		this.precio = precio;
		this.metrosCuadrados = metrosCuadrados;
		this.espesor = espesor;
		Calendar fechaValidez = new GregorianCalendar();
		fechaValidez.add(Calendar.DATE, 30);
		System.out.print("Fecha de validez: ");
		System.out.println("Fecha: " + fechaValidez.get(Calendar.DATE) + "/" + (fechaValidez.get(Calendar.MONTH) + 1) + "/" + fechaValidez.get(Calendar.YEAR));

		
		GestorPresupuestos.presupuestos.add(this);
	}
	public String toString()
	{
		return  "- Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + ".\n" + 
				"- Material: " + material.getNombre() + " - $" + material.getPrecio() + " por bolsa.\n" + 
				"- Metros cuadrados: " + metrosCuadrados + ".\n" + 
				"- Espesor: " + espesor.getLongitud() + " - $" + espesor.getPrecio() + " por metro cuadrado.\n" + 
				"- Precio: $" + String.format("%.2f", precio) + ".";
	}
	/*public String getFechaValidez()
	{
		return "" + fechaValidez.get(Calendar.DATE) + "/" + (fechaValidez.get(Calendar.MONTH) + 1) + "/" + fechaValidez.get(Calendar.YEAR);
	}
	public String getFechaValidez()
	{
		return fechaValidez.getTime();
	}*/
}
