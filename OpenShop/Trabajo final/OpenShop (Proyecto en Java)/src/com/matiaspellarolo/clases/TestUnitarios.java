package com.matiaspellarolo.clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.matiaspellarolo.interfazgrafica.*;

class TestUnitarios {

	GestorCategorias gestorCategorias = AlmacenamientoDeDatos.cargarDatosCategorias();
	GestorTiposProductos gestorTiposProductos = AlmacenamientoDeDatos.cargarDatosTiposProductos();
	GestorUsuarios gestorUsuarios = AlmacenamientoDeDatos.cargarDatosUsuarios();
	GestorProductos gestorProductos = AlmacenamientoDeDatos.cargarDatosProductos();
	AgregarProducto agregarProducto = new AgregarProducto(gestorCategorias, gestorTiposProductos, gestorProductos);
	ModificarProducto1 modificarProducto1 = new ModificarProducto1(gestorProductos);
	
	
	@Test
	void ingresoUsuarioConDatosCorrectos() {
		assertEquals(1, gestorUsuarios.verificarIngreso("matiaspellarolo", "1234"));
	}
	
	@Test
	void ingresoUsuarioConContraseñaIncorrecta() {
		assertEquals(2, gestorUsuarios.verificarIngreso("matiaspellarolo", "def"));
	}
	
	@Test
	void ingresoUsuarioConNombreIncorrecto() {
		assertEquals(3, gestorUsuarios.verificarIngreso("rfegbrf", "1234"));
	}
	
	@Test
	void idIngresadoCorrecto() throws Exception {
		agregarProducto.textFieldId.setText("55");
		int id = agregarProducto.idIngresado(gestorProductos);
		assertEquals(55, id);
	}
	
	@Test
	void nombreIngresadoCorrecto() throws Exception {
		agregarProducto.textFieldNombre.setText("Celular");
		String nombre = agregarProducto.nombreIngresado();
		assertEquals("Celular", nombre);
	}
	
	@Test
	void marcaIngresadaCorrecta() throws Exception {
		agregarProducto.textFieldMarca.setText("Samsung");
		String marca = agregarProducto.marcaIngresada();
		assertEquals("Samsung", marca);
	}
	
	@Test
	void precioIngresadaCorrecto() throws Exception {
		agregarProducto.textFieldPrecio.setText("23999");
		double precio = agregarProducto.precioIngresado();
		assertEquals(23999, precio);
	}
	
	@Test
	void stockIngresadaCorrecto() throws Exception {
		agregarProducto.textFieldStock.setText("30");
		int stock = agregarProducto.stockIngresado();
		assertEquals(30, stock);
	}
	
	@Test
	void idTipoProductoSeleccionadoCorrecto() throws Exception {
		agregarProducto.comboBoxCategoria.setSelectedIndex(1);
		agregarProducto.comboBoxTipoProducto.setSelectedIndex(1);
		int idTipoProducto = agregarProducto.idTipoProductoSeleccionado(gestorTiposProductos);
		assertEquals(34501, idTipoProducto);
	}
	
	@Test
	void nombreTipoProductoSeleccionadoCorrecto() throws Exception {
		agregarProducto.comboBoxCategoria.setSelectedIndex(1);
		agregarProducto.comboBoxTipoProducto.setSelectedIndex(1);
		String nombreTipoProducto = (String) agregarProducto.comboBoxTipoProducto.getSelectedItem();
		assertEquals("Climatización", nombreTipoProducto);
	}
	
	@Test
	void nombreCategoriaSeleccionadaCorrecta() throws Exception {
		agregarProducto.comboBoxCategoria.setSelectedIndex(1);
		agregarProducto.comboBoxTipoProducto.setSelectedIndex(1);
		String nombreCategoria = (String) agregarProducto.comboBoxCategoria.getSelectedItem();
		assertEquals("Electrodomésticos", nombreCategoria);
	}
	
	@Test
	void idDeProductoAModificarCorrecto() throws Exception {
		modificarProducto1.textFieldId.setText("1");
		int id = modificarProducto1.idIngresado(gestorProductos);
		assertEquals(1, id);
	}
}
