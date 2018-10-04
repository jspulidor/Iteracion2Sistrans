package uniandes.isis2304.supermercado.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercados.negocio.*;
import uniandes.isis2304.supermercado.persistencia.*;

class SQLAlmacenan 
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
	public SQLAlmacenan(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAN a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del producto
	 * @param idBodega - El identificador de la bodega
	 * @param cantidadProducto - Cantidad del producto que almacena
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarAlmacenan(PersistenceManager pm, int idProducto, int idBodega, int cantidadProducto) 
	{
        Query sql = pm.newQuery(SQL, "INSERT INTO " +psa.darTablaAlbergan()+ "(id_producto, id_bodega, cantidad_producto) values (?, ?, ?)");
        sql.setParameters(idProducto, idBodega, cantidadProducto);
        return (long)sql.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para aumentar en una cantidad el número de productos almacenados de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return El número de tuplas modificadas
	 */
	public long aumentarProductoEnBodega(PersistenceManager pm, String idBodega, String idProducto, int cantidad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaAlmacenan() + " SET cantidad_producto = cantidad_producto + "+cantidad+" WHERE id_bodega = ? AND id_producto = ?");
        q.setParameters(idBodega, idProducto);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para disminuir en una cantidad el número de productos almacenados de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return El número de tuplas modificadas
	 */
	public long disminuirProductoEnBodega(PersistenceManager pm, String idBodega, String idProducto, int cantidad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaAlmacenan() + " SET cantidad_producto = cantidad_producto - "+cantidad+" WHERE id_bodega = ? AND id_producto = ?");
        q.setParameters(idBodega, idProducto);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar un ALMACENAN de la base de datos de SuperAndes, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del produto
	 * @param idBodega - El identificador de la bodega
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarAlmacenan(PersistenceManager pm, int idProducto, int idBodega) 
	{
        Query sql = pm.newQuery(SQL, "DELETE FROM " +psa.darTablaAlbergan()+ " WHERE id_producto = ? AND id_bodega = ?");
        sql.setParameters(idProducto, idBodega);
        return (long) sql.executeUnique();            
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los ALMACENAN de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ALMACENAN
	 */
	public List<Almacenan> darAlmacenan(PersistenceManager pm)
	{
		Query sql = pm.newQuery(SQL, "SELECT * FROM " +psa.darTablaAlmacenan());
		sql.setResultClass(Almacenan.class);
		return (List<Almacenan>) sql.execute();
	}
}
