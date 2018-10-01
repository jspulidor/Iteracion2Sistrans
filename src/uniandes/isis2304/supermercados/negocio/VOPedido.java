package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public interface VOPedido {

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
	/**
	 * Retorna el id del pedido
	 */
	
	public int getId();
	
	/**
	 * Retorna la cantidad de productos ordenada en el pedido
	 */
	
	public double getCantidad();
	
	/**
	 * Retorna el precio del pedido
	 */
	
	public double getPrecio();
	
	/**
	 * Retorna la fecha de entrega del pedido
	 */
	
	public Timestamp getFechaEntrega();
	
	
	/**
	 * Retorna el id de la sucursal que hizo el pedido
	 */
	
	public int getIdSucursal();
	
	/**
	 * Retorna el id del proveedor del pedido
	 */
	
	public int getIdProveedor();
	
	/**
	 * Retorna el id del producto ordenado
	 */
	
	public int getIdProducto();
	
	/**
	 * Retorna la fecha de entrega esperada del pedido
	 */
	
	public Timestamp getFechaEsperadaEntrega();
	
	/**
	 * Retorna la calidad de los productos entregados
	 */
	
	public int getCalidadProductos();
	
	/**
	 * Retorna el estado del pedido
	 */
	
	public String getEstado();
	
	
	/**
	 * Retorna una cadena con la informacion del pedido
	 */
	
	public String toString();
	
	
}
