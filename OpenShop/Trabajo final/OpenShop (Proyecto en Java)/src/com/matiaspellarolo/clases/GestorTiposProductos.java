package com.matiaspellarolo.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class GestorTiposProductos implements Serializable
{
	private ArrayList<TipoProducto> tiposProductos = new ArrayList<TipoProducto>();
	
	public void agregarTipoProducto(int id, String nombre, int idCategoria)
	{
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setId(id);
		tipoProducto.setNombre(nombre);
		tipoProducto.setIdCategoria(idCategoria);
		tiposProductos.add(tipoProducto);
	}
	public void mostrarTiposProductos()
	{
		for(TipoProducto tipoProducto: tiposProductos)
		{
			System.out.println("ID: " + tipoProducto.getId() + " - Nombre: " + tipoProducto.getNombre() + ".");
		}
	}
	public int buscarIdTipoProducto(String nombre)
	{
		for(TipoProducto tipoProducto: tiposProductos)
		{
			if(tipoProducto.getNombre() == nombre) return tipoProducto.getId();
		}
		return -1;
	}
	public String buscarNombreTipoCategoria(int id)
	{
		for(TipoProducto tipoProducto: tiposProductos)
		{
			if(tipoProducto.getId() == id) return tipoProducto.getNombre();
		}
		return null;
	}
	public int buscarIdCategoria(int id)
	{
		for(TipoProducto tipoProducto: tiposProductos)
		{
			if(tipoProducto.getId() == id) return tipoProducto.getIdCategoria();
		}
		return -1;
	}
	public ArrayList<TipoProducto> getTiposProductos()
	{
		return tiposProductos;
	}
	public void setTiposProductos(ArrayList<TipoProducto> tiposProductos)
	{
		this.tiposProductos = tiposProductos;
	}
}
