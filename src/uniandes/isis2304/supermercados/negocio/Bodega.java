package uniandes.isis2304.supermercados.negocio;

/**
 * Clase para modelar el concepto BODEGA del negocio de SuperAndes
 */

public class Bodega {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Identificador único de la clase Bodega
	 */
	private int id;
	
	/**
	 * Categoría de la bodega
	 */
	private String categoria;
	
	/**
	 * Capacidad de la bodega
	 */
	private int capacidad;
	
	/**
	 * Cantidad de productos disponibles en la bodega
	 */
	private int cantidadProductos;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Bodega()
	{
		id = 0;
		categoria = "Default";
		capacidad = 0;
		cantidadProductos=0;
	}
	
	public Bodega (int pId, String pCategoria, int pCapacidad, int cantidadProductos)
	{
		this.id=pId;
		this.categoria=pCategoria;
		this.capacidad=pCapacidad;
		this.cantidadProductos=cantidadProductos;
	}
	
	/**
	 * Retorna una cadena con la información de la bodega
	 */
	@Override
	public String toString() {
		return "Bodega [id=" + id + ", categoria=" + categoria + ", capacidad=" + capacidad + ", cantidadProductos="
				+ cantidadProductos + "]";
	}
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	
	
	
}
