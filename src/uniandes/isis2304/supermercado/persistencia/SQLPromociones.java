package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLPromociones 
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
	public SQLPromociones(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una PROMOCIONES a la base de datos de SuperAndes
	 * @param idPromocion - El identificador de la promocion
	 * @param idProducto - El identificador del producto
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarPromociones(PersistenceManager pm, int idPromocion, int idProducto)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO" +psa.darTablaPromociones()+ "(id_promocion, id_producto) values (?, ?)");
		sql.setParameters(idPromocion, idProducto);
		return (long) sql.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para finalizar una PROMOCION a la base de datos de SuperAndes
	 * @param idPromocion - El identificador de la promocion
	 * @param idSucursal - El identificador de la sucursal
	 * @return EL número de tuplas insertadas
	 */
	public long finalizarPromociones(PersistenceManager pm, int idPromocion, int idProducto)
	{
		Query sql = pm.newQuery(SQL, "DELETE FROM" +psa.darTablaPromociones() + "WHERE id_promocion = PROMOCION.id AND id_producto = ?");
		sql.setParameters(idPromocion, idProducto);
		return (long) sql.executeUnique();
	}
	
}
