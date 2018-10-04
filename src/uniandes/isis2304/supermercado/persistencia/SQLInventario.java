package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.i;

class SQLInventario 
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
	public SQLInventario(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un INVENTARIO a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idSucursal - El identificador de la sucursal
	 * @param idProducto - El identificador del producto
	 * @param cantidad - La cantidad nueva 
	 * @param precioUnitario - El precio del producto
	 * @param precioPorPedida - El precip por medida de producto
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarInventario(PersistenceManager pm, int idSucursal, int idProducto, int cantidad, double precioUnitario, double precioPorPedida)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO" +psa.darTablaInventario()+ "(id_sucursal, id_producto, cantidad, precio_unitario, precio_por_medida");
		sql.setParameters(idSucursal, idProducto, cantidad, precioUnitario, precioPorPedida);
		return (long) sql.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para aumentar en una cantidad el número de productos en el INVENTARIO de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return El número de tuplas modificadas
	 */
	public long aumentarInventario(PersistenceManager pm, int idSucursal, int idProducto, int cantidad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaInventario() + " SET cantidad = cantidad + "+cantidad+" WHERE id_sucursal = ? AND id_producto = ?");
        q.setParameters(idSucursal, idProducto, cantidad);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para disminuir en una cantidad el número de productos en el INVENTARIO de la 
	 * base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @return El número de tuplas modificadas
	 */
	public long disminuirInventario(PersistenceManager pm, int idSucursal, int idProducto, int cantidad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + psa.darTablaInventario() + " SET cantidad = cantidad - "+cantidad+" WHERE id_sucursal = ? AND id_producto = ?");
        q.setParameters(idSucursal, idProducto, cantidad);
        return (long) q.executeUnique();
	}
}
