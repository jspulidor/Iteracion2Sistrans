package uniandes.isis2304.supermercados.negocio;

public class Proveen implements VOProveen {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Id del proveedor
	 */
	private int idProveedor;
	
	/**
	 * Id del producto que provee el proveedor
	 */
	private int idProducto;
	
	/**
	 * Id d la sucursal
	 */
	private int idSucursal;
	
	/**
	 * Precio de venta fijado por el proveedor para el producto
	 */
	private Double precioUnitario;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Proveen ()
	{
		this.idProducto=0;
		this.idProveedor=0;
		this.idSucursal=0;
		this.precioUnitario=(double) 0;
	}
	
	/**
	 * Constructor con parametros
	 * @param pIdProducto
	 * @param pIdProveedor
	 * @param pPrecio
	 */
	
	public Proveen(int pIdProducto, int pIdProveedor, int pIdSucursal, Double pPrecio)
	{
		this.idProducto=pIdProducto;
		this.idProveedor=pIdProveedor;
		this.idSucursal=pIdSucursal;
		this.precioUnitario=pPrecio;
	}
	
	/**
	 * Retorna una cadena con la informacion del objeto
	 */
	@Override
	public String toString() {
		return "Proveen [idProveedor=" + idProveedor + ", idProducto=" + idProducto + ", idSucursal=" +idSucursal+", precio=" + precioUnitario + "]";
	}

	
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/
	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getIdSucursal() {
		return idSucursal;
	}
	
	public void setIdSucursal(int pIdSucursal) {
		this.idSucursal = pIdSucursal;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Double getPrecio() {
		return precioUnitario;
	}

	public void setPrecio(Double precio) {
		this.precioUnitario = precio;
	}
	
	
	
	
}
