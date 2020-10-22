package com.matiaspellarolo.clases;
public class Producto
{
	private int id;
	private String nombre, marca, descripcion;
	private double precio;
	private int stock;
	private int tipoProducto;
	
	public Producto(int id, String nombre, String marca, double precio, int stock, String descripcion, int tipoProducto)
	{
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.tipoProducto = tipoProducto;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	public void setPrecio(double precio)
	{
		this.precio = precio;
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public void setTipoProducto(int tipoProducto)
	{
		this.tipoProducto = tipoProducto;
	}
	public int getId()
	{
		return id;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getMarca()
	{
		return marca;
	}
	public double getPrecio()
	{
		return precio;
	}
	public int getStock()
	{
		return stock;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public int getTipoProducto()
	{
		return tipoProducto;
	}
	
}
