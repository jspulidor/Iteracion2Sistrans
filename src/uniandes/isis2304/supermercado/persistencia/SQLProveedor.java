package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLProveedor {

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
	public SQLProveedor(PersistenciaSuperAndes pPs)
	{
		this.ps=pPs;
	}
	
	/**
	 * Método que adiciona una bodega a la base de datos de SuperAndes
	 */
	public long adicionarProveedor(PersistenceManager pm, int NIT, int nombre, Double calificacionCalidad)
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProveedor () + "(NIT, nombre, calificacionCalidad) values (?, ?, ?, ?)");
        q.setParameters(NIT, nombre, calificacionCalidad);
        return (long) q.executeUnique();     
	}
	
	
}
