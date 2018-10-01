package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public class Promocion implements VOPromocion {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * Id de la promocion
	 */
	private int id;
	
	/**
	 * Id de la sucursal donde la promocion está vigente
	 */
	private int idSucursal;
	
	/**
	 * Fecha de inicio de la promocion
	 */
	
	private Timestamp fechaInicio;
	
	/**
	 * Fecha final de la promocion
	 */
	private Timestamp fechaFin;
	
	/**
	 * Cantidad de productos disponibles en la promocion
	 */
	private int cantidadProductos;
	
	/**
	 * Precio Final de la promocion
	 */
	private Double precioFinal;
	
	/* ****************************************************************
	 * 			Nétodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public Promocion()
	{
		this.id=0;
		this.idSucursal=0;
		this.fechaInicio=new Timestamp(0);
		this.fechaFin = new Timestamp(0);
		this.cantidadProductos=0;
		this.precioFinal=(double) 0;
	}
	
	/**
	 * Constructor con parámetros
	 */
	public Promocion(int pId, int pSucursal, Timestamp pFechaInicio, Timestamp pFechaFin, int pCantidadProductos, Double pPrecioFinal)
	{
		this.id=pId;
		this.idSucursal=pSucursal;
		this.fechaInicio=pFechaInicio;
		this.fechaFin=pFechaFin;
		this.cantidadProductos=pCantidadProductos;
		this.precioFinal=pPrecioFinal;
	}
	
	/**
	 * Retorna una cadena de caracteres con la informacion de la promocion
	 */
	
	@Override
	public String toString() {
		return "Promocion [id=" + id + ", idSucursal=" + idSucursal + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", cantidadProductos=" + cantidadProductos + ", precioFinal=" + precioFinal + "]";
	}
	
	/* ****************************************************************
	 * 			Métodos Get y Set
	 *****************************************************************/

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public int getCantidadProductos() {
		return cantidadProductos;
	}

	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}

	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
