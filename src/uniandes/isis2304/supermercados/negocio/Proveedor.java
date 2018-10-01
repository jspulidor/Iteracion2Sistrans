package uniandes.isis2304.supermercados.negocio;

public class Proveedor {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El NIT único del proveedor
	 */
	private int NIT;
	
	/**
	 * El nombre del proveedor 
	 */
	private String nombre;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Proveedor ()
	{
		NIT = 0;
		nombre = "Default";
	}
	
	/**
	 * Constructor con parámetro
	 * @param pNIT 
	 * @param pNombre
	 */
	public Proveedor (int pNIT, String pNombre)
	{
		NIT = pNIT;
		nombre = pNombre;
	}
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	public int getNIT() {
		return NIT;
	}

	public void setNIT(int pNIT) {
		NIT = pNIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método que retorna una cadena de con la información del proveedor
	 */
	@Override
	public String toString() {
		return "Proveedor [NIT=" + NIT + ", nombre=" + nombre + "]";
	}
	

}
