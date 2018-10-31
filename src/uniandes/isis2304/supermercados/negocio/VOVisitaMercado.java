package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public interface VOVisitaMercado 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public int getId();
	
	public int getIdCarritoCompras();
	
	public int getIdCliente();
	
	public Timestamp getFechaVisita();
}
