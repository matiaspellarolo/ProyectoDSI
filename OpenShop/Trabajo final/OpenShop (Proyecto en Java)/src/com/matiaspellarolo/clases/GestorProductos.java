package com.matiaspellarolo.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class GestorProductos
{
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public void agregarProducto(int id, String nombre, String marca, double precio, int stock, String descripcion, int idTipoProducto, String nombreTipoProducto, String nombreCategoria)
	{
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(nombre);
		producto.setMarca(marca);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setDescripcion(descripcion);
		producto.setIdTipoProducto(idTipoProducto);
		producto.setNombreCategoria(nombreCategoria);
		producto.setNombreTipoProducto(nombreTipoProducto);
		productos.add(producto);
	}
	public void modificarProducto(int idOriginal, int id, String nombre, String marca, double precio, int stock, String descripcion, int idTipoProducto, String nombreTipoProducto, String nombreCategoria)
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
				producto.setIdTipoProducto(idTipoProducto);
				producto.setNombreCategoria(nombreCategoria);
				producto.setNombreTipoProducto(nombreTipoProducto);
			}
		}
	}
	public void eliminarProducto(int id)
	{
		Producto productoAEliminar = null;
		for(Producto producto: productos)
		{
			if(producto.getId() == id)
			{
				productoAEliminar = producto;
			}
		}
		productos.remove(productoAEliminar);
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
	public void setProductos(ArrayList<Producto> productos)
	{
		this.productos = productos;
	}
}
