package com.matiaspellarolo.interfazgrafica;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.matiaspellarolo.clases.*;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

public class AgregarProducto extends JPanel
{
	public JTextField textFieldId, textFieldNombre, textFieldMarca, textFieldPrecio, textFieldStock, textFieldTipoProducto;
	public JTextArea textAreaDescripcion;
	public JComboBox<String> comboBoxCategoria, comboBoxTipoProducto;
	JLabel labelMensaje;
	static boolean listo = false;
	
	public AgregarProducto(GestorCategorias gestorCategorias, GestorTiposProductos gestorTiposProductos, GestorProductos gestorProductos)
	{
		setLayout(null);
		
		JLabel labelTitulo = new JLabel("Nuevo producto");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelTitulo.setBounds(129, 55, 198, 30);
		add(labelTitulo);
		
		JLabel labelId = new JLabel("Id:");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelId.setBounds(169, 105, 23, 30);
		add(labelId);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldId.setBounds(200, 105, 220, 30); 
		add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNombre.setBounds(124, 150, 68, 30);
		add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNombre.setBounds(200, 150, 220, 30);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelMarca = new JLabel("Marca:");
		labelMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMarca.setBounds(140, 195, 52, 30);
		add(labelMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldMarca.setBounds(200, 195, 220, 30);
		add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPrecio.setBounds(139, 240, 53, 30);
		add(labelPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPrecio.setBounds(200, 240, 220, 30);
		add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel labelStock = new JLabel("Stock:");
		labelStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelStock.setBounds(143, 285, 49, 30);
		add(labelStock);
		
		textFieldStock = new JTextField();
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
			public void itemStateChanged(ItemEvent arg0) {
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
        
		JLabel labelDescripcion = new JLabel("Descripción:");
		labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelDescripcion.setBounds(97, 420, 95, 30);
		add(labelDescripcion);
		
		textAreaDescripcion = new JTextArea();
		JScrollPane scrollpaneDescripcion = new JScrollPane(textAreaDescripcion);
		scrollpaneDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollpaneDescripcion.setBounds(200, 420, 220, 90);
		add(scrollpaneDescripcion);
		
		labelMensaje = new JLabel("");
		labelMensaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelMensaje.setBounds(439, 420, 340, 30);
		add(labelMensaje);
		
		JButton buttonGuardar = new JButton("Guardar");
		buttonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarProducto(gestorTiposProductos, gestorProductos);
				if(listo)
				{
					listo=false;
					Programa.mostrarPanel(Paneles.PRINCIPAL);
				}
			}
		});
		buttonGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGuardar.setBounds(439, 450, 130, 60);
		add(buttonGuardar);
		
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
	public void guardarProducto(GestorTiposProductos gestorTiposProductos, GestorProductos gestorProductos)
	{
		try {
		int id = idIngresado(gestorProductos);
		String nombre = nombreIngresado();
		String marca = marcaIngresada();
		double precio = precioIngresado();
		int stock = stockIngresado();
		int idTipoProducto = idTipoProductoSeleccionado(gestorTiposProductos);
		String nombreTipoProducto = (String) comboBoxTipoProducto.getSelectedItem();
		String nombreCategoria = (String) comboBoxCategoria.getSelectedItem();
        String descripcion =descripcionIngresada();
        gestorProductos.agregarProducto(id, nombre, marca, precio, stock, descripcion, idTipoProducto, nombreTipoProducto, nombreCategoria);
        AlmacenamientoDeDatos.guardarDatosProductos(gestorProductos);
        listo = true;
		}catch(Exception e) {
			labelMensaje.setText(e.getMessage());
		}
	}
	public int idIngresado(GestorProductos gestorProductos) throws Exception
	{
		if(textFieldId.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar un id.");
		}
		else if(!esUnNumero(textFieldId.getText()))
		{
			throw new Exception ("El id debe ser numérico.");
		}
		else if(Integer.parseInt(textFieldId.getText()) <= 0)
		{
			throw new Exception ("El id debe ser un número mayor a 0.");
		}
		else if(gestorProductos.buscarProducto(Integer.parseInt(textFieldId.getText())) != null)
		{
			throw new Exception ("El id ingresado ya existe.");
		}
		int id = Integer.parseInt(textFieldId.getText());
		return id;
	}
	public String nombreIngresado() throws Exception
	{
		if(textFieldNombre.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar un nombre.");
		}
		String nombre = textFieldNombre.getText();
		return nombre;
	}
	public String marcaIngresada() throws Exception
	{
		if(textFieldMarca.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar una marca.");
		}
		String marca = textFieldMarca.getText();
		return marca;
	}
	public double precioIngresado() throws Exception
	{
		if(textFieldPrecio.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar un precio.");
		}
		else if(!esUnNumeroDouble(textFieldPrecio.getText()))
		{
			throw new Exception ("El precio debe ser un valor numérico.");
		}
		else if(Double.parseDouble(textFieldPrecio.getText()) <= 0)
		{
			throw new Exception ("El precio debe ser mayor a 0.");
		}
		double precio = Double.parseDouble(textFieldPrecio.getText());
		return precio;
	}
	public int stockIngresado() throws Exception
	{
		if(textFieldStock.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar un stock.");
		}
		else if(!esUnNumero(textFieldStock.getText()))
		{
			throw new Exception ("El stock debe ser un valor numérico.");
		}
		else if(Integer.parseInt(textFieldStock.getText()) <= 0)
		{
			throw new Exception ("El stock debe ser mayor a 0.");
		}
		int stock = Integer.parseInt(textFieldStock.getText());
		return stock;
	}
	public int idTipoProductoSeleccionado(GestorTiposProductos gestorTiposProductos) throws Exception
	{
		if(comboBoxCategoria.getSelectedIndex() == 0)
		{
			throw new Exception ("Se debe seleccionar una categoría.");
		}
		if(comboBoxTipoProducto.getSelectedIndex() == 0)
		{
			throw new Exception ("Se debe seleccionar un tipo de producto.");
		}
		String tipoProducto = (String) comboBoxTipoProducto.getSelectedItem();
		int idTipoProducto = gestorTiposProductos.buscarIdTipoProducto(tipoProducto);
		return idTipoProducto;
	}
	public String descripcionIngresada() throws Exception
	{
		if(textAreaDescripcion.getText().equals(""))
		{
			throw new Exception ("Se debe ingresar una descripción.");
		}
		String descripcion = textAreaDescripcion.getText();
		return descripcion;
	}
	public static boolean esUnNumero(String cadena)
	{
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
	public static boolean esUnNumeroDouble(String cadena)
	{
        boolean resultado;
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
	
	public void paint (Graphics g)
    {
		super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("Archivos/logo.png");
        g.drawImage (imagen, 494, 25, 266, 111, this);
    }
}
