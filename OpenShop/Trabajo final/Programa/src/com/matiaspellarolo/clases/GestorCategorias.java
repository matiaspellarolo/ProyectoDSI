package com.matiaspellarolo.clases;
import java.util.ArrayList;

public class GestorCategorias
{
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	/*public GestorCategorias(ArrayList<Categoria> categorias)
	{
		this.categorias = categorias;
	}*/
	public void agregarCategoria(int id, String nombre)
	{
		Categoria categoria = new Categoria(id, nombre);
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
