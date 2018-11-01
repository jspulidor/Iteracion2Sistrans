package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;

import javax.jdo.Query;
public class SQLCarritoCompras 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra ac� para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicaci�n
	 */
	private PersistenciaSuperAndes psa;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicaci�n
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
	 * @param Abandonado - El carrito tiene due�o o no
	 * @return EL n�mero de tuplas insertadas
	 */	
	public long adicionarCarritoCompras(PersistenceManager pm, int id, int idSucursal, String Disponibilidad, String Abandonado)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaCarritoCompras()+ "(id, idSucursal, Disponibilidad, Abandonado) values (?, ? , ?, ?)");
		sql.setParameters(id, idSucursal, Disponibilidad, Abandonado);
		return (long) sql.executeUnique();
	}
}