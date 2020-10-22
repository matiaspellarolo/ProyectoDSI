package com.matiaspellarolo.clases;
public class TipoProducto
{
	private int id;
	private String nombre;
	private int idCategoria;
	
	public TipoProducto(int id, String nombre, int idCategoria)
	{
		this.id = id;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setIdCategoria(int idCategoria)
	{
		this.idCategoria = idCategoria;
	}
	public int getId()
	{
		return id;
	}
	public String getNombre()
	{
		return nombre;
	}
	public int getIdCategoria()
	{
		return idCategoria;
	}
	
}
