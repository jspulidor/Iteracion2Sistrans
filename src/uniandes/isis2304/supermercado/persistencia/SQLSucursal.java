package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLSucursal {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	
	private final static String SQL =PersistenciaSuperAndes.SQL;
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private PersistenciaSuperAndes ps;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor de la clase
	 */
	public SQLSucursal(PersistenciaSuperAndes pPs)
	{
		this.ps=pPs;
	}
	
	/**
	 * Método que adiciona una sucursal a la base de datos de SuperAndes
	 */
	public long adicionarSucursal(PersistenceManager pm, int id, String ciudad, String sector, String direccion)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaSucursal () + "(id, ciudad, sector, direccion) values (?, ?, ?, ?)");
        q.setParameters(id, ciudad, sector, direccion);
        return (long) q.executeUnique();     
	}
	

}
