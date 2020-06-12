import java.util.Scanner;
public class GestorPrincipal
{
	public static void main(String[] ar) 
	{
		
		Scanner input = new Scanner(System.in);
		Cliente cliente1 = new Cliente("Matías", "Pellarolo", "OpenShop", "Chile 933", "matiaspellarolo@gmail.com", "3564330457", "matias99");
		Cliente cliente2 = new Cliente("Marcos", "Andreo", "Imprenta Vilosio", "Sarmiento 265", "1", "3564854521", "1");
		Material material1 = new Material("Material 1", 220);
		Material material2 = new Material("Material 2", 300);
		Espesor espesor1 = new Espesor((float)0.05, 53.60);
		Espesor espesor2 = new Espesor((float)0.07, 87.00);
		Espesor espesor3 = new Espesor((float)0.10, 117.49);
		Espesor espesor4 = new Espesor((float)0.12, 128.48);
		Espesor espesor5 = new Espesor((float)0.16, 143.05);
		Espesor espesor6 = new Espesor((float)0.20, 180.79);
		
		boolean usuarioValido = false;
		do {
			System.out.print("INGRESO\n1- Ingresar usuario.\n2- Crear usuario.\nOpción: ");
			int opcionIngreso;
			do {
				opcionIngreso = input.nextInt();
				if(opcionIngreso < 1 || opcionIngreso >2) System.out.print("Valor no válido. Vuelva a ingresar: ");
			} while(opcionIngreso < 1 || opcionIngreso >2);
			switch(opcionIngreso)
			{
			case 1:
				System.out.print("Ingresar email: ");
				String email = input.next();
				System.out.print("Ingresar contraseña: ");
				String contraseña = input.next();
				usuarioValido = GestorClientes.verificarCliente(email, contraseña);
				if(usuarioValido == false) System.out.println("Vuelva a ingresar los datos o cree un usuario.\n");
				break;
			case 2:
				Cliente cliente = new Cliente();
				break;
			}
		}while(usuarioValido == false);
		System.out.println("\nMENÚ\n1- Realizar cotización.\n2- Salir.");
		int opcionMenu;
		do {
			opcionMenu = input.nextInt();
			if(opcionMenu <1 ||opcionMenu >2)System.out.print("Valor no válido. Vuelva a ingresar: ");
		}while(opcionMenu <1 ||opcionMenu >2);
		while (opcionMenu == 1)
		{
			double precio;
			System.out.println("\nCOTIZACIÓN:");
			float metrosCuadrados = ingresarMetrosCuadrados();
			Material material = ingresarMaterial();
			Espesor espesor = ingresarEspesor();
			int opcionRealizarCambio = 1;
			do {
				System.out.println();
				precio = calcularPresupuesto(metrosCuadrados, material, espesor);
				System.out.print("¿Desea realizar algún cambio en la cotización?\n1- Si.\n2- No.\nOpción: ");
				do {
					opcionRealizarCambio = input.nextInt();
					if(opcionRealizarCambio < 1 || opcionRealizarCambio >2) System.out.print("Valor no válido. Vuelva a ingresar: ");
				}while(opcionRealizarCambio < 1 || opcionRealizarCambio >2);
				if(opcionRealizarCambio == 1)
				{
					System.out.println("1- Cambiar metros cuadrados.");
					System.out.println("2- Cambiar material.");
					System.out.println("3- Cambiar espesor.");
					System.out.print("Opción: ");
					int opcionCambio;
					do {
						opcionCambio = input.nextInt();
						if(opcionCambio < 1 || opcionCambio > 3) System.out.print("Valor no válido. Vuelva a ingresar: ");
					}while(opcionCambio < 1 || opcionCambio > 3);
					switch (opcionCambio)
					{
					case 1:
						metrosCuadrados = ingresarMetrosCuadrados();
						break;
					case 2:
						material = ingresarMaterial();
						break;
					case 3:
						espesor = ingresarEspesor();
						break;
					}
				}
			}while(opcionRealizarCambio == 1);
			System.out.print("¿Desea registrar la cotización?\n1- Si.\n2- No.\nOpción: ");
			int opcionGuardarCotizacion;
			do {
				opcionGuardarCotizacion = input.nextInt();
				if(opcionGuardarCotizacion < 1 || opcionGuardarCotizacion >2) System.out.print("Valor no válido. Vuelva a ingresar: ");
			}while(opcionGuardarCotizacion < 1 || opcionGuardarCotizacion >2);
			if(opcionGuardarCotizacion == 1)
			{
				Presupuesto presupuesto = new Presupuesto(cliente1, material, precio, metrosCuadrados, espesor);
				System.out.println("Cotización registrada con éxito.");
			}
			System.out.println("\nMENÚ\n1- Realizar cotización.\n2- Salir.");
			do {
				opcionMenu = input.nextInt();
				if(opcionMenu <1 ||opcionMenu >2)System.out.print("Valor no válido. Vuelva a ingresar: ");
			}while(opcionMenu <1 ||opcionMenu >2);
		}
		System.out.println("Graias por su visita! Vuelva pronto.");
		System.out.println();
		System.out.println();
		System.out.println();
		GestorPresupuestos.mostrarPresupuestos();
	}
	
