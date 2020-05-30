import java.util.ArrayList;

public class Venta
{
	private Usuario usuario;
	private int cantidadArticulos;
	private double precioTotal;
	private ArrayList<Articulo> articulos;
	private ArrayList<Integer> cantidadArticulo;
	private MedioPago medioPago;
	private boolean pedidoPreparado;
	
	public Venta(Usuario usuario, int cantidadArticulos, double precioTotal, ArrayList<Articulo> articulos, ArrayList<Integer> cantidadArticulo, MedioPago medioPago)
	{
		this.usuario = usuario;
		this.cantidadArticulos = cantidadArticulos;
		this.precioTotal = precioTotal;
		this.articulos = new ArrayList<Articulo>();
		for(Articulo articulo: articulos)
		{
			this.articulos.add(articulo);
		}
		this.cantidadArticulo = new ArrayList<Integer>();
		for(int cantArticulo: cantidadArticulo)
		{
			this.cantidadArticulo.add(cantArticulo);
		}
		this.medioPago = medioPago;
		pedidoPreparado = false;
		GestorVentas.ventas.add(this);
	}
	
	public void mostrarVenta()
	{
		System.out.println("VENTA:");
		System.out.println("- Usuario: " + usuario.getNombre() + ".");
		System.out.println("- Artículos: ");
		for(int i=0; i<articulos.size(); i++)
		{
			System.out.println("  - " + articulos.get(i).getNombre() + " x" + cantidadArticulo.get(i) + " - $" + articulos.get(i).getPrecio() + " por unidad.");
		}
		System.out.println("- Cantidad de artículos: " + cantidadArticulos + ".");
		System.out.println("- Precio total: $" + precioTotal+ ".");
		System.out.println("- " + medioPago);
	}
	public ArrayList<Articulo> getArticulos()
	{
		return articulos;
	}
	public ArrayList<Integer> getCantidadArticulo()
	{
		return cantidadArticulo;
	}
	public int getCantidadArticulos()
	{
		return cantidadArticulos;
	}
	public double getPrecioTotal()
	{
		return precioTotal;
	}
	public MedioPago getMedioago()
	{
		return medioPago;
	}
	public boolean getPedidoPreparado()
	{
		return pedidoPreparado;
	}
	public void pedidoPreparado()
	{
		pedidoPreparado = true;
	}
}
