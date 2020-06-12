public class Espesor
{
	private float longitud;
	private double precio;
	
	public Espesor(float longitud, double precio)
	{
		this.longitud = longitud;
		this.precio = precio;
		GestorEspesores.espesores.add(this);
	}
	public float getLongitud()
	{
		return longitud;
	}
	public double getPrecio()
	{
		return precio;
	}
}
