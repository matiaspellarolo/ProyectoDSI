package com.matiaspellarolo.interfazgrafica;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.matiaspellarolo.clases.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProducto1 extends JPanel
{
	private JTable tablaProductos;
	private JTextField textFieldId;
	
	public ModificarProducto1(GestorProductos gestorProductos)
	{
		setLayout(null);
		
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
		
		JLabel labelTitulo = new JLabel("Productos");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelTitulo.setBounds(45, 45, 136, 30);
		add(labelTitulo);
		
		JLabel labelId = new JLabel("Id del producto a modificar:");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelId.setBounds(486, 261, 221, 30);
		add(labelId);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldId.setBounds(486, 302, 221, 30);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel labelMensaje = new JLabel("<<Mensaje error>>");
		labelMensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMensaje.setBounds(486, 389, 241, 30);
		add(labelMensaje);
		
		JButton buttonSiguiente = new JButton("Siguiente");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.id = Integer.parseInt(textFieldId.getText());
				Programa.mostrarPanel(Paneles.MODIFICAR_PRODUCTO_2);
			}
		});
		buttonSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonSiguiente.setBounds(541, 343, 110, 30);
		add(buttonSiguiente);
		
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
        Image imagen = t.getImage ("logo.png");
        g.drawImage (imagen, 494, 25, 266, 111, this);
    }
}
