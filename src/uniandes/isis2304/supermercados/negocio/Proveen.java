package uniandes.isis2304.supermercados.negocio;

public class Proveen {

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
	 * Precio de venta fijado por el proveedor para el producto
	 */
	private Double precio;
	
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
		this.precio=(double) 0;
	}
	
	/**
	 * Constructor con parametros
	 * @param pIdProducto
	 * @param pIdProveedor
	 * @param pPrecio
	 */
	
	public Proveen(int pIdProducto, int pIdProveedor, Double pPrecio)
	{
		this.idProducto=pIdProducto;
		this.idProveedor=pIdProveedor;
		this.precio=pPrecio;
	}
	
	/**
	 * Retorna una cadena con la informacion del objeto
	 */
	@Override
	public String toString() {
		return "Proveen [idProveedor=" + idProveedor + ", idProducto=" + idProducto + ", precio=" + precio + "]";
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

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	
}
