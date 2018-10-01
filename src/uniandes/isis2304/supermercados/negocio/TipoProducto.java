package uniandes.isis2304.supermercados.negocio;

public class TipoProducto {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador del tipo de producto
	 */
	private int id;
	 
	/**
	  * El nombre del tipo de producto 
	  */
	private String nombre;
	
	/**
	 * La categoria del  tipo de producto
	 */
	private String categoria;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public TipoProducto() 
	{
		this.id = 0;
		this.nombre = "Default";
		this.categoria = "Default";
	}

	/**
	 * Constructor con valores
	 * @param id - El identificador del tipo de bebida
	 * @param nombre - El nombre del tipo de bebida
	 */
	public TipoProducto(int id, String nombre,String categoria) 
	{
		this.id = id;
		this.nombre = nombre;
		this.categoria=categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del tipo de producto
	 */
	@Override
	public String toString() 
	{
		return "TipoProducto [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}

	/**
	 * @param tipo - El Tipoproducto a comparar
	 * @return True si tienen el mismo nombre y la misma categoria
	 */
	public boolean equals(Object tipo) 
	{
		TipoProducto tb = (TipoProducto) tipo;
		return id == tb.id && nombre.equalsIgnoreCase (tb.nombre) && categoria.equalsIgnoreCase (tb.categoria);
	}
	
}
