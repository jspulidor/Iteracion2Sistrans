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
	public long adicionarSucursal(PersistenceManager pm, int id, String ciudad, String direccion, String sector)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaSucursal () + "(id, ciudad, direccion, sector) values (?, ?, ?, ?)");
        q.setParameters(id, ciudad, direccion, sector);
        return (long) q.executeUnique();     
	}
	

}
