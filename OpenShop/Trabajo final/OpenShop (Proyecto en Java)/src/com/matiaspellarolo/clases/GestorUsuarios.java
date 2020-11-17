package com.matiaspellarolo.clases;

import java.util.ArrayList;

public class GestorUsuarios 
{
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void agregarUsuario (int id, String nombre, String contrase�a)
	{
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setContrase�a(contrase�a);
		usuarios.add(usuario);
	}
	
	public int verificarIngreso(String nombre, String contrase�a)
	{
		boolean seEncontroUsuario = false;
		int r = 0;
		for(Usuario usuario: usuarios)
		{
			if(usuario.getNombre().equals(nombre))
			{
				seEncontroUsuario = true;
				if(usuario.getContrase�a().equals(contrase�a))
				{
					r = 1;
				}
				else
				{
					r = 2;
				}
			}
		}
		if(!seEncontroUsuario)
		{
			r = 3;
		}
		return r;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
