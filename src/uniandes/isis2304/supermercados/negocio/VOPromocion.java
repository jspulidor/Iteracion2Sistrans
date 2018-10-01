package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public interface VOPromocion {
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	public int getCantidadProductos();
	public Timestamp getFechaFin();
	public Timestamp getFechaInicio();
	public int getIdSucursal();
	public int getId();
	public Double getPrecioFinal();
	public String toString();
}
