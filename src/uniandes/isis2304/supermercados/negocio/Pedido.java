package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class Pedido {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador único del pedido
	 */
	private int id;

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
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor por defecto
	 */
	public Pedido (){
		id = 0;
		cantidad = 0;
		precio = 0;
		fechaEntrega = new Timestamp (0);
	}
	
	/**
	 * Constructor con parámetros
	 * @param pId
	 * @param pCantidad
	 * @param pPrecio
	 * @param pFechaEntrega
	 */
	
	public Pedido( int pId, double pCantidad, double pPrecio, Timestamp pFechaEntrega)
	{
		this.id=pId;
		this.cantidad=pCantidad;
		this.precio=pPrecio;
		this.fechaEntrega=pFechaEntrega;
	}
	
	/**
	 * Método que retorna una cadena con toda la información del pedido
	 */
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", fechaEntrega=" + fechaEntrega
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
	
}
