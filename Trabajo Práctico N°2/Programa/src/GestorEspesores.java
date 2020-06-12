import java.util.ArrayList;

public class GestorEspesores
{
	public static ArrayList<Espesor> espesores = new ArrayList<Espesor>();
	
	public static void mostrarEspesores()
	{
		int i = 1;
		for(Espesor espesor: espesores)
		{
			System.out.println(i++ + "- Espesor de " + espesor.getLongitud() + ". $" + espesor.getPrecio() + " por metro cuadrado.");
		}
	}
}
