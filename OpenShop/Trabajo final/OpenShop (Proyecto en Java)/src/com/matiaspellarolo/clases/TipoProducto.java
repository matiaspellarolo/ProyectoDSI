package com.matiaspellarolo.clases;

import java.io.Serializable;

public class TipoProducto implements Serializable
{
	private int id;
	private String nombre;
	private int idCategoria;
	
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
