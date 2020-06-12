public class Articulo
{
	private String nombre;
	private String marca;
	private double precio;
	private int cantidad;
	//private String descripcion;
	//private foto;
	
	public Articulo(String nombre, String marca, double precio, int cantidad)
	{
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
		GestorArticulos.articulos.add(this);
	}
	public String getNombre() {return nombre;}
	public double getPrecio() {return precio;}
	public int getCantidad() {return cantidad;}
	public void setCantidad(int cantidad) {this.cantidad = cantidad;}
	
	
}
