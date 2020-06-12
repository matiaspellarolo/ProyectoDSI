import java.util.ArrayList;

public class GestorMediosPago
{
	public static ArrayList<MedioPago> mediosPago = new ArrayList<MedioPago>();
	
	public static void mostrarMediosPago()
	{
		int i = 1;
		System.out.println("MEDIOS DE PAGO: ");
		for(MedioPago medioPago: mediosPago)
		{
			System.out.println(i++ + "- " + medioPago.getDescripcion() + " - Cuotas: " + medioPago.getCuotas() + ".");
		}
	}
}
