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
	 * Identificador de la visita a la sucursal
	 */
	
	private int idVisitaMercado;
	
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
		idVisitaMercado = 0;
		total = (double) 0;
	}
	
	public Factura (int pId, int pIdVisitaMercado, Double pTotal)
	{
		this.id=pId;
		this.idVisitaMercado = pIdVisitaMercado;
		this.total=pTotal;
	}
	
	/**
	 * Retorna una cadena de caracteres con la informacion de la factura
	 */
	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", visitaMercado=" + idVisitaMercado + ", total=" + total + "]";
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

	public int getIdVisitaMercado() {
		return idVisitaMercado;
	}

	public void setCantidadProductos(int pIdVisitaMercado) {
		this.idVisitaMercado = pIdVisitaMercado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
