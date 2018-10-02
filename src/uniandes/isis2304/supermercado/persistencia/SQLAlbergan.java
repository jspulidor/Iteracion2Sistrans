package uniandes.isis2304.supermercado.persistencia;

import java.util.List;
import java.util.concurrent.Delayed;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercado.persistencia.*;
import uniandes.isis2304.supermercados.negocio.*;

class SQLAlbergan 
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
	public SQLAlbergan (PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALBERGAN a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del producto
	 * @param idEstante - El identificador del estante
	 * @param cantidadProducto - Cantidad del producto que alberga
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarAlbergan(PersistenceManager pm, int idProducto, int idEstante, int cantidadProducto) 
	{
        Query sql = pm.newQuery(SQL, "INSERT INTO " +psa.darTablaAlbergan()+ "(idProducto, idEstante, cantidadProducto) values (?, ?, ?)");
        sql.setParameters(idProducto, idEstante, cantidadProducto);
        return (long)sql.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un ALBERGAN de la base de datos de SuperAndes, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del produto
	 * @param idEstante - El identificador del estante
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAlbergan(PersistenceManager pm, int idProducto, int idEstante) 
	{
        Query sql = pm.newQuery(SQL, "DELETE FROM " +psa.darTablaAlbergan()+ " WHERE idProducto = ? AND idEstante = ?");
        sql.setParameters(idProducto, idEstante);
        return (long) sql.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ALBERGAN de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ALBERGAN
	 */
	public List<Albergan> darAlbergan(PersistenceManager pm)
	{
		Query sql = pm.newQuery(SQL, "SELECT * FROM " +psa.darTablaAlbergan());
		sql.setResultClass(Albergan.class);
		return (List<Albergan>) sql.execute();
	}
}
