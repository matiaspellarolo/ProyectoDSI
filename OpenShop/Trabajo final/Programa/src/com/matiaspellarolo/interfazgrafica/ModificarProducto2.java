package com.matiaspellarolo.interfazgrafica;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.matiaspellarolo.clases.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModificarProducto2 extends JPanel
{
	private JTextField textFieldId, textFieldNombre, textFieldMarca, textFieldPrecio, textFieldStock, textFieldTipoProducto;
	private JTextArea textAreaDescripcion;
	private JComboBox<String> comboBoxCategoria, comboBoxTipoProducto;
	
	public ModificarProducto2(GestorCategorias gestorCategorias, GestorTiposProductos gestorTiposProductos, GestorProductos gestorProductos)
	{
		setLayout(null);

		Producto producto = gestorProductos.buscarProducto(Programa.id);
		
		JLabel labelTitulo = new JLabel("Modificar producto");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelTitulo.setBounds(129, 55, 220, 30);
		add(labelTitulo);
		
		JLabel labelId = new JLabel("Id:");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelId.setBounds(169, 105, 23, 30);
		add(labelId);
		
		textFieldId = new JTextField(Integer.toString(producto.getId()));
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldId.setBounds(200, 105, 220, 30);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNombre.setBounds(124, 150, 68, 30);
		add(labelNombre);
		
		textFieldNombre = new JTextField(producto.getNombre());
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNombre.setBounds(200, 150, 220, 30);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelMarca = new JLabel("Marca:");
		labelMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMarca.setBounds(140, 195, 52, 30);
		add(labelMarca);
		
		textFieldMarca = new JTextField(producto.getMarca());
		textFieldMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldMarca.setBounds(200, 195, 220, 30);
		add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPrecio.setBounds(139, 240, 53, 30);
		add(labelPrecio);
		
		textFieldPrecio = new JTextField(String.valueOf(producto.getPrecio()));
		textFieldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPrecio.setBounds(200, 240, 220, 30);
		add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel labelStock = new JLabel("Stock:");
		labelStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelStock.setBounds(143, 285, 49, 30);
		add(labelStock);
		
		textFieldStock = new JTextField(Integer.toString(producto.getStock()));
		textFieldStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldStock.setBounds(200, 285, 220, 30);
		add(textFieldStock);
		textFieldStock.setColumns(10);
		
        JLabel labelTipoProducto = new JLabel("Tipo de producto:");
		labelTipoProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTipoProducto.setBounds(50, 375, 142, 30);
		add(labelTipoProducto);
		
		comboBoxTipoProducto = new JComboBox<String>();
		comboBoxTipoProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxTipoProducto.setBounds(200, 375, 220, 30);
        add(comboBoxTipoProducto);
        
        JLabel labelCategoria = new JLabel("Categoria:");
		labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCategoria.setBounds(112, 330, 80, 30);
		add(labelCategoria);
		
		comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxTipoProducto.removeAllItems();
				comboBoxTipoProducto.addItem("Selec. tipo producto");
				String categoriaSelecconada = (String) comboBoxCategoria.getSelectedItem();
	            int idCategoria = gestorCategorias.buscarIdCategoria(categoriaSelecconada);
	            for(TipoProducto tipoProducto: gestorTiposProductos.getTiposProductos())
	            {
	            	if(tipoProducto.getIdCategoria() == idCategoria)
	            	{
	            		comboBoxTipoProducto.addItem(tipoProducto.getNombre());
	            	}
	            }
			}
		});
		comboBoxCategoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxCategoria.setBounds(200, 330, 220, 30);
		comboBoxCategoria.addItem("Selec. categoría");
        for(Categoria categoria: gestorCategorias.getCategorias())
        {
        	comboBoxCategoria.addItem(categoria.getNombre());
        }
        add(comboBoxCategoria);
        int idCategoria = gestorTiposProductos.buscarIdCategoria(producto.getTipoProducto());
        String nombreCategoria = gestorCategorias.buscarNombreCategoria(idCategoria);
        comboBoxCategoria.setSelectedItem(nombreCategoria);
        String nombreTipoProducto = gestorTiposProductos.buscarNombreTipoCategoria(producto.getTipoProducto());
        comboBoxTipoProducto.setSelectedItem(nombreTipoProducto);
		
		JLabel labelDescripcion = new JLabel("Descripción:");
		labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelDescripcion.setBounds(97, 420, 95, 30);
		add(labelDescripcion);
		
		textAreaDescripcion = new JTextArea(producto.getDescripcion());
		JScrollPane scrollpaneDescripcion = new JScrollPane(textAreaDescripcion);
		scrollpaneDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollpaneDescripcion.setBounds(200, 420, 220, 90);
		add(scrollpaneDescripcion);
		
		JButton buttonGuardar = new JButton("Guardar");
		buttonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProducto(gestorTiposProductos, gestorProductos);
				Programa.mostrarPanel(Paneles.PRINCIPAL);
			}
		});
		buttonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGuardar.setBounds(439, 450, 130, 60);
		add(buttonGuardar);
		
		JLabel labelMensaje = new JLabel("<<Mensaje de error>>");
		labelMensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMensaje.setBounds(439, 420, 255, 30);
		add(labelMensaje);
		
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
	public void modificarProducto(GestorTiposProductos gestorTiposProductos, GestorProductos gestorProductos)
	{
		int id = Integer.parseInt(textFieldId.getText());
		String nombre = textFieldNombre.getText();
		String marca = textFieldMarca.getText();
		double precio = Double.parseDouble(textFieldPrecio.getText());
		int stock = Integer.parseInt(textFieldStock.getText());
		String tipoProducto = (String) comboBoxTipoProducto.getSelectedItem();
        int idTipoProducto = gestorTiposProductos.buscarIdTipoProducto(tipoProducto);
        String descripcion = textAreaDescripcion.getText();
        
        gestorProductos.modificarProducto(Programa.id, id, nombre, marca, precio, stock, descripcion, idTipoProducto);
        
        
	}
	public void paint (Graphics g)
    {
		super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("logo.png");
        g.drawImage (imagen, 494, 25, 266, 111, this);
    }
}
