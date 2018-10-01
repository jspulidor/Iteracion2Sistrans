package uniandes.isis2304.supermercados.negocio;

public class Producto implements VOProducto {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Código de Barras del producto
	 */
	private String codigoBarras;
	
	/**
	 * Tipo del Producto
	 */
	private int tipo;
	
	/**
	 * Nombre del producto
	 */
	private String nombre;
	
	/**
	 * Marca del producto
	 */
	private String marca; 
	
	/**
	 * Presentación del producto
	 */
	private String presentacion;
	
	/**
	 * Unidad de medida del producto
	 */
	private String unidadMedida;
	
	
	/**
	 * Cantidad en presentación del prodcuto
	 */
	private Double cantidadPresentacion;
	
	/**
	 * Peso del empaque del producto
	 */
	private Double pesoEmpaque;
	
	/**
	 * Volumen del empaque del producto
	 */
	private Double volumenEmpaque;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto	
	 */
	public Producto()
	{
		this.nombre="Default";
		this.marca="Default";
		this.presentacion="Default";
		this.cantidadPresentacion=(double) 0;
		this.unidadMedida="Default";
		this.codigoBarras="Default";
		this.tipo=0;
		this.pesoEmpaque=(double) 0;
		this.volumenEmpaque=(double) 0;
	}
	
	public Producto( String pNombre, String pMarca, String pPresentacion,  Double pCantidadEnPresentacion, String pUnidadMedida, String pCodigoBarras, int pTipo, Double pPesoEmpaque, Double pVolumenEmpaque)
	{
		this.nombre=pNombre;
		this.marca=pMarca;
		this.presentacion=pPresentacion;
		this.cantidadPresentacion=pCantidadEnPresentacion;
		this.unidadMedida=pUnidadMedida;
		this.codigoBarras=pCodigoBarras;
		this.tipo=pTipo;
		this.pesoEmpaque=pPesoEmpaque;
		this.volumenEmpaque=pVolumenEmpaque;
	}

	/**
	 * Retorna una cadena con la información del producto
	 */
	
	@Override
	public String toString() {
		return "Producto [codigoBarras=" + codigoBarras + ", tipo=" + tipo + ", nombre=" + nombre + ", marca=" + marca
				+ ", presentacion=" + presentacion + ", unidadMedida=" + unidadMedida + ", cantidadPresentacion="
				+ cantidadPresentacion + ", pesoEmpaque=" + pesoEmpaque + ", volumenEmpaque=" + volumenEmpaque + "]";
	}
	
	
	

	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Double getCantidadPresentacion() {
		return cantidadPresentacion;
	}

	public void setCantidadPresentacion(Double cantidadPresentacion) {
		this.cantidadPresentacion = cantidadPresentacion;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Double getPesoEmpaque() {
		return pesoEmpaque;
	}

	public void setPesoEmpaque(Double pesoEmpaque) {
		this.pesoEmpaque = pesoEmpaque;
	}

	public Double getVolumenEmpaque() {
		return volumenEmpaque;
	}

	public void setVolumenEmpaque(Double volumenEmpaque) {
		this.volumenEmpaque = volumenEmpaque;
	}

	
}
