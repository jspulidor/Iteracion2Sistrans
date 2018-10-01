package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class Factura {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Identificador único de la factura
	 */
	
	private int id;
	
	/**
	 * Cantidad de productos de la factura
	 */
	
	private int cantidadProductos;
	
	/**
	 * Fecha de expedicion factura
	 */
	
	private Timestamp fechaCompra;
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto 
	 */
	
	public Factura()
	{
		id = 0;
		setCantidadProductos(0);
		setFechaCompra(new Timestamp(0));
	}
	
	public Factura (int pId, int pCantidadProductos, Timestamp pFechaCompra)
	{
		this.id=pId;
		this.cantidadProductos=pCantidadProductos;
		this.fechaCompra = pFechaCompra;
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

	public int getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public Timestamp getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Timestamp fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
}
