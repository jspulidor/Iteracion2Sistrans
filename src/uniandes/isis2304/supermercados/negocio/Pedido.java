package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class Pedido implements VOPedido {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador único del pedido
	 */
	private int id;
	
	/**
	 * Id de la sucursal que hizo el pedido
	 */
	private int idSucursal;
	
	/**
	 * Id del proveedor que hara el pedido
	 */
	private int idProveedor;
	
	/**
	 * Id del producto que se ordeno en el pedido
	 */
	private int idProducto;
	
	/**
	 * Fecha esperada entrega del pedido
	 */
	
	private Timestamp fechaEsperadaEntrega;
	
	/**
	 * La cantidad del pedido
	 */
	private double cantidad;

	/**
	 * El precio del pedido
	 */
	private double precio;

	/**
	 * La fecha de entrega del pedido
	 */
	private Timestamp fechaEntrega;
	
	/**
	 * Calidad de los productos entregados
	 */
	private int calidadProductos;
	
	/**
	 * Estado del pedido
	 */
	private String estado;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor por defecto
	 */
	public Pedido (){
		id = 0;
		idSucursal=0;
		idProveedor=0;
		idProducto=0;
		fechaEsperadaEntrega=new Timestamp(0);
		cantidad = 0;
		precio = 0;
		fechaEntrega = new Timestamp (0);
		calidadProductos=0;
		estado="Default";
	}
	
	/**
	 * Constructor con parámetros
	 * @param pId
	 * @param pCantidad
	 * @param pPrecio
	 * @param pFechaEntrega
	 */
	
	public Pedido( int pId,int pIdSucursal, int pIdProveedor, int pIdProducto, Timestamp pFechaEsperadaEntrega,   double pCantidad, double pPrecio, Timestamp pFechaEntrega, int pCalidadProductos, String pEstado)
	{
		this.id=pId;
		this.idSucursal=pIdSucursal;
		this.idProveedor=pIdProveedor;
		this.idProducto=pIdProducto;
		this.fechaEsperadaEntrega=pFechaEsperadaEntrega;
		this.cantidad=pCantidad;
		this.precio=pPrecio;
		this.fechaEntrega=pFechaEntrega;
		this.calidadProductos=pCalidadProductos;
		this.estado=pEstado;
	}


	/**
	 * Método que retorna una cadena con toda la información del pedido
	 */
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idSucursal=" + idSucursal + ", idProveedor=" + idProveedor + ", idProducto="
			+ idProducto + ", fechaEsperadaEntrega=" + fechaEsperadaEntrega + ", cantidad=" + cantidad + ", precio="
			+ precio + ", fechaEntrega=" + fechaEntrega + ", calidadProductos=" + calidadProductos + ", estado="
			+ estado + "]";

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
	
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Timestamp fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

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

	public Timestamp getFechaEsperadaEntrega() {
		return fechaEsperadaEntrega;
	}

	public void setFechaEsperadaEntrega(Timestamp fechaEsperadaEntrega) {
		this.fechaEsperadaEntrega = fechaEsperadaEntrega;
	}

	public int getCalidadProductos() {
		return calidadProductos;
	}

	public void setCalidadProductos(int calidadProductos) {
		this.calidadProductos = calidadProductos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
