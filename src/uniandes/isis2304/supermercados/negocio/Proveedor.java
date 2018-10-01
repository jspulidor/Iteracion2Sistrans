package uniandes.isis2304.supermercados.negocio;

public class Proveedor implements VOProveedor {
	
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
	
	/**
	 * Calificacion de calidad del proveedor
	 */
	private double calificacionCalidad;
	
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
		calificacionCalidad=0;
	}
	
	/**
	 * Constructor con parámetro
	 * @param pNIT 
	 * @param pNombre
	 */
	public Proveedor (int pNIT, String pNombre, Double pCalificacionCalidad)
	{
		NIT = pNIT;
		nombre = pNombre;
		calificacionCalidad=pCalificacionCalidad;
	}
	

	/**
	 * Método que retorna una cadena de con la información del proveedor
	 */
	@Override
	public String toString() {
		return "Proveedor [NIT=" + NIT + ", nombre=" + nombre + ", calificacionCalidad=" + calificacionCalidad + "]";
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
	
	public double getCalificacionCalidad() {
		return calificacionCalidad;
	}

	public void setCalificacionCalidad(double calificacionCalidad) {
		this.calificacionCalidad = calificacionCalidad;
	}


	

}
