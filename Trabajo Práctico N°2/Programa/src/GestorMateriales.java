import java.util.ArrayList;

public class GestorMateriales
{
	public static ArrayList<Material> materiales = new ArrayList<Material>();
	
	public static void mostrarMateriales()
	{
		int i = 1;
		for(Material material: materiales)
		{
			System.out.println(i++ + "- " + material.getNombre() + ". $" + material.getPrecio() + " por bolsa.");
		}
	}
}
