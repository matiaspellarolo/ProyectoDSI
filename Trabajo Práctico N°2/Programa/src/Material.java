public class Material
{
	private String nombre;
	private double precio;
	
	public Material(String nombre, double precio)
	{
		this.nombre = nombre;
		this.precio = precio;
		GestorMateriales.materiales.add(this);
	}
	public String getNombre()
	{
		return nombre;
	}
	public double getPrecio()
	{
		return precio;
	}
}
