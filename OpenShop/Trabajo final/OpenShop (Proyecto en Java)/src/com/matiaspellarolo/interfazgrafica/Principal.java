package com.matiaspellarolo.interfazgrafica;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.matiaspellarolo.clases.*;

public class Principal extends JPanel
{
	public Principal(GestorCategorias gestorCategorias, GestorTiposProductos gestorTiposProductos, GestorProductos gestorProductos)
	{
		AlmacenamientoDeDatos.guardarDatosCategorias(gestorCategorias);
		AlmacenamientoDeDatos.guardarDatosTiposProductos(gestorTiposProductos);
		AlmacenamientoDeDatos.guardarDatosProductos(gestorProductos);
		
		setLayout(null);
		
		JButton buttonVerStockActual = new JButton("Ver stock actual");
		buttonVerStockActual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Programa.mostrarPanel(Paneles.VER_STOCK_ACTUAL);
			}
		});
		buttonVerStockActual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonVerStockActual.setBounds(267, 250, 250, 50);
		add(buttonVerStockActual);	
		
		JButton buttonAgregarProducto = new JButton("Agregar producto");
		buttonAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Programa.mostrarPanel(Paneles.AGREGAR_PRODUCTO);
			}
		});
		buttonAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonAgregarProducto.setBounds(267, 315, 250, 50);
		add(buttonAgregarProducto);
		
		JButton buttonModificarProducto = new JButton("Modificar producto");
		buttonModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.mostrarPanel(Paneles.MODIFICAR_PRODUCTO_1);
			}
		});
		buttonModificarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonModificarProducto.setBounds(267, 380, 250, 50);
		add(buttonModificarProducto);
		
		JButton buttonEliminarProducto = new JButton("Eliminar producto");
		buttonEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.mostrarPanel(Paneles.ELIMINAR_PRODUCTO);
			}
		});
		buttonEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonEliminarProducto.setBounds(267, 445, 250, 50);
		add(buttonEliminarProducto);
		
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonSalir.setBounds(675, 517, 100, 35);
		add(buttonSalir);
	}
	public void paint (Graphics g)
    {
		super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("Archivos/logo.png");
        int x = (this.getWidth() - imagen.getWidth(null)) / 2;
        g.drawImage (imagen, x, 50, this);
    }
}
