package uniandes.isis2304.supermercados.negocio;

public class Producto {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador único del producto 
	 */
	private int id;
	
	/**
	 * Nombre del producto
	 */
	private String nombre;
	
	/**
	 * Marca del producto
	 */
	private String marca; 
	
	/**
	 * Precio Unitario del producto
	 */
	private double precioUnitario;
	
	/**
	 * Presentación del producto
	 */
	private String presentacion;
	
	/**
	 * Precio por medida del producto
	 */
	private Double precioXMedida;
	
	/**
	 * Cantidad en presentación del prodcuto
	 */
	private int cantidadPresentacion;
	
	/**
	 * Unidad de medida del producto
	 */
	private String unidadMedida;
	
	/**
	 * Empacado del producto
	 */
	private String empacado;
	
	/**
	 * Código de Barras del producto
	 */
	private String codigoBarras;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto	
	 */
	public Producto()
	{
		this.id=0;
		this.nombre="Default";
		this.marca="Default";
		this.precioUnitario=0;
		this.presentacion="Default";
		this.precioXMedida=(double) 0;
		this.cantidadPresentacion=0;
		this.unidadMedida="Default";
		this.empacado="Default";
		this.codigoBarras="Default";
	}
	
	public Producto(int pId, String pNombre, String pMarca, Double pPrecioUnitario, String pPresentacion, Double pPrecioXMedida, Integer pCantidadEnPresentacion, String pUnidadMedida, String pEmpacado, String pCodigoBarras)
	{
		this.id=pId;
		this.nombre=pNombre;
		this.marca=pMarca;
		this.precioUnitario=pPrecioUnitario;
		this.presentacion=pPresentacion;
		this.precioXMedida=pPrecioXMedida;
		this.cantidadPresentacion=pCantidadEnPresentacion;
		this.unidadMedida=pUnidadMedida;
		this.empacado=pEmpacado;
		this.codigoBarras=pCodigoBarras;
	}
	
	/**
	 * Retorna una cadena con la información del producto
	 */
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precioUnitario=" + precioUnitario
				+ ", presentacion=" + presentacion + ", precioXMedida=" + precioXMedida + ", cantidadPresentacion="
				+ cantidadPresentacion + ", unidadMedida=" + unidadMedida + ", empacado=" + empacado + ", codigoBarras="
				+ codigoBarras + "]";
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

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Double getPrecioXMedida() {
		return precioXMedida;
	}

	public void setPrecioXMedida(Double precioXMedida) {
		this.precioXMedida = precioXMedida;
	}

	public int getCantidadPresentacion() {
		return cantidadPresentacion;
	}

	public void setCantidadPresentacion(int cantidadPresentacion) {
		this.cantidadPresentacion = cantidadPresentacion;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getEmpacado() {
		return empacado;
	}

	public void setEmpacado(String empacado) {
		this.empacado = empacado;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
}
