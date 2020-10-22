public class MedioPago
{
	private String descripcion;
	private int cuotas;
	
	public MedioPago(String descripcion, int cuotas)
	{
		this.descripcion = descripcion;
		this.cuotas = cuotas;
		GestorMediosPago.mediosPago.add(this);
	}
	public String getDescripcion() {return descripcion;}
	public int getCuotas() {return cuotas;}
	
	public String toString()
	{
		return "Medio de pago: " + descripcion + " - Cuotas: " + cuotas + ".";
	}
}
