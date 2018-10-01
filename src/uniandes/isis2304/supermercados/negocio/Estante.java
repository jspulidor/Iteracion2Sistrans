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
	 * Tipo de producto que se guarda en el estante
	 */
	private int tipoProducto;
	
	/**
	 * Id de la sucursal a la que pertenece el estante
	 */
	
	private int sucursal;
	
	/**
	 * Capacidad en volumen del estante
	 */
	private Double capacidadVolumen;
	
	/**
	 * Capacidad en peso del estante
	 */
	private Double capacidadPeso;
	
	/**
	 * Nivel de abastecimiento del estante
	 */
	private int nivelAbastecimiento;

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Estante()
	{
		setId(0);
		this.tipoProducto=0;
		this.sucursal=0;
		this.capacidadVolumen=(double) 0;
		this.capacidadPeso=(double) 0;
		this.nivelAbastecimiento=0;
	}
	
	/**
	 * Constructor con parámetros
	 * @param pId
	 * @param pCapacidad
	 * @param pCategoria
	 */
	public Estante(int pId, int pTipoProducto, int pSucursal, Double pCapacidadVolumen,Double pCapacidadPeso, int pNivelAbastecimiento)
	{
		setId(pId);
		this.setTipoProducto(pTipoProducto);
		this.sucursal=pSucursal;
		this.capacidadPeso=pCapacidadPeso;
		this.capacidadVolumen=pCapacidadVolumen;
		this.nivelAbastecimiento=pNivelAbastecimiento;
		
	}
	

	/**
	 * Retorna una cadena con la información del estante
	 */
	
	@Override
	public String toString() {
		return "Estante [id=" + id + ", tipoProducto=" + tipoProducto + ", sucursal=" + sucursal + ", capacidadVolumen="
				+ capacidadVolumen + ", capacidadPeso=" + capacidadPeso + ", nivelAbastecimiento=" + nivelAbastecimiento
				+ "]";
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

	public Double getCapacidadVolumen() {
		return capacidadVolumen;
	}

	public void setCapacidadVolumen(Double capacidadVolumen) {
		this.capacidadVolumen = capacidadVolumen;
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

	public Double getCapacidadPeso() {
		return capacidadPeso;
	}

	public void setCapacidadPeso(Double capacidadPeso) {
		this.capacidadPeso = capacidadPeso;
	}

	public int getNivelAbastecimiento() {
		return nivelAbastecimiento;
	}

	public void setNivelAbastecimiento(int nivelAbastecimiento) {
		this.nivelAbastecimiento = nivelAbastecimiento;
	}
	
}
