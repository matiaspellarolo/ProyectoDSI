package com.matiaspellarolo.interfazgrafica;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.matiaspellarolo.clases.*;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerStockActual extends JPanel
{	
	private JTable tablaProductos;
	
	public VerStockActual(GestorProductos gestorProductos)
	{
		setLayout(null);
		
		JLabel labelTitulo = new JLabel("Stock actual");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelTitulo.setBounds(45, 45, 136, 30);
		add(labelTitulo);
		
		String [] nombresColumnas = {"Id", "Nombre", "Marca", "Stock"};
		Object [][] datosFilas = new Object[gestorProductos.cantidadProductos()][4];
		int x = 0;
		int y = 0;
		for(Producto producto: gestorProductos.getProductos())
		{
			datosFilas[x][y++] = producto.getId();
			datosFilas[x][y++] = producto.getNombre();
			datosFilas[x][y++] = producto.getMarca();
			datosFilas[x][y++] = producto.getStock();
			x++;y=0;
		}
		
		tablaProductos = new JTable(datosFilas, nombresColumnas);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaProductos);
		scrollPaneTabla.setBounds(45, 81, 413, 437);
		add(scrollPaneTabla);
		tablaProductos.setEnabled(false);
		
		JButton buttonVolver = new JButton("Volver");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.mostrarPanel(Paneles.PRINCIPAL);
			}
		});
		buttonVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonVolver.setBounds(675, 517, 100, 35);
		add(buttonVolver);
	}
	public void paint (Graphics g)
    {
		super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("Archivos/logo.png");
        g.drawImage (imagen, 494, 25, 266, 111, this);
    }
}