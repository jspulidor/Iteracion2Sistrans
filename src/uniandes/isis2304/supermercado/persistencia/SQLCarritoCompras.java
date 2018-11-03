package uniandes.isis2304.supermercado.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;

import javax.jdo.Query;
public class SQLCarritoCompras 
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
	public SQLCarritoCompras(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un CARRITOCOMPRAS a la base de datos de SuperAndes
	 * @param id - Identificador del carrito
	 * @param idSucursal - Identificador de la sucursal
	 * @param Disponibilidad - Disponibilidad del carrito
	 * @param Abandonado - El carrito tiene cliente o no
	 * @return EL número de tuplas insertadas
	 */	
	public long solicitarCarritoCompras(PersistenceManager pm, int id, int idSucursal, int idCliente, String Disponibilidad, String Abandonado, Timestamp fechaVisista)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaCarritoCompras()+ "(id, id_sucursal, id_cliente, disponibilidad, abandonado, fecha_visita) values (?, ? , ?, ?, ?, ?)");
		sql.setParameters(id, idSucursal, idCliente, Disponibilidad, Abandonado, fechaVisista);
		return (long) sql.executeUnique();
	}
}
