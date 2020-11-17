package com.matiaspellarolo.interfazgrafica;
import com.matiaspellarolo.clases.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.javafx.tk.Toolkit;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Programa extends JFrame {
	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	private static JPanel contentPane;
	static GestorCategorias gestorCategorias;
	static GestorTiposProductos gestorTiposProductos; 
	static GestorProductos gestorProductos;
	static GestorUsuarios gestorUsuarios;
	static int id = 0;
	
	public static void main(String[] args) throws Exception {
		gestorCategorias = new GestorCategorias();
		gestorTiposProductos = new GestorTiposProductos();
		gestorProductos = new GestorProductos();
		gestorCategorias = AlmacenamientoDeDatos.cargarDatosCategorias();
		gestorTiposProductos = AlmacenamientoDeDatos.cargarDatosTiposProductos();
		gestorProductos = AlmacenamientoDeDatos.cargarDatosProductos();
		gestorUsuarios = AlmacenamientoDeDatos.cargarDatosUsuarios();
		AlmacenamientoDeDatos.guardarDatosCategorias(gestorCategorias);
		AlmacenamientoDeDatos.guardarDatosTiposProductos(gestorTiposProductos);
		AlmacenamientoDeDatos.guardarDatosProductos(gestorProductos);
		actualizarStock();
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
	public static void actualizarStock()
	{
		GestorProductosDespachados gestorProductosDespachados = new GestorProductosDespachados();
		gestorProductosDespachados = AlmacenamientoDeDatos.cargarDatosProductosVendidos();
		for(ProductoDespachado productoDespachado: gestorProductosDespachados.getProductosDespachados())
		{
			for(Producto producto: gestorProductos.getProductos())
			{
				if(producto.getId() == productoDespachado.getId())
				{
					producto.setStock(producto.getStock() - productoDespachado.getCantidad());
				}
			}
		}
		ArrayList<ProductoDespachado> productosDespachados = gestorProductosDespachados.getProductosDespachados();
		productosDespachados.clear();
		gestorProductosDespachados.setProductosDespachados(productosDespachados);
		AlmacenamientoDeDatos.guardarDatosProductosDespachados(gestorProductosDespachados);
	}
	public static void mostrarPanel(Paneles panel)
	{
		JPanel panelAMostrar = null;
		switch(panel)
		{
			case INICIO_SESION:
				InicioSesion inicioSesion = new InicioSesion(gestorUsuarios);
				panelAMostrar = inicioSesion;
				break;
			case PRINCIPAL:
				Principal principal = new Principal(gestorCategorias, gestorTiposProductos, gestorProductos);
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
}
