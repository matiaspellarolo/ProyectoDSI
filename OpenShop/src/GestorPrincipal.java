import java.util.Scanner;

public class GestorPrincipal
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		MedioPago medioPago1 = new MedioPago("Tarjeta de crédito", 6);
		MedioPago medioPago2 = new MedioPago("Tarjeta de débito", 1);
		Usuario usuario1 = new Usuario("Matías Pellarolo", "matiaspellarolo@gmail.com", "matias99");
		Articulo articulo1 = new Articulo("Celular", "Samsung", 18000, 12);
		Articulo articulo2 = new Articulo("Televisor", "Philips", 53000, 5);
		Articulo articulo3 = new Articulo("Notebook", "Asus", 32500, 4);
		Articulo articulo4 = new Articulo("Monitor", "Dell", 28000, 7);
		Carrito carrito1 = new Carrito(usuario1);
		
		System.out.print("1- Realizar compra.\n2- Preparar pedido.\n3- Salir.\nOpción: ");
		int opcionComprar = input.nextInt();
		while (opcionComprar == 1 || opcionComprar ==2)
		{
			switch(opcionComprar)
			{
			case 1:
			{
				do {
					System.out.println();
					GestorArticulos.mostrarArticulosRelevantes();
					System.out.print("Ingresar número de producto para agregar al carrito: ");
					int numeroArticulo;
					do {
						numeroArticulo = input.nextInt();
						if(numeroArticulo < 1 || numeroArticulo > GestorArticulos.articulos.size())
						{
							System.out.print("El valor no es válido. Vuelva a ingesar: ");
						}
					}while (numeroArticulo < 1 || numeroArticulo > GestorArticulos.articulos.size());
					if(GestorArticulos.articulos.get(numeroArticulo - 1).getCantidad() == 0)
					{
						System.out.println("No hay stock disponible. Reintente más tarde.");
					}
					else
					{
						carrito1.agregarArticulo(GestorArticulos.articulos.get(numeroArticulo - 1));
					}
					
					System.out.print("\n1- Volver a comprar.\n2- Finalizar compra y elegir medio de pago.\nIngrese valor: ");
					int accion;
					do {
						accion = input.nextInt();
						if(accion < 1 || accion >2)
						{
							System.out.print("El valor no es válido. Vuelva a ingesar: ");
						}
					}while(accion < 1 || accion >2);
					System.out.print("\n");
					if(accion == 2) break;
				}while(true);
				carrito1.mostrarCarrito();
				System.out.println();
				GestorMediosPago.mostrarMediosPago();
				System.out.print("Ingrese número de medio de pago: ");
				int numeroMedioPago;
				do {
					numeroMedioPago = input.nextInt();
					if(numeroMedioPago < 1 || numeroMedioPago > GestorMediosPago.mediosPago.size())
					{
						System.out.print("El valor no es válido. Vuelva a ingesar: ");
					}
				}while(numeroMedioPago < 1 || numeroMedioPago > GestorMediosPago.mediosPago.size());
				
				carrito1.asignarMedioPago(GestorMediosPago.mediosPago.get(numeroMedioPago -1));
				System.out.print("\n¿Efectuar compra?\n1- Si.\n2- No.\nOpción: ");
				int opcion;
				do {
					opcion = input.nextInt();
					if(opcion < 1 || opcion > 2) System.out.print("Valor no válido. Vuelva a ingresar la opción: ");
				}while (opcion < 1 || opcion > 2);
				if(opcion == 1)
				{
					Venta venta = new Venta(carrito1.getUsuario(), carrito1.getCantidadArticulos(), carrito1.getPrecioTotal(), carrito1.getArticulos(), carrito1.getCantidadArticulo(), carrito1.getMedioPago());
					System.out.println("Compra finalizada.");
					System.out.print("\n");
					venta.mostrarVenta();
				}
				carrito1.limpiarCarrito();
				break;
			}
			case 2:
			{
				GestorVentas.prepararPedidos();
				break;
			}
			}
			System.out.print("\n1- Realizar compra.\n2- Preparar pedido.\n3- Salir.\nOpción: ");
			opcionComprar = input.nextInt();
		}
	}
}