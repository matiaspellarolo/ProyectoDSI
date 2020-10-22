package com.matiaspellarolo.interfazgrafica;
import com.matiaspellarolo.clases.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.tk.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Programa extends JFrame {

	private static JPanel contentPane;
	static GestorCategorias gestorCategorias;
	static GestorTiposProductos gestorTiposProductos; 
	static GestorProductos gestorProductos;
	static int id = 0;
	
	public static void main(String[] args) {
		gestorCategorias = new GestorCategorias();
		gestorTiposProductos = new GestorTiposProductos();
		gestorProductos = new GestorProductos();
		valoresIniciales();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Programa()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mostrarPanel(Paneles.INICIO_SESION);
	}
	public static void mostrarPanel(Paneles panel)
	{
		JPanel panelAMostrar = null;
		switch(panel)
		{
			case INICIO_SESION:
				InicioSesion inicioSesion = new InicioSesion();
				panelAMostrar = inicioSesion;
				break;
			case PRINCIPAL:
				Principal principal = new Principal();
				panelAMostrar = principal;
				break;
			case VER_STOCK_ACTUAL:
				VerStockActual verStockActual = new VerStockActual(gestorProductos);
				panelAMostrar = verStockActual;
				break;
			case AGREGAR_PRODUCTO:
				AgregarProducto agregarProducto = new AgregarProducto(gestorCategorias, gestorTiposProductos, gestorProductos); 
				panelAMostrar = agregarProducto;
				break;
			case MODIFICAR_PRODUCTO_1:
				ModificarProducto1 modificarProducto1 = new ModificarProducto1(gestorProductos);
				panelAMostrar = modificarProducto1;
				break;
			case MODIFICAR_PRODUCTO_2:
				ModificarProducto2 modificarProducto2 = new ModificarProducto2(gestorCategorias, gestorTiposProductos, gestorProductos);
				panelAMostrar = modificarProducto2;
				break;
			case ELIMINAR_PRODUCTO:
				EliminarProducto eliminarProducto = new EliminarProducto(gestorProductos);
				panelAMostrar = eliminarProducto;
				break;
		}
		contentPane.removeAll();
		contentPane.add(panelAMostrar);
		contentPane.repaint();
		contentPane.revalidate();
	}
	public static void valoresIniciales()
	{
		gestorCategorias.agregarCategoria(345, "Electrodomésticos");
		gestorCategorias.agregarCategoria(842, "Electrónica");
		gestorCategorias.agregarCategoria(247, "Vestimenta");
		gestorCategorias.agregarCategoria(648, "Deporte");
		gestorCategorias.agregarCategoria(473, "Hogar");
		gestorCategorias.agregarCategoria(296, "Juguetes");
		gestorCategorias.agregarCategoria(574, "Escuela");
		gestorCategorias.agregarCategoria(741, "Belleza y cuidado pers.");
		gestorCategorias.agregarCategoria(165, "Computación");
		gestorCategorias.agregarCategoria(193, "Celulares - Teléfonos");
		
		gestorTiposProductos.agregarTipoProducto(34501, "Climatización", 345);
		gestorTiposProductos.agregarTipoProducto(34502, "Cocción", 345);
		gestorTiposProductos.agregarTipoProducto(34503, "Lavado", 345);
		gestorTiposProductos.agregarTipoProducto(34504, "Refrigeración", 345);
		gestorTiposProductos.agregarTipoProducto(34505, "Cuidado personal", 345);
		gestorTiposProductos.agregarTipoProducto(34506, "Pequeños electrodom.", 345);
		gestorTiposProductos.agregarTipoProducto(34507, "Otros", 345);
		
		gestorTiposProductos.agregarTipoProducto(84201, "Audio", 842);
		gestorTiposProductos.agregarTipoProducto(84202, "TVs", 842);
		gestorTiposProductos.agregarTipoProducto(84203, "Video", 842);
		gestorTiposProductos.agregarTipoProducto(84204, "Cables", 842);
		gestorTiposProductos.agregarTipoProducto(84205, "Componentes electrónicos", 842);
		gestorTiposProductos.agregarTipoProducto(84206, "Otros", 842);
		
		gestorTiposProductos.agregarTipoProducto(24701, "Remeras", 247);
		gestorTiposProductos.agregarTipoProducto(24702, "Pantalones", 247);
		gestorTiposProductos.agregarTipoProducto(24703, "Calzado", 247);
		gestorTiposProductos.agregarTipoProducto(24704, "Buzos", 247);
		gestorTiposProductos.agregarTipoProducto(24705, "Camisas", 247);
		gestorTiposProductos.agregarTipoProducto(24706, "Camperas", 247);
		gestorTiposProductos.agregarTipoProducto(24707, "Jeans", 247);
		gestorTiposProductos.agregarTipoProducto(24708, "Otros", 247);
		
		gestorTiposProductos.agregarTipoProducto(64801, "Futbol", 648);
		gestorTiposProductos.agregarTipoProducto(64802, "Basquet", 648);
		gestorTiposProductos.agregarTipoProducto(64803, "Volvey", 648);
		gestorTiposProductos.agregarTipoProducto(64804, "Tenis - Padel", 648);
		gestorTiposProductos.agregarTipoProducto(64805, "Ciclismo", 648);
		gestorTiposProductos.agregarTipoProducto(64806, "Natación", 648);
		gestorTiposProductos.agregarTipoProducto(64807, "Gimnasia", 648);
		gestorTiposProductos.agregarTipoProducto(64808, "Juegos de salón", 648);
		gestorTiposProductos.agregarTipoProducto(64809, "Artes marciales", 648);
		gestorTiposProductos.agregarTipoProducto(64810, "Ropa deportiva", 648);
		gestorTiposProductos.agregarTipoProducto(64811, "Zapatillas deportivas", 648);
		gestorTiposProductos.agregarTipoProducto(64812, "Otros", 648);
		
		gestorTiposProductos.agregarTipoProducto(47301, "Adornos - Decoración", 473);
		gestorTiposProductos.agregarTipoProducto(47302, "Baños", 473);
		gestorTiposProductos.agregarTipoProducto(47303, "Bazar - cocina", 473);
		gestorTiposProductos.agregarTipoProducto(47304, "Colchones - Sommiers", 473);
		gestorTiposProductos.agregarTipoProducto(47305, "Iluminación", 473);
		gestorTiposProductos.agregarTipoProducto(47306, "Jardín - Exteriores", 473);
		gestorTiposProductos.agregarTipoProducto(47307, "Muebles", 473);
		gestorTiposProductos.agregarTipoProducto(47308, "Seguridad", 473);
		gestorTiposProductos.agregarTipoProducto(47309, "Otros", 473);
		
		gestorTiposProductos.agregarTipoProducto(29601, "Armas - anzadores", 296);
		gestorTiposProductos.agregarTipoProducto(29602, "Bloques - Construcción", 296);
		gestorTiposProductos.agregarTipoProducto(29603, "Dibujo - Pintura", 296);
		gestorTiposProductos.agregarTipoProducto(29604, "Juegos de playa", 296);
		gestorTiposProductos.agregarTipoProducto(29605, "Juegos de mesa", 296);
		gestorTiposProductos.agregarTipoProducto(29606, "Juguetes p/ bebes", 296);
		gestorTiposProductos.agregarTipoProducto(29607, "Peluches", 296);
		gestorTiposProductos.agregarTipoProducto(29608, "Vehículos de Juguete", 296);
		gestorTiposProductos.agregarTipoProducto(29609, "Otros", 296);
		
		gestorTiposProductos.agregarTipoProducto(57401, "Cuadernos", 574);
		gestorTiposProductos.agregarTipoProducto(57402, "Útiles", 574);
		gestorTiposProductos.agregarTipoProducto(57403, "Carpetas", 574);
		gestorTiposProductos.agregarTipoProducto(57404, "Cartucheras", 574);
		gestorTiposProductos.agregarTipoProducto(57405, "Mochilas", 574);
		gestorTiposProductos.agregarTipoProducto(57406, "Intrumentos de medición", 574);
		gestorTiposProductos.agregarTipoProducto(57407, "Calculadoras", 574);
		gestorTiposProductos.agregarTipoProducto(57408, "Otros", 574);
		
		gestorTiposProductos.agregarTipoProducto(74101, "Artículos de peluquería", 741);
		gestorTiposProductos.agregarTipoProducto(74102, "Cuidado de la piel", 741);
		gestorTiposProductos.agregarTipoProducto(74103, "Cuidado del cabello", 741);
		gestorTiposProductos.agregarTipoProducto(74104, "Depilación", 741);
		gestorTiposProductos.agregarTipoProducto(74105, "Higiene personal", 741);
		gestorTiposProductos.agregarTipoProducto(74106, "Maquillaje", 741);
		gestorTiposProductos.agregarTipoProducto(74107, "Perfumes", 741);
		gestorTiposProductos.agregarTipoProducto(74108, "Tratamiento de belleza", 741);
		gestorTiposProductos.agregarTipoProducto(74109, "Otros", 741);
		
		gestorTiposProductos.agregarTipoProducto(16501, "Componentes de PC", 165);
		gestorTiposProductos.agregarTipoProducto(16502, "Conectividad - Redes", 165);
		gestorTiposProductos.agregarTipoProducto(16503, "Laptops", 165);
		gestorTiposProductos.agregarTipoProducto(16504, "Impresión", 165);
		gestorTiposProductos.agregarTipoProducto(16505, "Monitores", 165);
		gestorTiposProductos.agregarTipoProducto(16506, "Periféricos", 165);
		gestorTiposProductos.agregarTipoProducto(16507, "PC de escritorio", 165);
		gestorTiposProductos.agregarTipoProducto(16508, "Cables", 165);
		gestorTiposProductos.agregarTipoProducto(16509, "Otros", 165);
		
		gestorTiposProductos.agregarTipoProducto(19301, "Celulares", 193);
		gestorTiposProductos.agregarTipoProducto(19302, "Accesorios p/ celulares", 193);
		gestorTiposProductos.agregarTipoProducto(19303, "Repuestos", 193);
		gestorTiposProductos.agregarTipoProducto(19304, "Cargadores", 193);
		gestorTiposProductos.agregarTipoProducto(19305, "Otros", 193);
		
		String descripcion1 = "Ésta le brinda todas las características de la serie V.P.A.M. existente,"
				+ "más una nueva visualización de 2 líneas y una útil función de reproducción repetida."
				+ "Todo esto hace que la matemática sea más fácil de aplicar y comprender que nunca antes.";
		gestorProductos.agregarProducto(001, "Calculadora Casio fx-82MS", "Casio", 1449.99, 8, descripcion1, 57407);
		String descripcion2 = "Las cuatro cámaras traseras incorporan diversos tipos de lentes para que "
				+ "puedas hacer la mejor toma, siempre. Con su batería de 4000 mAh podrás trabajar, jugar "
				+ "o ver series sin interrupciones. Disfrutá de gran nitidez en todos tus contenidos "
				+ "gracias a su pantalla IPS de 6.3 \" con una resolución de 1080 px x 2340 px. El procesador "
				+ "Qualcomm® Snapdragon™ 665 de ocho núcleos, junto con la memoria RAM de 4 GB, te permitirán "
				+ "ejecutar varias aplicaciones al mismo tiempo, jugar y navegar con gran rapidez y sin inconvenientes.";
		gestorProductos.agregarProducto(002, "Celular Redmi Note 8", "Xiaomi", 37997, 3, descripcion2, 19301);
		String descripcion3 = "600w 1,5lts 5 Vel Cuchillas Acero";
		gestorProductos.agregarProducto(003, "Licuadora Peabody", "Peabody", 3999, 5, descripcion3, 34506);
		String descripcion4 = "240gb A400 500 Mbps Tienda Oficial 2";
		gestorProductos.agregarProducto(004, "Disco Sólido Kingston", "Kingston", 5339, 6, descripcion4, 16501);
	}
	
}
