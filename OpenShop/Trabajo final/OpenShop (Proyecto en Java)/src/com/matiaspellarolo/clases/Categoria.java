package com.matiaspellarolo.clases;

import java.io.Serializable;

public class Categoria implements Serializable
{
	private int id;
	private String nombre;
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getId()
	{
		return id;
	}
	public String getNombre()
	{
		return nombre;
	}
}
