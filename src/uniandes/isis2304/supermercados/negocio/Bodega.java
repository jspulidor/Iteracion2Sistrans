package uniandes.isis2304.supermercados.negocio;

/**
 * Clase para modelar el concepto BODEGA del negocio de SuperAndes
 */

public class Bodega implements VOBodega
{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Identificador único de la clase Bodega
	 */
	private int id;
	
	/**
	 * Id del tipo de producto que se almacena en la bodega
	 */
	private int tipoProducto;
	
	/**
	 * Id de la sucursal a la que pertenece la bodega
	 */
	private int sucursal;
	
	/**
	 * Capacidad en volumen de la bodega
	 */
	
	private Double capacidadVolumen;
	
	/**
	 * Capacidad en peso de la bodega
	 */
	private Double capacidadPeso;

	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Bodega()
	{
		id = 0;
		this.tipoProducto=0;
		this.sucursal=0;
		this.capacidadVolumen=(double) 0;
		this.capacidadPeso=(double) 0;
	}
	
	public Bodega (int pId, int pTipoProducto, int pSucursal, Double pCapacidadVolumen, Double pCapacidadPeso)
	{
		this.id=pId;
		this.tipoProducto=pTipoProducto;
		this.sucursal=pSucursal;
		this.capacidadPeso=pCapacidadPeso;
		this.capacidadVolumen=pCapacidadVolumen;
	}
	
	/**
	 * Retorna una cadena con la información de la bodega
	 */
	
	@Override
	public String toString() {
		return "Bodega [id=" + id + ", tipoProducto=" + tipoProducto + ", sucursal=" + sucursal + ", capacidadVolumen="
				+ capacidadVolumen + ", capacidadPeso=" + capacidadPeso + "]";
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

	public int getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public int getSucursal() {
		return sucursal;
	}

	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	public Double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	public void setCapacidadVolumen(Double capacidadVolumen) {
		this.capacidadVolumen = capacidadVolumen;
	}

	public Double getCapacidadPeso() {
		return capacidadPeso;
	}

	public void setCapacidadPeso(Double capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}

	
	
}
