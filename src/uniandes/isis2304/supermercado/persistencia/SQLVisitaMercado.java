package uniandes.isis2304.supermercado.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
public class SQLVisitaMercado 
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
	public SQLVisitaMercado(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una VISITAMERCADO a la base de datos de SuperAndes
	 * @param id - Identificador del carrito
	 * @param idCarritoCompras - Identificador del carrito
	 * @param idCliente - Identificador del cliente
	 * @param fechaVisita - Fecha de la visita
	 * @return EL número de tuplas insertadas
	 */	
	public long adicionarVisitaMercado(PersistenceManager pm, int id, int idCarritoCompras, int idCliente, Timestamp fechaVisita)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaVisitaMercado()+ "(id, idCarritoCompras, idCliente, fechaVisita) values (?, ? , ?, ?)");
		sql.setParameters(id, idCarritoCompras, idCliente, fechaVisita);
		return (long) sql.executeUnique();
	}
}
