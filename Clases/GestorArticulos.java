import java.util.ArrayList;

public class GestorArticulos
{
	public static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	private static ArrayList<Articulo> articulosRelevantes = new ArrayList<Articulo>();
	
	public static void mostrarArticulosRelevantes()
	{
		int i = 1;
		System.out.println("LISTADO DE ARTÍCULOS: ");
		for(Articulo articulo: articulos)
		{
			System.out.println(i++ + "- " + articulo.getNombre() + ". $" + articulo.getPrecio() + " (" + articulo.getCantidad() + " unidades disponibles)");
		}
	}
}
