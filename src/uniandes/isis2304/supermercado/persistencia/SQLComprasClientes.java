package uniandes.isis2304.supermercado.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercados.negocio.ComprasClientes;

class SQLComprasClientes 
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
	public SQLComprasClientes(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar una COMPRASCLIENTES a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @param idCliente - El identificador del cliente
	 * @param idFactura - El identificador de la factura
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarCompraCliente(PersistenceManager pm, int idCliente, int idFactura)
	{
		 Query sql = pm.newQuery(SQL, "INSERT INTO " +psa.darTablaAlbergan()+ "(idCliente, idFactura) values (?, ?)");	
		 sql.setParameters(idCliente, idFactura);
		 return (long)sql.executeUnique();   
	}
}
