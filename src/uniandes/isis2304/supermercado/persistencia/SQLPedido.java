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
	 * @param
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarPedido(PersistenceManager pm, int idPedido, int idSucursal, int idProveedor, int idProducto, Timestamp fechaEsperaEntrega, int cantidad, double precioTotal, Timestamp fechaEntrega, int calidadProductos, String estado)
	{
		 Query sql = pm.newQuery(SQL, "INSERT INTO " +psa.darTablaPedido()+ "(idPedido, idSucursal, idProvedor, idProducto, fechaEsperaEntrega, cantidad, precioTotal, fechaEntrega, calidadProductos, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		 sql.setParameters(idPedido, idSucursal, idProveedor, idProducto, fechaEsperaEntrega, cantidad, precioTotal, fechaEntrega, calidadProductos, estado);
		 return (long) sql.executeUnique();
	}

}