	public static float ingresarMetrosCuadrados()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Ingresar los metros cuadrados de pared: ");
		float metrosCuadrados;
		do {
			metrosCuadrados = input.nextFloat();
			if(metrosCuadrados <= 0) System.out.print("Valor no válido. Vuelva a ingresar: ");
		}while(metrosCuadrados <= 0);
		return metrosCuadrados;
	}
	
	public static Material ingresarMaterial()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Seleccionar el material:");
		GestorMateriales.mostrarMateriales();
		int opcionMaterial = 0;
		System.out.print("Opción: ");
		do {
			opcionMaterial = input.nextInt();
			if(opcionMaterial < 1 || opcionMaterial > GestorMateriales.materiales.size()) System.out.print("Valor no válido. Vuelva a ingresar: ");
		}while(opcionMaterial < 1 || opcionMaterial > GestorMateriales.materiales.size());
		Material material = GestorMateriales.materiales.get(opcionMaterial - 1);
		return material;
	}
	
	public static Espesor ingresarEspesor()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Seleccionar el espesor:");
		GestorEspesores.mostrarEspesores();
		System.out.print("Opción: ");
		int opcionEspesor;
		do {
			opcionEspesor = input.nextInt();
			if(opcionEspesor < 1 || opcionEspesor > GestorEspesores.espesores.size()) System.out.print("Valor no válido. Vuelva a ingresar: ");
		}while(opcionEspesor < 1 || opcionEspesor > GestorEspesores.espesores.size());
		Espesor espesor = GestorEspesores.espesores.get(opcionEspesor - 1);
		return espesor;
	}
	
	public static double calcularPresupuesto(float metrosCuadrados, Material material, Espesor espesor)
	{
		float metrosCuadradosBolsa = (float) ((espesor.getLongitud() * 4.5) / 0.1);
		float cantidadBolsas = metrosCuadrados / metrosCuadradosBolsa;
		float calculoBolsas = cantidadBolsas / (int)cantidadBolsas;
		if(calculoBolsas == 1.0) ;
		else cantidadBolsas = (int)cantidadBolsas + 1;
		double precioBolsas = cantidadBolsas * material.getPrecio();
		double precioEspesor = metrosCuadrados * espesor.getPrecio();
		double precioTotal = precioBolsas + precioEspesor;
		System.out.println("PRESUPUESTO:");
		System.out.println("- PRECIO MATERIAL: $" + String.format("%.2f", precioBolsas));
		System.out.println("- PRECIO MANO DE OBRA: $" + String.format("%.2f", precioEspesor));
		System.out.println("- PRECIO TOTAL: $" + String.format("%.2f", precioTotal));
		return precioTotal;
	}
}