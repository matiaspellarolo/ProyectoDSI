package com.matiaspellarolo.clases;

import java.util.ArrayList;

public class GestorProductos
{
private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	/*public GestorCategorias(ArrayList<Categoria> categorias)
	{
		this.categorias = categorias;
	}*/
	public void agregarProducto(int id, String nombre, String marca, double precio, int stock, String descripcion, int tipoProducto)
	{
		Producto producto = new Producto(id, nombre, marca, precio, stock, descripcion, tipoProducto);
		productos.add(producto);
	}
	public void modificarProducto(int idOriginal, int id, String nombre, String marca, double precio, int stock, String descripcion, int tipoProducto)
	{
		for(Producto producto: productos)
		{
			if(idOriginal == producto.getId())
			{
				producto.setId(id);
				producto.setNombre(nombre);
				producto.setMarca(marca);
				producto.setPrecio(precio);
				producto.setStock(stock);
				producto.setDescripcion(descripcion);
				producto.setTipoProducto(tipoProducto);
			}
		}
	}
	public void mostrarProductos()
	{
		for(Producto producto: productos)
		{
			System.out.println("ID: " + producto.getId() + " - Nombre: " + producto.getNombre() + ".");
		}
	}
	public int buscarIdProducto(String nombre)
	{
		for(Producto producto: productos)
		{
			if(producto.getNombre() == nombre) return producto.getId();
		}
		return -1;
	}
	public Producto buscarProducto(int id)
	{
		for(Producto producto: productos)
		{
			if(producto.getId() == id) return producto;
		}
		return null;
	}
	public int cantidadProductos()
	{
		return productos.size();
	}
	public ArrayList<Producto> getProductos()
	{
		return productos;
	}
	public void setProductos(ArrayList<Producto> producto)
	{
		this.productos = productos;
	}
}
