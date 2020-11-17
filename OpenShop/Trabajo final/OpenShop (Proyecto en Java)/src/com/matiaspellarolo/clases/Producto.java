package com.matiaspellarolo.clases;
public class Producto
{
	private int id;
	private String nombre, marca, descripcion;
	private double precio;
	private int stock;
	private int idTipoProducto;
	private String nombreTipoProducto;
	private String nombreCategoria;
	
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
	public void setIdTipoProducto(int idTipoProducto)
	{
		this.idTipoProducto = idTipoProducto;
	}
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
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
	public int getIdTipoProducto()
	{
		return idTipoProducto;
	}
}
