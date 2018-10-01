package uniandes.isis2304.supermercados.negocio;

public class Sucursal {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * La ciudad donde se encuentra la sede
	 */
	private String ciudad;
	
	/**
	 * La dirección de la sucursal
	 */
	private String direccion;
	
	/**
	 * El sector de la sucursal
	 */
	private String sector;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Sucursal()
	{
		this.setCiudad("Default");
	}
	/**
	 * Constructor con parámetros
	 * @param pCiudad La ciudad donde queda la sucursal
	 * @param pDireccion La dirección de la sucursal
	 * @param pSector El sector de la sucursal
	 */
	public Sucursal(String pCiudad, String pDireccion, String pSector)
	{
		ciudad = pCiudad;
		direccion = pDireccion;
		sector = pSector;
	}
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	/**
	 * Cadena de caracteres con todos los atributos de la sede
	 */
	@Override
	public String toString() {
		return "Sucursal [ciudad=" + ciudad + ", direccion=" + direccion + ", sector=" + sector + "]";
	}
	
}