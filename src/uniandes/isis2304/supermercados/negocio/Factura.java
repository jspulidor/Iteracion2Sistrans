package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class Factura implements VOFactura
{
	
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
	
	/**
	 * Total de la factura
	 */
	private Double total;
	
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
		total=(double) 0;
	}
	
	public Factura (int pId, int pCantidadProductos, Timestamp pFechaCompra, Double pTotal)
	{
		this.id=pId;
		this.cantidadProductos=pCantidadProductos;
		this.fechaCompra = pFechaCompra;
		this.total=pTotal;
	}
	
	/**
	 * Retorna una cadena de caracteres con la informacion de la factura
	 */
	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", cantidadProductos=" + cantidadProductos + ", fechaCompra=" + fechaCompra
				+ ", total=" + total + "]";
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
