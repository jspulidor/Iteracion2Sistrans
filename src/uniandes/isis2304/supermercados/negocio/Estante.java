package uniandes.isis2304.supermercados.negocio;

public class Estante {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Identificador único del estante
	 */
	private int id;
	
	/**
	 * Capacidad del estante
	 */
	private int capacidad;
	
	/**
	 * Categoría del estante
	 */
	private String categoria;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Estante()
	{
		setId(0);
		setCapacidad(0);
		setCategoria("Default");
	}
	
	/**
	 * Constructor con parámetros
	 * @param pId
	 * @param pCapacidad
	 * @param pCategoria
	 */
	public Estante(int pId, int pCapacidad, String pCategoria)
	{
		setId(pId);
		this.setCapacidad(pCapacidad);
		this.setCategoria(pCategoria);
		
	}
	
	/**
	 * Retorna una cadena con la información del estante
	 */
	@Override
	public String toString() {
		return "Estante [id=" + id + ", capacidad=" + capacidad + ", categoria=" + categoria + "]";
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
