package com.matiaspellarolo.clases;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorProductosDespachados implements Serializable
{
	private ArrayList<ProductoDespachado> productosDespachados = new ArrayList<ProductoDespachado>();

	public ArrayList<ProductoDespachado> getProductosDespachados() {
		return productosDespachados;
	}
	public void setProductosDespachados(ArrayList<ProductoDespachado> productosDespachados) {
		this.productosDespachados = productosDespachados;
	}
	
}
