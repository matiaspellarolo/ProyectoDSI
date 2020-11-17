package com.matiaspellarolo.clases;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorCategorias implements Serializable
{
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	public void agregarCategoria(int id, String nombre)
	{
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setNombre(nombre);
		categorias.add(categoria);
	}
	public void mostrarCategorias()
	{
		for(Categoria categoria: categorias)
		{
			System.out.println("ID: " + categoria.getId() + " - Nombre: " + categoria.getNombre() + ".");
		}
	}
	public int buscarIdCategoria(String nombre)
	{
		for(Categoria categoria: categorias)
		{
			if(categoria.getNombre() == nombre) return categoria.getId();
		}
		return -1;
	}
	public String buscarNombreCategoria(int id)
	{
		for(Categoria categoria: categorias)
		{
			if(categoria.getId() == id) return categoria.getNombre();
		}
		return null;
	}
	public ArrayList<Categoria> getCategorias()
	{
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias)
	{
		this.categorias = categorias;
	}
}
