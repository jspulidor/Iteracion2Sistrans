package uniandes.isis2304.supermercados.negocio;

public class Cliente {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Identificador único del cliente
	 */
	private int docIdentidad;
	
	/**
	 * Nombre del cliente
	 */
	private String nombre;
	
	/**
	 * Correo del cliente
	 */
	private String correo;
	
	/**
	 * Dirección del cliente
	 */
	private String direccion;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Cliente()
	{
		setDocIdentidad(0);
		setNombre("Default");
		setCorreo("Default");
		setDireccion("Default");
	}
	
	/**
	 * Constructor con parámetros
	 * @param pDocIdentidad
	 * @param pNombre
	 * @param pCorreo
	 * @param pDireccion
	 */
	public Cliente( int pDocIdentidad, String pNombre, String pCorreo, String pDireccion)
	{
		this.setDocIdentidad(pDocIdentidad);
		this.setNombre(pNombre);
		this.setCorreo(pCorreo);
		this.setDireccion(pDireccion);
	}
	
	/**
	 * Retorna una cadena con la información del cliente
	 */
	@Override
	public String toString() {
		return "Cliente [docIdentidad=" + docIdentidad + ", nombre=" + nombre + ", correo=" + correo + ", direccion="
				+ direccion + "]";
	}
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	

	public int getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(int docIdentidad) {
		this.docIdentidad = docIdentidad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
