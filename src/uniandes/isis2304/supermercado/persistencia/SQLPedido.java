package uniandes.isis2304.supermercado.persistencia;

import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLPedido 
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
	public SQLPedido(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PEDIDO a la base de datos de SuperAndes
	 * @param idPedido - El identificador del pedido
	 * @param idSucursal - El identificador de la sucursal
	 * @param idProveedor - El identificaddor del proveedor
	 * @param idProducto - El identificador del producto
	 * @param fechaEsperaEntrega - La fecha esperada de entrega
	 * @param cantidad - La cantidad de producto a pedir
	 * @param precioTotal - El precio total del pedido
	 * @param fechaEntrega - La fecha de entrega del pedido
	 * @param calidadProductos - La calidad del producto
	 * @param estado - El estado actual del pedido
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarPedido(PersistenceManager pm, int idPedido, int idSucursal, int idProveedor, int idProducto, Timestamp fechaEsperaEntrega, int cantidad, double precioTotal, Timestamp fechaEntrega, int calidadProductos, String estado)
	{
		 Query sql = pm.newQuery(SQL, "INSERT INTO " +psa.darTablaPedido() + "(id_pedido, id_sucursal, id_provedor, id_producto, fecha_espera_entrega, cantidad, precio_total, fecha_entrega, calidad_productos, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		 sql.setParameters(idPedido, idSucursal, idProveedor, idProducto, fechaEsperaEntrega, cantidad, precioTotal, fechaEntrega, calidadProductos, estado);
		 return (long) sql.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PEDIDO a la base de datos de SuperAndes
	 * @param idPedido - El identificador del pedido
	 * @param idSucursal - El identificador de la sucursal
	 * @return EL número de tuplas insertadas
	 */
	public long llegadaPedido(PersistenceManager pm, int idPedido, int idSucursal, int idProveedor, String estado)
	{
		Query sql = pm.newQuery(SQL, "DELETE FROM" +psa.darTablaPedido() + "WHERE id_pedido = ? AND id_sucursal = ? AND id_proveedor = ?");
		sql.setParameters(idPedido, idSucursal, idProveedor, estado);
		return (long) sql.executeUnique();
	}
	
	
	
}
