package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public interface VOFactura
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public int getId();
	
	public int getIdVisitaMercado();
	
	public Double getTotal();
	
	public String toString();
}
