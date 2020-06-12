import java.util.ArrayList;

public class GestorVentas
{
	public static ArrayList<Venta> ventas = new ArrayList<Venta>();
	
	public static void mostrarVentas()
	{
		for(Venta venta: ventas)
		{
			System.out.println("ARTÍCULOS:");
			for(int i=0; i<venta.getArticulos().size(); i++)
			{
				System.out.println("- " + venta.getArticulos().get(i).getNombre() + " x" + venta.getCantidadArticulo().get(i) + " - $" + venta.getArticulos().get(i).getPrecio() + " por unidad.");
			}
			System.out.println("CANTIDAD DE ARTÍCULOS: " + venta.getCantidadArticulos());
			System.out.println("PRECIO TOTAL: $" + venta.getPrecioTotal());
			System.out.println(venta.getMedioago());
		}
	}
	public static void prepararPedidos()
	{
		int contador = 0;
		System.out.println();
		System.out.println("PEDIDOS:");
		for(Venta venta: ventas)
		{
			if(venta.getPedidoPreparado() == false)
			{
				System.out.println("Pedido N°" + (++contador) + ":");
				for(int i=0; i<venta.getArticulos().size(); i++)
				{
					System.out.println("- " + venta.getArticulos().get(i).getNombre() + " x" + venta.getCantidadArticulo().get(i) + " - $" + venta.getArticulos().get(i).getPrecio() + " por unidad.");
				}
				venta.pedidoPreparado();
			}
		}
		System.out.println("CANTIDAD DE PEDIDOS A PREPARAR: " + contador + ".");
	}
	
	
}
