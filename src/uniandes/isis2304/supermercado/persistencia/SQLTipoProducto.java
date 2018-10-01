package uniandes.isis2304.supermercado.persistencia;

import java.math.BigDecimal;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercado.persistencia.*;
import uniandes.isis2304.supermercados.negocio.TipoProducto;

class SQLTipoProducto 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes psa;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLTipoProducto(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public long adicionarTipoProducto(PersistenceManager pm, int id, String nombre, String categoria)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaTipoProducto() +"(id, nombre,categoria) values (?, ?, ?)");
		sql.setParameters(id, nombre, categoria);
		return (long) sql.executeUnique();
	}
	
	public List<TipoProducto> darTiposProducto (PersistenceManager pm)
	{
		Query sql = pm.newQuery(SQL, "SELECT * FROM "+psa.darTablaTipoProducto());
		sql.setResultClass(TipoProducto.class);
		return (List<TipoProducto>) sql.executeList();
	}
}
