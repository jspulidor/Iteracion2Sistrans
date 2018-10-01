package uniandes.isis2304.supermercado.persistencia;

import java.math.BigDecimal;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercado.persistencia.*;
class SQLCliente 
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
	public SQLCliente(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un CLIENTE a la base de datos de SuperAndes
	 * @param pm - El manejador de persistencia
	 * @param idCliente - El identificador del bebedor
	 * @param nombre - El nombre del cliente
	 * @param correo - El correo del cliente
	 * @param ciudad - La ciudad del cliente
	 * @param direccion - La dirección del cliente
	 * @return EL número de tuplas insertadas
	 */	
	public long adicionarCliente(PersistenceManager pm, int idCliente, String nombre, String correo, String ciudad, String direccion)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaCliente() + "(id, nombre, correo, ciudad, direccion) values (?, ?, ? , ?, ?)");
		sql.setParameters(idCliente, nombre, correo, ciudad, direccion);
		return (long) sql.executeUnique();
	}
}
