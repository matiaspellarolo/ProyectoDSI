package com.matiaspellarolo.clases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class AlmacenamientoDeDatos
{
	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	
	public static GestorCategorias cargarDatosCategorias() 
	{
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			categorias = JSON_MAPPER.readValue(new File("Archivos/Categorias.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Categoria.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GestorCategorias gestorCategorias = new GestorCategorias();
		gestorCategorias.setCategorias(categorias);
		return gestorCategorias;
	}
	public static void guardarDatosCategorias(GestorCategorias gestorCategorias)
	{
		try {
			JSON_MAPPER.writeValue(new File("Archivos/Categorias.json"), gestorCategorias.getCategorias());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static GestorTiposProductos cargarDatosTiposProductos()
	{
		ArrayList<TipoProducto> tiposProductos = new ArrayList<TipoProducto>();
		try {
			tiposProductos = JSON_MAPPER.readValue(new File("Archivos/TiposProductos.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, TipoProducto.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GestorTiposProductos gestorTiposProductos = new GestorTiposProductos();
		gestorTiposProductos.setTiposProductos(tiposProductos);
		return gestorTiposProductos;
	}
	public static void guardarDatosTiposProductos(GestorTiposProductos gestorTiposProductos)
	{
		try {
			JSON_MAPPER.writeValue(new File("Archivos/TiposProductos.json"), gestorTiposProductos.getTiposProductos());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static GestorProductos cargarDatosProductos()
	{
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			productos = JSON_MAPPER.readValue(new File("Archivos/Productos.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Producto.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GestorProductos gestorProductos= new GestorProductos();
		gestorProductos.setProductos(productos);
		return gestorProductos;
	}
	public static void guardarDatosProductos(GestorProductos gestorProductos)
	{
		try {
			JSON_MAPPER.writeValue(new File("Archivos/Productos.json"), gestorProductos.getProductos());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static GestorProductosDespachados cargarDatosProductosVendidos()
	{
		ArrayList<ProductoDespachado> productosDespachados = new ArrayList<ProductoDespachado>();
		try {
			productosDespachados = JSON_MAPPER.readValue(new File("Archivos/ProductosDespachados.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, ProductoDespachado.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GestorProductosDespachados gestorProductosDespachados = new GestorProductosDespachados();
		gestorProductosDespachados.setProductosDespachados(productosDespachados);
		return gestorProductosDespachados;
	}
	public static void guardarDatosProductosDespachados(GestorProductosDespachados gestorProductosDespachados)
	{
		try {
			JSON_MAPPER.writeValue(new File("Archivos/ProductosDespachados.json"), gestorProductosDespachados.getProductosDespachados());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static GestorUsuarios cargarDatosUsuarios()
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = JSON_MAPPER.readValue(new File("Archivos/Usuarios.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Usuario.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GestorUsuarios gestorUsuarios = new GestorUsuarios();
		gestorUsuarios.setUsuarios(usuarios);
		return gestorUsuarios;
	}
	public static void guardarDatosUsuarios(GestorUsuarios gestorUsuarios)
	{
		try {
			JSON_MAPPER.writeValue(new File("Archivos/Usuarios.json"), gestorUsuarios.getUsuarios());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
