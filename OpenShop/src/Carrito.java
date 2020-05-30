import java.util.ArrayList;
import java.util.Scanner;

public class Carrito
{
	private Usuario usuario;
	private int cantidadArticulos;
	private double precioTotal;
	private ArrayList<Articulo> articulos;
	private ArrayList<Integer> cantidadArticulo;
	private MedioPago medioPago;
	
	public Carrito(Usuario usuario)
	{
		this.usuario = usuario;
		cantidadArticulos = 0;
		precioTotal = 0;
		articulos = new ArrayList<Articulo>();
		cantidadArticulo = new ArrayList<Integer>();
	}
	public Usuario getUsuario() {return usuario;}
	public int getCantidadArticulos() {return cantidadArticulos;}
	public double getPrecioTotal() {return precioTotal;}
	public ArrayList<Articulo> getArticulos() {return articulos;}
	public ArrayList<Integer> getCantidadArticulo() {return cantidadArticulo;}
	public MedioPago getMedioPago() {return medioPago;}
	
	public void agregarArticulo(Articulo articulo)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Cantidad: ");
		int cantidad;
		do {
			cantidad = input.nextInt();
			if(cantidad < 1)
			{
				System.out.print("La cantidad debe ser mayor a 0. Vuelva a ingresar la cantidad: ");
			}
			if(cantidad > articulo.getCantidad())
			{
				System.out.print("Stock insuficiente. Vuelva a ingresar la cantidad: ");
			}
		}while(cantidad < 1 || cantidad > articulo.getCantidad());
		int bandera = 0;
		for(int i=0; i<articulos.size(); i++)
		{
			if(articulos.get(i).equals(articulo))
			{
				int nuevaCantidad = cantidadArticulo.get(i) + cantidad;
				cantidadArticulo.remove(i);
				cantidadArticulo.add(i, nuevaCantidad);
				bandera = 1;
			}
		}
		if(bandera == 0)
		{
			articulos.add(articulo);
			cantidadArticulo.add(cantidad);
		}
		
		System.out.println("Se agregó al carrito el articulo \"" + articulo.getNombre() + "\" (" + cantidad + " unid.)" +" con éxito.");
		cantidadArticulos += cantidad;
		calcularPrecio(articulo, cantidad);
		articulo.setCantidad(articulo.getCantidad() - cantidad);
	}
	public void calcularPrecio(Articulo articulo, int cantidad)
	{
		precioTotal += articulo.getPrecio()*cantidad;
	}
	public void mostrarCarrito()
	{
		System.out.println("ARTÍCULOS DEL CARRITO:");
		for(int i=0; i<articulos.size(); i++)
		{
			System.out.println("- " + articulos.get(i).getNombre() + " x" + cantidadArticulo.get(i) + " - $" + articulos.get(i).getPrecio() + " por unidad.");
		}
		System.out.println("CANTIDAD DE ARTÍCULOS: " + cantidadArticulos);
		System.out.println("PRECIO TOTAL: $" + precioTotal);
	}
	public void asignarMedioPago(MedioPago medioPago)
	{
		this.medioPago = medioPago;
		System.out.println("Medio de pago asignado con éxito.");
	}
	public void limpiarCarrito()
	{
		
		cantidadArticulos = 0;
		precioTotal = 0;
		articulos.clear();
		cantidadArticulo.clear();
	}
}
