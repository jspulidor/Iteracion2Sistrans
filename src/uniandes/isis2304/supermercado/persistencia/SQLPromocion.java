package uniandes.isis2304.supermercado.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.supermercado.persistencia.*;

class SQLPromocion 
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
	public SQLPromocion(PersistenciaSuperAndes psa)
	{
		this.psa = psa;
	}
	
	public long adicionarPromocion(PersistenceManager pm, int idPromocion, int idSucursal, Timestamp fechaInicio, Timestamp fechaFinal, int cantidadProductos, double precioFinal)
	{
		Query sql = pm.newQuery(SQL, "INSERT INTO "+psa.darTablaPromociones() + "(idPromocion, idSucursal, fechaInicio, fechaFinal, cantidadProductos, precioTotal) values (?, ?, ?, ?, ?, ?)");
		sql.setParameters(idPromocion, idSucursal, fechaInicio, fechaFinal, cantidadProductos, precioFinal);
		return (long) sql.executeUnique();
	}
}
