import java.util.ArrayList;


public class GestorPresupuestos
{
	public static ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	
	
	public static void mostrarPresupuestos()
	{
		System.out.println("PRESUPUESTOS REALIZADOS:");
		int i = 1;
		for(Presupuesto presupuesto: presupuestos)
		{
			System.out.println("Presupuesto N°" + i++ + ":");
			System.out.println(presupuesto);
		}
	}
}
