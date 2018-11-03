package uniandes.isis2304.supermercados.negocio;

import java.sql.Timestamp;

public interface VOCarritoCompras 
{
	/* ****************************************************************
	 *	Métodos
	 *****************************************************************/
	public int getId();
	
	public int getIdSucursal();
	
	public int getIdCliente();
	
	public String getDisponiblidad();
	
	public String getAbandonado();
}
