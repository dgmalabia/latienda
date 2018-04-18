package com.tienda.dao;

/**
 * 
 * @author garrida
 * He creado esta subclase de Producto para reutilizar la misma estructura de datos de la clase Producto pero añadiendo una interfaz 
 * de acceso más limpia y métodos de acceso a sus atributos get / set para seguir una nomenclatura y buena práctica
 */
public class ProductoExtended extends Producto {

	/**
	 * 
	 * @param nombre
	 * @param caducidad
	 * @param valor
	 */
	public ProductoExtended(String nombre, int caducidad, int valor) {

		super(nombre, caducidad, valor);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCaducidad() {
		return this.caducidad;
	}

	public void setCaducidad(int caducidad) {
		this.caducidad = caducidad;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void incrementarValor() {
		if (this.valor < 50) {
			this.valor++;
		}

	}

	public void decrementarValor() {
		if(valor >0)
		{
		this.valor--;
		}
	}

	public void decrementarCaducidad() {
			this.caducidad--;
	}
}
